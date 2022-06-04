package it.project.invoice.service;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.project.invoice.dto.ClienteDTO;
import it.project.invoice.exception.ElementAlreadyPresentException;
import it.project.invoice.exception.NotFoundException;
import it.project.invoice.model.Citta;
import it.project.invoice.model.Cliente;
import it.project.invoice.model.Fattura;
import it.project.invoice.repository.CittaRepository;
import it.project.invoice.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	CittaRepository cittaRepo;
	@Autowired
	FatturaService fatturaServ;
	@Autowired
	CittaService cittaServ;

	public void inserisciCliente(ClienteDTO dto) throws ElementAlreadyPresentException, NotFoundException {
		Cliente cliente = new Cliente();
		if (!clienteRepo.existsByCf(dto.getCf())) {
			BeanUtils.copyProperties(dto, cliente);
			clienteRepo.save(cliente);
			log.info("Il Cliente " + cliente.getNome() + " " + cliente.getCognome() + " è stato salvato");
			Citta cittaTrovata = cittaServ.associaCitta(dto.getCittaNome());
			cliente.setCitta(cittaTrovata);
//			ArrayList<Fattura> lista = (ArrayList<Fattura>) fatturaServ.associaFattura(dto.getIdFatture());
//			for (Fattura fattura : lista) {
//				cliente.getFatture().add(fattura);
//			}
			clienteRepo.save(cliente);
		} else {
			throw new ElementAlreadyPresentException(
					"Il Cliente " + cliente.getNome() + " " + cliente.getCognome() + " è già presente nel sistema");
		}
	}

	public void modificaCliente(ClienteDTO dto) throws ElementAlreadyPresentException, NotFoundException {
		if (clienteRepo.existsById(dto.getId_cliente())) {
			Cliente cliente = clienteRepo.findById(dto.getId_cliente()).get();
			BeanUtils.copyProperties(dto, cliente);
			clienteRepo.save(cliente);
			log.info("Il Cliente con l'id" + dto.getIdFatture() + ", è stato modificato");
			Citta cittaTrovata = cittaServ.associaCitta(dto.getCittaNome());
			cliente.setCitta(cittaTrovata);
//			ArrayList<Fattura> lista = (ArrayList<Fattura>) fatturaServ.associaFattura(dto.getIdFatture());
//			for (Fattura fattura : lista) {
//				cliente.getFatture().add(fattura);
//			}
			clienteRepo.save(cliente);
		} else {
			throw new NotFoundException("Il cliente con l'id " + dto.getId_cliente() + " non è presente nel sistema");
		}
	}

	public void eliminaCliente(Long id) throws NotFoundException {
		if (clienteRepo.existsById(id)) {
			Cliente cli = clienteRepo.findById(id).get();
			log.info("Il cliente" + cli.getCognome() + " è stato eliminato");
			clienteRepo.deleteById(id);
		} else {
			throw new NotFoundException("Il Cliente con l'id " + id + " non presente nel sistema");
		}
	}

}
