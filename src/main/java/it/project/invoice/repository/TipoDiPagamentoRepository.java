package it.project.invoice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.progetto.fattura.model.TipoDiPagamento;
import it.progetto.fattura.model.Tipologia;

public interface TipoDiPagamentoRepository extends CrudRepository<TipoDiPagamento, Long> {
	
}
