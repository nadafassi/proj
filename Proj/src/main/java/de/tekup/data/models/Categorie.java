package de.tekup.data.models;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Categories")
@EqualsAndHashCode(exclude = {"Prts"})
@ToString(exclude = {"Prts"})
public class Categorie implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nom;
	@OneToMany(mappedBy="categorie", fetch = FetchType.LAZY)    
	private Set<Produit> Prts;
	
}
