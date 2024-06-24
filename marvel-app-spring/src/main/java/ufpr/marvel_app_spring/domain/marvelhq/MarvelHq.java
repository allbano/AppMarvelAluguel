package ufpr.marvel_app_spring.domain.marvelhq;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="marvelhq")
@Table(name="marvelhq")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MarvelHq {
	
	@Id
	@Column(name = "hq_id",nullable = false)
	private Long id;
	@Column(name = "hq_titulo",nullable = false)
	private String titulo;
	@Column(name = "hq_imagem",nullable = false)
	private String imagem;

//	public MarvelHq() {}
//	public MarvelHq(Long id, String titulo, String imagem) { this.id = id; this.titulo = titulo; this.imagem = imagem; }
//	
//	public Long getId() { return id; }
//	public String getTitulo() { return titulo; }
//	public String getImagem() { return imagem; }
//	
//	public void setId(Long id) { this.id = id; }
//	public void setTitulo(String titulo) { this.titulo = titulo; }
//	public void setImagem(String imagem) { this.imagem = imagem; }
	
	
	
	@Override
	public String toString() {
		return "MarvelHq [id=" + id + ", titulo=" + titulo + ", imagem=" + imagem + "]";
	}


	
	
}
