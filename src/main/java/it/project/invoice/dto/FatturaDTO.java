package it.project.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FatturaDTO {
	
	private Long idFattura;
	private String LocalDate;
	private Long idCliente;
	private String idRigaFattura;
	private Long idTipoPagamento;
	
}
