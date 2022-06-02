package it.project.invoice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import it.progetto.fattura.dto.CittaDTO;
import it.progetto.fattura.exception.ElementAlreadyPresentException;
import it.progetto.fattura.model.Citta;
import it.progetto.fattura.repository.CittaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CittaService {

	@Autowired
	CittaRepository cittaRepo;

	public Citta findByNome(String nome) {
		if(cittaRepo.existsByNome(nome)) {
			return cittaRepo.findByNome(nome);
		} else {
			return null;
		}
	}

	public Citta associaCitta(String nomeCitta) {
		if (cittaRepo.existsByNome(nomeCitta)) {
			Citta citta = cittaRepo.findByNome(nomeCitta);
			return citta;
		} else {
			throw new NotFoundException("la Citta " + nomeCitta + " non è presente nel sistema");
		}
	}

	public void aggiungiCitta(CittaDTO dto) throws ElementAlreadyPresentException {
		Citta citta = new Citta();
		if(!cittaRepo.existsByNome(dto.getNome())){
			BeanUtils.copyProperties(dto, citta);
			cittaRepo.save(citta);
			log.info("Citta "+ dto.getNome() +" salvato");
		} else {
			throw new ElementAlreadyPresentException("Citta "+dto.getNome()+" già presente nel sistema");
		}
	}

	public void modificaCitta(CittaDTO dto) {
		if(cittaRepo.existsByNome(dto.getNome())){
			Citta citta = cittaRepo.findByNome(dto.getNome());
			BeanUtils.copyProperties(dto, citta);
			cittaRepo.save(citta);
			log.info("Citta "+ dto.getNome() +" modificata");
		} else {
			throw new NotFoundException("Citta "+ dto.getNome() + " non presente nel sistema");
		}
	}

	public void eliminaCitta(String nome) {
		if(cittaRepo.existsByNome(nome)) {
			cittaRepo.deleteByNome(nome);
		} else {
			throw new NotFoundException("Citta "+ nome + " non presente nel sistema");
		}
	}



}
