package it.project.invoice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.project.invoice.dto.FatturaDTO;
import it.project.invoice.exception.ElementAlreadyPresentException;
import it.project.invoice.model.Citta;
import it.project.invoice.model.Fattura;
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
	
	public List<Fattura> associaFattura(String stringaIdFattura) {
	String[] fatture = stringaIdFattura.split(",");
	List<Fattura> fattureOttenute = new ArrayList<Fattura>();
	for (int i=0; i<fatture.length; i++) {
		if(fatturaRepo.existsById(Long.parseLong(fatture[i]))){
		Fattura fatturaT = fatturaRepo.findById(Long.parseLong(fatture[i])).get();
		fattureOttenute.add(fatturaT);
		} else {
			log.info("La fattura n°"+ fatture[i]+" non esiste");
		}
	}
	return fattureOttenute;
	}
	
	public void inserisciFattura(FatturaDTO dto) throws ElementAlreadyPresentException {
		Fattura fattura = new Fattura();
			BeanUtils.copyProperties(dto, fattura);
			fatturaRepo.save(fattura);
			log.info("La Fattura è stata salvata");
			Citta cittaTrovata = cittaServ.associaCitta(dto.getCittaNome());
			cliente.setCitta(cittaTrovata);
			ArrayList<Fattura> lista = (ArrayList<Fattura>) fatturaServ.associaFattura(dto.getIdFatture());
			for (Fattura fattura : lista) {
				cliente.getFatture().add(fattura);
			}
			clienteRepo.save(cliente);
	}


}
