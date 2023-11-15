
package ma.controle.adnan.main.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	
	
	@ManyToOne
	private Categorie categories;
	
	public Categorie() {
		super();
	}

	
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}


	public Categorie(String nom, Categorie categories) {
		super();
		this.nom = nom;
		this.categories = categories;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie getCategories() {
		return categories;
	}

	public void setCategories(Categorie categories) {
		this.categories = categories;
	}

	

}
