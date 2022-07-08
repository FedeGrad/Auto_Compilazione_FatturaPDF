package it.project.invoice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.project.invoice.model.Citta;
import it.project.invoice.model.Cliente;



public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	public boolean existsByCognome(String cognome);
	public List<Cliente> findByCognome(String cognome);
//	public Cliente findByPIVA(String pIVA);
//	public boolean existsByPIVA(String pIVA);
//	public Long deleteByPIVA(String pIVA);
	
}
