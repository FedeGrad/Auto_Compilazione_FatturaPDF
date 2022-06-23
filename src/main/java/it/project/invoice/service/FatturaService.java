package it.project.invoice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.project.invoice.dto.FatturaDTO;
import it.project.invoice.exception.ElementAlreadyPresentException;
import it.project.invoice.exception.NotFoundException;
import it.project.invoice.model.Fattura;
import it.project.invoice.model.Iva;
import it.project.invoice.model.RigaFattura;
import it.project.invoice.repository.ClienteRepository;
import it.project.invoice.repository.FatturaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FatturaService {

	@Autowired
	FatturaRepository fatturaRepo;
	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	RigaFatturaService rigaFatServ;

//	public List<Fattura> associaFattura(String stringaIdFattura) {
//		String[] fatture = stringaIdFattura.split(",");
//		List<Fattura> fattureOttenute = new ArrayList<Fattura>();
//		for (int i = 0; i < fatture.length; i++) {
//			if (fatturaRepo.existsById(Long.parseLong(fatture[i]))) {
//				Fattura fatturaT = fatturaRepo.findById(Long.parseLong(fatture[i])).get();
//				fattureOttenute.add(fatturaT);
//			} else {
//				log.info("La fattura n°" + fatture[i] + " non esiste");
//			}
//		}
//		return fattureOttenute;
//	}

	public void inserisciFattura(FatturaDTO dto, RigaFattura...righe) throws ElementAlreadyPresentException, NotFoundException {
		Fattura fattura = new Fattura();
		BeanUtils.copyProperties(dto, fattura);
//		RigaFattura riga = new RigaFattura();
		
		switch(dto.getIVA().toLowerCase()) {
			case "esente":
				fattura.setIVA(Iva.ESENTE);
				break;
			case "ridotta":
				fattura.setIVA(Iva.RIDOTTA);
				break;
			case "ordinaria":
				fattura.setIVA(Iva.ORDINARIA);
				break;
			default:
				throw new NotFoundException("IVA errata");
		}
		for (RigaFattura rigaFattura : righe) {
			fattura.getRigaFattura().add(rigaFattura);
		}
		fatturaRepo.save(fattura);
		log.info("La Fattura è stata salvata");
	}

}
