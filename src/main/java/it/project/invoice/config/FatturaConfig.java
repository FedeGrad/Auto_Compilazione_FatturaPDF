package it.project.invoice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.project.invoice.model.Articolo;
import it.project.invoice.repository.ArticoloRepository;

@Configuration
public class FatturaConfig {
	
	@Autowired
	ArticoloRepository artRepo;
	
//	@Bean(name = "acqua")
//	public void prodottoUno() {
//		Articolo acqua = new Articolo();
//		acqua.setDescrizione("acqua naturale levissima");
//		acqua.setImporto(1.5);
//		acqua.setNome("acqua");
//		acqua.setQuantita(10);
//		artRepo.save(acqua);
//	}

}
