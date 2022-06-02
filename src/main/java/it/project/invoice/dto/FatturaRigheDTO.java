package it.project.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FatturaRigheDTO {

	private Long idRigaFattura;
	private String descrizione;
	private int quantita;
	private double prezzo;
	private Long idFattura;
	
}
