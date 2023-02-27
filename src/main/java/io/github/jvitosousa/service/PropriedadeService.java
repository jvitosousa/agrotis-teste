package io.github.jvitosousa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jvitosousa.domain.entity.Laboratorio;
import io.github.jvitosousa.domain.entity.Propriedade;
import io.github.jvitosousa.domain.entity.User;
import io.github.jvitosousa.domain.repositories.PropriedadeRepository;

@Service
public class PropriedadeService {

	
	@Autowired
	PropriedadeRepository propriedadeRepository;
	
	public Propriedade createPropriedade(Propriedade propriedade) {
		try {
			Propriedade result = propriedadeRepository.save(propriedade);
			return result;
		} catch (Exception e) {
			throw e; 
		}
	}
	
	public List<Propriedade> getPropriedades(){
		List<Propriedade> result = propriedadeRepository.findAll();
		return result;
	}
	
	public Optional<Propriedade> getPropriedade(Long id){
		Optional<Propriedade> result = propriedadeRepository.findById(id);
		return result;
	}
	
	public void deletePropriedade(Long id) {
		try {
			propriedadeRepository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
