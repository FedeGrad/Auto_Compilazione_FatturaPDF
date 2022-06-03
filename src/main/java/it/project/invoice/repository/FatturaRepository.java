package it.project.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.project.invoice.model.Fattura;


public interface FatturaRepository extends CrudRepository<Fattura, Long> {
	
	@Query(value = "SELECT * FROM fattura WHERE id_cliente = ?1", nativeQuery = true)
	public List<Fattura> findByCliente(String id_cliente);
	
	@Query(value = "SELECT * FROM fattura WHERE id_pagamento = ?1", nativeQuery = true)
	public List<Fattura> findByPagamento(String id_pagamento);
}
	
