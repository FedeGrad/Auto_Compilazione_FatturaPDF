package it.project.invoice.service;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.project.invoice.dto.ClienteDTO;
import it.project.invoice.dto.ClienteUpdateDTO;
import it.project.invoice.model.Citta;
import it.project.invoice.model.Cliente;
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

	public void inserisciCliente(ClienteDTO dto) throws Exception {
		Cliente cliente = new Cliente();
		if (!clienteRepo.existsByCognome(dto.getCognome())) {
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
			throw new Exception(
					"Il Cliente " + cliente.getNome() + " " + cliente.getCognome() + " è già presente nel sistema");
		}
	}

	public void modificaCliente(ClienteUpdateDTO dto) throws Exception {
		if (clienteRepo.existsById(dto.getId_cliente())) {
			Cliente cliente = clienteRepo.findById(dto.getId_cliente()).get();
			BeanUtils.copyProperties(dto, cliente);
			clienteRepo.save(cliente);
			log.info("Il Cliente con l'id" + dto.getId_cliente() + ", è stato modificato");
			Citta cittaTrovata = cittaServ.associaCitta(dto.getCittaNome());
			cliente.setCitta(cittaTrovata);
//			ArrayList<Fattura> lista = (ArrayList<Fattura>) fatturaServ.associaFattura(dto.getIdFatture());
//			for (Fattura fattura : lista) {
//				cliente.getFatture().add(fattura);
//			}
			clienteRepo.save(cliente);
		} else {
			throw new Exception("Il cliente con l'id " + dto.getId_cliente() + " non è presente nel sistema");
		}
	}

	public void eliminaCliente(Long id) throws Exception {
		if (clienteRepo.existsById(id)) {
			Cliente cli = clienteRepo.findById(id).get();
			log.info("Il cliente" + cli.getCognome() + " è stato eliminato");
			clienteRepo.deleteById(id);
		} else {
			throw new Exception("Il Cliente con l'id " + id + " non presente nel sistema");
		}
	}

}
