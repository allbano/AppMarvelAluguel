package ufpr.marvel_app_spring.domain.entity;

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


	
	
	
}
