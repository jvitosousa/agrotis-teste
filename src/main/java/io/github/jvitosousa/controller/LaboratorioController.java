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

import io.github.jvitosousa.controller.dto.LaboratorioDTO;
import io.github.jvitosousa.domain.entity.Laboratorio;
import io.github.jvitosousa.domain.entity.Propriedade;
import io.github.jvitosousa.exception.RegraDeNegocioException;
import io.github.jvitosousa.service.LaboratorioService;

@RestController
@RequestMapping("/lab")
public class LaboratorioController {
	
	@Autowired
	LaboratorioService laboratorioService;
	
	@PostMapping
	public ResponseEntity<Laboratorio> createUser(@RequestBody LaboratorioDTO body) throws Exception {
		try {
			Laboratorio response = laboratorioService.createLab(body.toEntity());
			return new ResponseEntity<Laboratorio>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Laboratorio>> getLabs() {
		try {
			List<Laboratorio> response = laboratorioService.getLabs();
			return new ResponseEntity<List<Laboratorio>>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Laboratorio>> getLaboratorio(@PathVariable Long id) {
		try {
			Optional<Laboratorio> response = laboratorioService.getLaboratorio(id);
			if(response.isEmpty()) {
				return new ResponseEntity<Optional<Laboratorio>>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Optional<Laboratorio>>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<Laboratorio> updateLaboratorio(@RequestBody LaboratorioDTO body) throws Exception {
		try {
			Laboratorio response = laboratorioService.createLab(body.toEntity());
			return new ResponseEntity<Laboratorio>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePropriedade(@PathVariable Long id) {
		try {
			laboratorioService.deleteLaboratorio(id);
			return new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}


}
