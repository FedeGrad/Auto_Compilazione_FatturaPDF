package it.project.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CittaDTO {
	
	private String cap;
	private String nome;
	private String provincia;
	private String nazione;

}
