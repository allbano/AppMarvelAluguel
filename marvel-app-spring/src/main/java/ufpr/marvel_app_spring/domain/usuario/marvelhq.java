package ufpr.marvel_app_spring.domain.usuario;

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
public class marvelhq {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hq_id")
	private Long id;
	@Column(name = "hq_titulo")
	private String titulo;
	@Column(name = "hq_imagem")
	private String imagem;
	@Column(name = "hq_data_devolucao")
	private LocalDate data_devolucao;
	
	@ManyToOne
	private Usuario user;

}
