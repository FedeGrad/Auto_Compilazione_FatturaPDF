package it.project.invoice.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fattura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;
	private LocalDate data;
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "id_pagamento", referencedColumnName = "id")
	private TipoDiPagamento pagamento;
	@OneToMany(mappedBy = "fattura",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<RigaFattura> rigaFattura = new ArrayList<RigaFattura>();
	
	private String aCaso; // da cancellare
}
