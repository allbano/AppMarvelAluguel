package ufpr.marvel_app_spring.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufpr.marvel_app_spring.domain.entity.Usuario;
import ufpr.marvel_app_spring.domain.entity.UsuarioRepository;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity getAllUsuarios() {
		var users = repository.findAll();
		return ResponseEntity.ok(users);
	}

}
