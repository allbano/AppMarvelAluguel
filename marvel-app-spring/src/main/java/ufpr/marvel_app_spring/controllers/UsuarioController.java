package ufpr.marvel_app_spring.controllers;


import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import ufpr.marvel_app_spring.domain.usuario.RequestCreateUsuarioDto;
import ufpr.marvel_app_spring.domain.usuario.RequestUpdateUsuarioDto;
import ufpr.marvel_app_spring.domain.usuario.Usuario;
import ufpr.marvel_app_spring.domain.usuario.UsuarioRepository;


@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/list")
	public ResponseEntity getAllUsers() {
		var usuarios = repository.findAllByActiveTrue();
		return ResponseEntity.ok(usuarios);
	}
	
	@PostMapping()
	public ResponseEntity createUser(@RequestBody @Valid RequestCreateUsuarioDto data) {
		Usuario novoUsuario = new Usuario(data);
		repository.save(novoUsuario);
		return ResponseEntity.ok().build();		
	}
	@PutMapping()
	@Transactional
	public ResponseEntity updateUser(@RequestBody @Valid RequestUpdateUsuarioDto data) {
		Optional<Usuario> optionalUser = repository.findById(data.id());
		if (optionalUser.isPresent()) {
			Usuario updateUsuario = optionalUser.get();
			updateUsuario.setNome(data.nome());
			updateUsuario.setEmail(data.email());
			updateUsuario.setSenha(data.senha());
			updateUsuario.setTelefone(data.telefone());
			updateUsuario.setFoto(data.foto());
			return ResponseEntity.ok(updateUsuario);
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deleteUser(@PathVariable Long id) {
		//repository.deleteById(id);
		Optional<Usuario> optionalUser = repository.findById(id);
		if (optionalUser.isPresent()) {
			Usuario updateUsuario = optionalUser.get();
			updateUsuario.setActive(false);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}	
	}

}







