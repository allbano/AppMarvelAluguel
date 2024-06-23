package ufpr.marvel_app_spring.domain.marvelhq;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.validation.constraints.NotBlank;

public record RequestCreateMarvelHqDto(
        @NotBlank String titulo,
        @NotBlank String imagem,
        @NotBlank LocalDate dataDevolucao
) {
    public static RequestCreateMarvelHqDto of(
            @NotBlank String titulo,
            @NotBlank String imagem,
            @NotBlank String data_devolucao
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataDevolucao;
        try {
            dataDevolucao = LocalDate.parse(data_devolucao, formatter);
        } catch (DateTimeParseException e) {
            String msgError = "Invalid data_devolucao format. Expected format: YYYY-MM-DD. "
                    + "Original error message: " + e.getMessage();
            throw new IllegalArgumentException(msgError, e);
        }

        return new RequestCreateMarvelHqDto(titulo, imagem, dataDevolucao);
    }
}