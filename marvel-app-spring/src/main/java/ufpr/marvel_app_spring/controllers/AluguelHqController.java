package ufpr.marvel_app_spring.controllers;

import java.net.URI;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import ufpr.marvel_app_spring.domain.aluguelhq.AluguelHq;
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
