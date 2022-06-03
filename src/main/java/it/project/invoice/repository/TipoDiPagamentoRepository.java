package it.project.invoice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.project.invoice.model.TipoDiPagamento;


public interface TipoDiPagamentoRepository extends CrudRepository<TipoDiPagamento, Long> {
	
}
