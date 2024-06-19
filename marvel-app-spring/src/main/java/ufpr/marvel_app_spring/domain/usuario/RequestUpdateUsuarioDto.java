package ufpr.marvel_app_spring.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record RequestUpdateUsuarioDto(@NotBlank Long id,
		@NotBlank String nome, 
		@NotBlank String email,
		@NotBlank String senha,
		@NotBlank String telefone,
		String foto)
{}
