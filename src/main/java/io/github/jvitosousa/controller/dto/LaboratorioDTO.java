package io.github.jvitosousa.controller.dto;

import io.github.jvitosousa.domain.entity.Laboratorio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaboratorioDTO {
	
	private Long id;
	private String nome;
	
	public Laboratorio toEntity() {
		return new Laboratorio(this.id, this.nome);
	}

}
