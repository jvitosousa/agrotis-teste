package io.github.jvitosousa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jvitosousa.controller.dto.PropriedadeDTO;
import io.github.jvitosousa.domain.entity.Laboratorio;
import io.github.jvitosousa.domain.entity.Propriedade;
import io.github.jvitosousa.domain.entity.User;
import io.github.jvitosousa.exception.RegraDeNegocioException;
import io.github.jvitosousa.service.PropriedadeService;

@RestController
@RequestMapping("/propriedade")
public class PropriedadeController {
	
	@Autowired
	PropriedadeService propriedadeService;
	
	@PostMapping
	public ResponseEntity<Propriedade> createUser(@RequestBody PropriedadeDTO body) throws Exception {
		try {
			Propriedade response = propriedadeService.createPropriedade(body.toEntity());
			return new ResponseEntity<Propriedade>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Propriedade>> getPropriedades() {
		try {
			List<Propriedade> response = propriedadeService.getPropriedades();
			return new ResponseEntity<List<Propriedade>>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Propriedade>> getPropriedade(@PathVariable Long id) {
		try {
			Optional<Propriedade> response = propriedadeService.getPropriedade(id);
			if(response.isEmpty()) {
				return new ResponseEntity<Optional<Propriedade>>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Optional<Propriedade>>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<Propriedade> updateUser(@RequestBody PropriedadeDTO body) throws Exception {
		try {
			Propriedade response = propriedadeService.createPropriedade(body.toEntity());
			return new ResponseEntity<Propriedade>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePropriedade(@PathVariable Long id) {
		try {
			propriedadeService.deletePropriedade(id);
			return new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}


}
