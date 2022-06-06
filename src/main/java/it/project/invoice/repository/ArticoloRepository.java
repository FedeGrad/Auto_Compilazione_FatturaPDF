package it.project.invoice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.project.invoice.model.Articolo;

public interface ArticoloRepository extends JpaRepository<Articolo, Long> {

	public Articolo findByNome(String nome);
	public boolean existsByNome(String nome);
	public List<Articolo> findByImportoBetween(float importo1, float importo2);

}
