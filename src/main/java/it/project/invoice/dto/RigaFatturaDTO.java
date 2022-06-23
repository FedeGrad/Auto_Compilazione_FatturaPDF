package it.project.invoice.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import it.project.invoice.model.Iva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RigaFatturaDTO {
	
//	private String descrizione;
	private String nomeArticolo;
	private int quantita;
	private double prezzoUnitario;
	private float sconto;
	private double importoParziale;
//	private Long idFattura;
	
}
