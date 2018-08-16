package gtm.proxibanque.domaine.personne;

import gtm.proxibanque.domaine.structure.Agence;

public class Gerant {
	
	// Attributs
	
	private int id;
	private String nom;
	private String prenom;
	private Agence agenceRattachee;
	
	// Constructeurs
	
	public Gerant(int id, String nom, String prenom, Agence agenceRattachee) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.agenceRattachee = agenceRattachee;
	}
	
	// Accesseurs et mutateurs

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Agence getAgenceRattachee() {
		return agenceRattachee;
	}

	public void setAgenceRattachee(Agence agenceRattachee) {
		this.agenceRattachee = agenceRattachee;
	}
	
	// Méthodes métier
	
	public boolean auditerAgence() {
		//TODO
		return true;
	}

	@Override
	public String toString() {
		return "Gerant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", agenceRattachee=" + agenceRattachee
				+ "]";
	}
}
