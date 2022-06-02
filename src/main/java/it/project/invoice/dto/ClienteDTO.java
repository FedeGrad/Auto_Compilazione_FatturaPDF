package it.project.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
	
	private Long id_cliente;
	private String cf;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String cittaNome;
	private String idFatture;
}
