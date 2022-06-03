package it.project.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.project.invoice.model.Citta;


public interface CittaRepository extends CrudRepository<Citta, String> {

	public boolean existsByNome(String nome);
	public Citta findByNome(String nome);
	public List<Citta> findByNazione(String nazione);
	public List<Citta> findByProvincia(String provincia);
	public Long deleteByNome(String nome);
}
