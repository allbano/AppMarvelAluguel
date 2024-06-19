package ufpr.marvel_app_spring.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="usuarios")
@Table(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id",nullable = false)
	private Long id;
	@Column(name = "user_nome",nullable = false)
	private String nome;
	@Column(name = "user_email",nullable = false)
	private String email;
	@Column(name = "user_senha",nullable = false)
	private String senha;
	@Column(name = "user_telefone",nullable = false)
	private String telefone;
	@Column(name = "user_foto",nullable = true)
	private String foto;
	@Column(nullable = false)
	private Boolean active;
	
	
	public Usuario(RequestCreateUsuarioDto requestUsuarioDto) {
		this.nome = requestUsuarioDto.nome();
		this.email = requestUsuarioDto.email();
		this.senha = requestUsuarioDto.senha();
		this.telefone = requestUsuarioDto.telefone();
		this.foto = requestUsuarioDto.foto();
		this.active = true;
	}


	public Long getId() { return this.id; }
	public String getNome() { return this.nome; }
	public String getEmail() { return this.email; }
	public String getSenha() { return this.senha; }
	public String getTelefone() { return this.telefone; }
	public String getFoto() { return this.foto; }
	public Boolean getActive() { return this.active;}


	public void setId(Long id) { this.id = id; }
	public void setNome(String nome) { this.nome = nome; }
	public void setEmail(String email) { this.email = email; }
	public void setSenha(String senha) { this.senha = senha; } 
	public void setTelefone(String telefone) { this.telefone = telefone; }
	public void setFoto(String foto) { this.foto = foto; }
	public void setActive(boolean b) { this.active = b; }

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefone="
				+ telefone + ", foto=" + foto + "]";
	}


	
	
	
	
	


	
}
