package it.project.invoice.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import it.project.invoice.config.FatturaConfig;
import it.project.invoice.model.Articolo;
import it.project.invoice.repository.ArticoloRepository;

public class Runner implements ApplicationRunner {

	@Autowired
	ArticoloRepository artRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

//			Articolo acqua = new Articolo();
//			acqua.setDescrizione("acqua naturale levissima");
//			acqua.setImporto(1.5);
//			acqua.setNome("acqua");
//			acqua.setQuantita(10);
//			artRepo.save(acqua);
//	
		
	}

}
