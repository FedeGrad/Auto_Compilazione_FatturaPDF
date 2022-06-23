package it.project.invoice.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import it.project.invoice.model.Iva;
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
	private String numeroFattura;
//	private List<String> tipoPagamento;
//	private List<String> nomeArticolo;
	private double totaleParziale;
	private double totaleGenerale;
	private float sconto;
	@Enumerated(EnumType.STRING)
	private Iva ivaEnum;
	private String IVA;

	
}
