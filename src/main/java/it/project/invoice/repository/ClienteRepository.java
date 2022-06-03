package it.project.invoice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.project.invoice.model.Citta;
import it.project.invoice.model.Cliente;



public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	public boolean existsByCf(String cf);
	public boolean existsByCognome(String cognome);
	public List<Cliente> findByCitta(Citta citta);
	public List<Cliente> findByCf(String cf);
	public List<Cliente> findByCognome(String cognome);
	public Long deleteByCf(String cf);
	
}
