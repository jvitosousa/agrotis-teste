package io.github.jvitosousa.controller.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.github.jvitosousa.domain.entity.Laboratorio;
import io.github.jvitosousa.domain.entity.Propriedade;
import io.github.jvitosousa.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String nome;
	private String CNPJ;
	private String observacoes;
	private String dataInicial;
	private String dataFinal;
	private PropriedadeDTO proriedade;
	private LaboratorioDTO laboratorio;

	public User toEtity() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		return new User(null, this.nome, this.CNPJ, this.observacoes, formatter.parse(this.dataInicial), formatter.parse(this.dataFinal),
				new Propriedade(this.proriedade.getId(), this.proriedade.getNome()),
				this.laboratorio.toEntity());
	}
}
