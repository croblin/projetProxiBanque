package gtm.proxibanque.domaine.compte;

import java.util.ArrayList;
import java.util.List;

public class Compte {
	
	// Attributs
	
	private int numCompte;
	private float solde;
	private String dateOuverture;
	private List<Carte> listeCartes;
	
	// Constructeurs
	
	public Compte(int numCompte, float solde, String dateOuverture) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.listeCartes = new ArrayList<>();
	}
	
	// Accesseurs et mutateurs

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	
	public List<Carte> getListeCartes() {
		return listeCartes;
	}

	public void setListeCartes(List<Carte> listeCartes) {
		this.listeCartes = listeCartes;
	}
	
	public boolean ajouterCarte(Carte carte) {
		this.listeCartes.add(carte);
		if(this.listeCartes.contains(carte)) {
			return true;
		}
		else return false;
	}
	
	// Méthodes métier

	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture + ", listeCartes= " + this.listeCartes + "]";
	}
}
