package ufpr.marvel_app_spring.domain.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
	List<Usuario> findAll();

}
