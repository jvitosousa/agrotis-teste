package io.github.jvitosousa.controller.dto;

import io.github.jvitosousa.domain.entity.Propriedade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropriedadeDTO {
	
	private Long id;
	private String nome;

	public Propriedade toEntity() {
		return new Propriedade(this.id, this.nome);
	}
}
