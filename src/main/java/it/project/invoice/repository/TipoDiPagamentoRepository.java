package it.project.invoice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.project.invoice.model.TipoDiPagamento;
import it.project.invoice.model.Tipologia;


public interface TipoDiPagamentoRepository extends CrudRepository<TipoDiPagamento, Long> {
	
	public List<TipoDiPagamento> findByTipologia(Tipologia tipologia);
	
}
