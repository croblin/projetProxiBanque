package gtm.proxibanque.domaine.compte;

public class Compte {
	
	// Attributs
	
	private String numCompte;
	private float solde;
	private String dateOuverture;
	private Carte carteRattachee;
	private static float tauxRemboursementCreditConsommation = 6f;
	private static float tauxRemboursementCreditImmobilier = 4f;
	
	// Constructeurs
	
	public Compte(String numCompte, float solde, String dateOuverture) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;		
	}
	
	// Accesseurs et mutateurs

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
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
	
	public Carte getCarteRattachee() {
		return carteRattachee;
	}

	public void setCarteRattachee(Carte carteRattachee) {
		this.carteRattachee = carteRattachee;
	}	
	
	public static float getTauxRemboursementCreditConsommation() {
		return tauxRemboursementCreditConsommation;
	}

	public static void setTauxRemboursementCreditConsommation(float tauxRemboursementCreditConsommation) {
		Compte.tauxRemboursementCreditConsommation = tauxRemboursementCreditConsommation;
	}

	public static float getTauxRemboursementCreditImmobilier() {
		return tauxRemboursementCreditImmobilier;
	}

	public static void setTauxRemboursementCreditImmobilier(float tauxRemboursementCreditImmobilier) {
		Compte.tauxRemboursementCreditImmobilier = tauxRemboursementCreditImmobilier;
	}
	
	// Méthodes métier

	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture + ", carteRattachee= " + this.carteRattachee + "]";
	}
}
