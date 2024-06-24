package ufpr.marvel_app_spring.domain.aluguelhq;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufpr.marvel_app_spring.domain.marvelhq.MarvelHq;
import ufpr.marvel_app_spring.domain.usuario.Usuario;


@Entity(name = "aluguelhq")
@Table(name = "aluguelhq")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AluguelHq {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aluguel_id")
    private Long aluguelHqId;

    @ManyToOne
    @JoinColumn(name = "aluguelhq_usuario_id",referencedColumnName = "user_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "aluguelhq_marvelhq_id", referencedColumnName = "hq_id")
    private MarvelHq marvelHq;

    @Column(name = "aluguelhq_data_devolucao")
    private Date dataDevolucao;
}
