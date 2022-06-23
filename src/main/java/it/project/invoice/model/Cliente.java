package it.project.invoice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;
	@NotNull
	@Column(nullable = false)
	private String pIVA;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String civico;
	@ManyToOne
	@JoinColumn(name = "id_citta", referencedColumnName = "cap")
	private Citta citta;
	@OneToMany(mappedBy = "cliente", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<Fattura> fatture = new ArrayList<Fattura>();

}
