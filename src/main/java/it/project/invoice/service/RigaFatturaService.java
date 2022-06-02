package it.project.invoice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import it.progetto.fattura.dto.FatturaRigheDTO;
import it.progetto.fattura.exception.ElementAlreadyPresentException;
import it.progetto.fattura.model.Fattura;
import it.progetto.fattura.model.RigaFattura;
import it.progetto.fattura.repository.RigaFatturaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RigaFatturaService {

	@Autowired
	RigaFatturaRepository rigaFattRepo;
	
	@Autowired
	FatturaService fatturaServ;

	public List<RigaFattura> associaRigheFattura(String stringaIdRigaFattura) {
	String[] righeFattura = stringaIdRigaFattura.split(",");
	List<RigaFattura> righeFatturaOttenute = new ArrayList<RigaFattura>();
	for (int i=0; i<righeFattura.length; i++) {
		RigaFattura riga = rigaFattRepo.findById(Long.parseLong(righeFattura[i])).get();
		righeFatturaOttenute.add(riga);
	}
	return righeFatturaOttenute;
	}
	
	public void inserisciRigheFattura(FatturaRigheDTO dto) throws ElementAlreadyPresentException {
		RigaFattura rigaFattura = new RigaFattura();
		BeanUtils.copyProperties(dto, rigaFattura);
		rigaFattRepo.save(rigaFattura);
		log.info("La riga è stata salvata");
		String id = Long.toString(dto.getIdFattura());
		ArrayList<Fattura> lista = (ArrayList<Fattura>) fatturaServ.associaFattura(id);
		rigaFattura.setFatture(lista.get(0));
		rigaFattRepo.save(rigaFattura);
	}

	public void modificaRigheFattura(FatturaRigheDTO dto) throws ElementAlreadyPresentException {
		if (rigaFattRepo.existsById(dto.getIdRigaFattura())) {
			RigaFattura fattura_riga = rigaFattRepo.findById(dto.getIdRigaFattura()).get();
			BeanUtils.copyProperties(dto, fattura_riga);
			rigaFattRepo.save(fattura_riga);
			log.info("La riga fattura con l'id " + dto.getIdRigaFattura() + " è stata modificata");
			String id = Long.toString(dto.getIdFattura());
			ArrayList<Fattura> lista = (ArrayList<Fattura>) fatturaServ.associaFattura(id);
			fattura_riga.setFatture(lista.get(0));
			rigaFattRepo.save(fattura_riga);
		} else {
			throw new NotFoundException("Il Cliente con l'id " + dto.getIdFattura() + " non è presente nel sistema");
		}
	}

	public void eliminaRigheFattura(Long id) {
		if (rigaFattRepo.existsById(id)) {
			log.info("La fattura n°" + id + " è stata eliminata");
			rigaFattRepo.deleteById(id);
		} else {
			throw new NotFoundException("La fattura n°" + id + " non presente nel sistema");
		}
	}

}
