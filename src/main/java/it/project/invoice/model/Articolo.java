package it.project.invoice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descrizione;
	private double importo;
	private int quantita;
	@OneToMany(mappedBy = "articolo", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<RigaFattura> rigeFattura = new ArrayList<RigaFattura>();

}
