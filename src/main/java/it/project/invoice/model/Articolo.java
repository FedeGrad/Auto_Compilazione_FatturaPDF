package it.project.invoice.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articolo {
	
	private Long id;
	private String nome;
	private String descrizione;
	private double importo;
	private int quantita;

}
