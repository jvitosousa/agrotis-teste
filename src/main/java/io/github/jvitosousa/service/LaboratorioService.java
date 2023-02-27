package io.github.jvitosousa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jvitosousa.domain.entity.Laboratorio;
import io.github.jvitosousa.domain.entity.Propriedade;
import io.github.jvitosousa.domain.repositories.LaboratorioRespository;

@Service
public class LaboratorioService {

	
	@Autowired
	LaboratorioRespository laboratorioRespository;
	
	public Laboratorio createLab(Laboratorio lab) {
		try {
			Laboratorio result = laboratorioRespository.save(lab);
			return result;
		} catch (Exception e) {
			throw e; 
		}
	}
	
	public List<Laboratorio> getLabs(){
		List<Laboratorio> labs = laboratorioRespository.findAll();
		return labs;
	}
	
	public Optional<Laboratorio> getLaboratorio(Long id){
		Optional<Laboratorio> result = laboratorioRespository.findById(id);
		return result;
	}
	
	public void deleteLaboratorio(Long id) {
		try {
			laboratorioRespository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
	}
}
