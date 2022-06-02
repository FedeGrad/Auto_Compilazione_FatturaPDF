package it.project.invoice.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citta {
	
// nuovo commento per federico
	@Id
	@NotNull
	@Column(nullable = false)
	private String cap;
	private String nome;
	private String federico;
	private String provincia;
	private String nazione;
	@OneToMany(mappedBy = "citta", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<Cliente> clienti = new ArrayList<Cliente>();

}
