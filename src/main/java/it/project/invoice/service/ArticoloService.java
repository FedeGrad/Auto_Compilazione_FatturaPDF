package it.project.invoice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.project.invoice.dto.ArticoloDTO;
import it.project.invoice.dto.ArticoloUpdateDTO;
import it.project.invoice.dto.ClienteDTO;
import it.project.invoice.dto.ClienteUpdateDTO;
import it.project.invoice.exception.ElementAlreadyPresentException;
import it.project.invoice.exception.NotFoundException;
import it.project.invoice.model.Articolo;
import it.project.invoice.model.Citta;
import it.project.invoice.model.Cliente;
import it.project.invoice.repository.ArticoloRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticoloService {

	@Autowired
	ArticoloRepository articoloRepo;
	

	public void inserisciArticolo(ArticoloDTO dto) throws ElementAlreadyPresentException, NotFoundException {
		Articolo articolo = new Articolo();
		if (!articoloRepo.existsByNome(dto.getNome())) {
			BeanUtils.copyProperties(dto, articolo);
			articoloRepo.save(articolo);
			log.info("Articolo inserito");
		} else {
			throw new ElementAlreadyPresentException("L'articolo " + dto.getNome() + " è già presente nel sistema");
		}
	}

	public void modificaArticolo(ArticoloUpdateDTO dto) throws ElementAlreadyPresentException, NotFoundException {
		if (articoloRepo.existsById(dto.getIdArticolo())) {
			Articolo articolo = articoloRepo.findByNome(dto.getNome());
			BeanUtils.copyProperties(dto, articolo);
			articoloRepo.save(articolo);
			log.info("Articolo modificato");
		} else {
			throw new NotFoundException("L'articolo con l'id " + dto.getIdArticolo() + " non è presente nel sistema");
		}
	}

	public void eliminaArticolo(Long id) throws NotFoundException {
		if (articoloRepo.existsById(id)) {
			Articolo articolo = articoloRepo.findById(id).get();
			log.info("L'articolo" + articolo.getNome() + " è stato eliminato");
			articoloRepo.deleteById(id);
		} else {
			throw new NotFoundException("L'articolo con l'id " + id + " non presente nel sistema");
		}
	}

}
