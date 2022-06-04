package it.project.invoice.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FatturaDTO {
	
	
static final String DATE_PATTERN = "dd/MM/yyyy";
	
	@Schema(example = "20/01/2000", type = "string")
	@JsonFormat(pattern = DATE_PATTERN)
	private LocalDate dataFattura;
	private Long idCliente;
	private String idRigaFattura;
	private Long idTipoPagamento;
	
}
