package ufpr.marvel_app_spring.controllers;


import jakarta.validation.Valid;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
	public ResponseEntity<?> getAllUsers() {
		var usuarios = repository.findAllByActiveTrue();
		return ResponseEntity.ok(usuarios);
	}
    @Operation(description = "Operação para persistir o usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário salvo com sucesso"),
            @ApiResponse(responseCode = "417", description = "Algum erro de validação de dados ocorreu"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody @Valid RequestCreateUsuarioDto data) {
		Usuario novoUsuario = new Usuario(data);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoUsuario.getId()).toUri();
		return ResponseEntity.created(location).body(novoUsuario);		
	}
	@PutMapping()
	@Transactional
	public ResponseEntity<?> updateUser(@RequestBody @Valid RequestUpdateUsuarioDto data) {
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
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		//repository.deleteById(id);
		Optional<Usuario> optionalUser = repository.findById(id);
		if (optionalUser.isPresent()) {
			Usuario updateUsuario = optionalUser.get();
			updateUsuario.setActive(false);
			return ResponseEntity.ok(updateUsuario);
		} else {
			return ResponseEntity.notFound().build();
		}	
	}

}







