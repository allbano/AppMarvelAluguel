package ufpr.marvel_app_spring.domain.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findAllByActiveTrue();

}
