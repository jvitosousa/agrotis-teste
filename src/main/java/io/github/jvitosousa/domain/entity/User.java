package io.github.jvitosousa.domain.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "id")
	private Integer id;
	
	@Column(name = "nome", length = 100)
	private String nome;
	@Column(name = "cnpj", unique = true)
	private String CNPJ;
	@Column(name = "observacoes", length = 100)
	private String observacoes;
	@Temporal(TemporalType.DATE)
	private Date dataInicial;
	@Temporal(TemporalType.DATE)
	private Date dataFinal;
	
	@OneToOne()
	@JoinColumn(name = "propriedadeId", referencedColumnName = "id")
	private Propriedade proriedade;
	
	@OneToOne()
	@JoinColumn(name = "laboratorioId", referencedColumnName = "id")
	private Laboratorio laboratorio;
	

}
