package it.project.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticoloUpdateDTO {
	
	private Long idArticolo;
	private String nome;
	private double importo;
	private int quantita;

}
