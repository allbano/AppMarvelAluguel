package ufpr.marvel_app_spring.domain.marvelhq;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="marvelhq")
@Table(name="marvelhq")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MarvelHq {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hq_id",nullable = false)
	private Long id;
	@Column(name = "hq_titulo",nullable = false)
	private String titulo;
	@Column(name = "hq_imagem",nullable = false)
	private String imagem;
	@Column(name = "hq_data_devolucao",nullable = false)
	private LocalDate data_devolucao;

	public MarvelHq(RequestCreateMarvelHqDto requestMarvelHqDto) {
		this.titulo = requestMarvelHqDto.titulo();
		this.imagem = requestMarvelHqDto.imagem();
		this.data_devolucao = requestMarvelHqDto.dataDevolucao();
		
	}

	@Override
	public String toString() {
		return "MarvelHq [id=" + id + ", titulo=" + titulo + ", imagem=" + imagem + ", data_devolucao=" + data_devolucao
				+ "]";
	}
	
	
}
