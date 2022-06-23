package it.project.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
	
	private String pIVA;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String cittaNome;
	
}
