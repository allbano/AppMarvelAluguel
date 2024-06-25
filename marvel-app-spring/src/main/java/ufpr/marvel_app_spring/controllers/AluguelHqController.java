package ufpr.marvel_app_spring.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import ufpr.marvel_app_spring.domain.aluguelhq.AluguelHq;
import ufpr.marvel_app_spring.domain.aluguelhq.AluguelHqComDetalhesDto;
import ufpr.marvel_app_spring.domain.aluguelhq.AluguelHqComDetalhesViewRepository;
import ufpr.marvel_app_spring.domain.aluguelhq.RequestCreateAluguelHqDto;
import ufpr.marvel_app_spring.domain.marvelhq.MarvelHq;
import ufpr.marvel_app_spring.domain.usuario.UsuarioRepository;
import ufpr.marvel_app_spring.services.AluguelHqService;
import ufpr.marvel_app_spring.services.MarvelHqService;



@RestController
@RequestMapping("/v1/alugueis")
public class AluguelHqController {
	
	Logger logger = LoggerFactory.getLogger(AluguelHqController.class);
	
	@Autowired
	private AluguelHqService aluguelHqService;	
	@Autowired
	private MarvelHqService marvelHqService;
	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
	private AluguelHqComDetalhesViewRepository aluguelDtoRepository;
	
	@GetMapping("/list/{id}")
	public ResponseEntity<?> getAllAlugueisUsuario(@PathVariable Long id) {
		try {
	        // Busca todos os usuários ativos
	        List<AluguelHqComDetalhesDto> alugueis = aluguelDtoRepository.findByUsuarioId(id);

	        // Verifica se a lista de usuários está vazia
	        if (alugueis.isEmpty()) {
	            // Retorna 204 No Content se não houver usuários ativos
	            return ResponseEntity.noContent().build();
	        } else {
	            // Retorna 200 OK com a lista de usuários ativos
	            return ResponseEntity.ok(alugueis);
	        }
	    } catch (Exception e) {
	        // Em caso de erro, retorna 500 Internal Server Error com a mensagem de erro
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Ocorreu um erro ao buscar os usuários: " + e.getMessage());
	    }	
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> createAluguel(@RequestBody @Valid RequestCreateAluguelHqDto data) {
	
		try {
			boolean user = userRepository.findById(data.id_user()).isPresent();
			MarvelHq novoHq = new MarvelHq(data.id_hq(),data.titulo(),data.imagem());
			MarvelHq savedHq = marvelHqService.save(novoHq);
			if((user) && (savedHq != null) ) {				
				AluguelHq novoAluguel = new AluguelHq();
				novoAluguel.setAluguelHqIdUser(data.id_user());
				novoAluguel.setAluguelHqIdHq(data.id_hq());
				LocalDate date = aluguelHqService.setDataDevolucao(data.data_devolucao());
				novoAluguel.setDataDevolucao(date);
				AluguelHq savedAluguel = aluguelHqService.save(novoAluguel);
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	                    .buildAndExpand(savedAluguel.getId()).toUri();
				return ResponseEntity.created(location).body(savedAluguel);
			}
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Erro ao salvar AluguelHq: " + e.getMessage());
            return ResponseEntity.badRequest().build();
		}
	}

	
}
