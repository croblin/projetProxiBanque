package gtm.proxibanque.domaine.personne;

import java.util.List;

import gtm.proxibanque.domaine.structure.Agence;

public class Conseiller {
	
	// Attributs
	
	private int id;
	private String nom;
	private String prenom;
	private Agence agenceRattachee;
	private Gerant gerantSuperieur;
	private List<Client> listeClientsACharge;
	
	// Constructeurs	
	
	public Conseiller(int id, String nom, String prenom, Agence agenceRattachee, Gerant gerantSuperieur) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.agenceRattachee = agenceRattachee;
		this.gerantSuperieur = gerantSuperieur;
	}

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

	public Gerant getGerantSuperieur() {
		return gerantSuperieur;
	}

	public void setGerantSuperieur(Gerant gerantSuperieur) {
		this.gerantSuperieur = gerantSuperieur;
	}

	public List<Client> getListeClientsACharge() {
		return listeClientsACharge;
	}

	public void setListeClientsACharge(List<Client> listeClientsACharge) {
		this.listeClientsACharge = listeClientsACharge;
	}
	
	// Méthodes métier
	
	public boolean creerClient() {
		//TODO
		return true;
	}

	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", agenceRattachee=" + agenceRattachee
				+ ", gerantSuperieur=" + gerantSuperieur + ", listeClientsACharge=" + listeClientsACharge + "]";
	}
}
