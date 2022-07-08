package it.project.invoice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.project.invoice.dto.RigaFatturaDTO;
import it.project.invoice.model.Articolo;
import it.project.invoice.model.Fattura;
import it.project.invoice.model.Iva;
import it.project.invoice.model.RigaFattura;
import it.project.invoice.model.TipoDiPagamento;
import it.project.invoice.repository.ArticoloRepository;
import it.project.invoice.repository.RigaFatturaRepository;
import it.project.invoice.repository.TipoDiPagamentoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RigaFatturaService {

	@Autowired
	RigaFatturaRepository rigaFattRepo;
	@Autowired
	ArticoloRepository articoloRepo;
	@Autowired
	TipoDiPagamentoRepository tipoPagamRepo;
	

	public RigaFattura associaRigheFattura(RigaFatturaDTO dto) throws Exception {
		RigaFattura newRiga = new RigaFattura();
		BeanUtils.copyProperties(dto, newRiga);
		Articolo articolo = articoloRepo.findByNome(dto.getNomeArticolo());
		newRiga.setArticolo(articolo);
		return newRiga;
	}
	
//	public void inserisciRigheFattura(FatturaRigheDTO dto) throws ElementAlreadyPresentException {
//		RigaFattura rigaFattura = new RigaFattura();
//		BeanUtils.copyProperties(dto, rigaFattura);
//		rigaFattRepo.save(rigaFattura);
//		log.info("La riga è stata salvata");
//		rigaFattRepo.save(rigaFattura);
//	}

//	public void modificaRigheFattura(FatturaRigheDTO dto) throws ElementAlreadyPresentException, NotFoundException {
//		if (rigaFattRepo.existsById(dto.getIdRigaFattura())) {
//			RigaFattura fattura_riga = rigaFattRepo.findById(dto.getIdRigaFattura()).get();
//			BeanUtils.copyProperties(dto, fattura_riga);
//			rigaFattRepo.save(fattura_riga);
//			log.info("La riga fattura con l'id " + dto.getIdRigaFattura() + " è stata modificata");
//			rigaFattRepo.save(fattura_riga);
//		} else {
//			throw new NotFoundException("Il Cliente con l'id " + dto.getIdFattura() + " non è presente nel sistema");
//		}
//	}
//
//	public void eliminaRigheFattura(Long id) throws NotFoundException {
//		if (rigaFattRepo.existsById(id)) {
//			log.info("La fattura n°" + id + " è stata eliminata");
//			rigaFattRepo.deleteById(id);
//		} else {
//			throw new NotFoundException("La fattura n°" + id + " non presente nel sistema");
//		}
//	}

}
