package gtm.proxibanque.domaine.compte;

public class CompteEpargne extends Compte implements IOperationCompte {
	
	// Attributs
	
	private static float tauxRemuneration = 3f;
	
	// Constructeurs
	
	public CompteEpargne(String numCompte, float solde, String dateOuverture) {
		super(numCompte, solde, dateOuverture);
	}
	
	// Accesseurs et mutateurs

	public static float getTauxRemuneration() {
		return tauxRemuneration;
	}

	public static void setTauxRemuneration(float tauxRemuneration) {
		CompteEpargne.tauxRemuneration = tauxRemuneration;
	}
	
	// M�thodes m�tier

	@Override
	public String toString() {
		return "CompteEpargne [tauxR�mun�ration=" + tauxRemuneration + ", " + super.toString() + "]";
	}

	@Override
	public boolean debiter(float valeur) {
		float soldeApresDebit = this.getSolde() - valeur;
		if(soldeApresDebit < 0.0f) {
			System.out.println("Vous ne pouvez pas d�biter de ce compte �pargne le montant demand� qui est de " + valeur + "�. ");
			System.out.println("Ce compte n'a pas le droit d'�tre � d�couvert.");
			return false;
		}
		else {
			this.setSolde(this.getSolde() - valeur);
			System.out.println("Vous venez de d�biter de ce compte �pargne la valeur demand� qui �tait de " + valeur + "�.");
			System.out.println("Le nouveau solde de ce compte �pargne est maintenant de " + this.getSolde() + "�.");
			return true;
		}		
	}

	@Override
	public void crediter(float valeur) {
		this.setSolde(this.getSolde() + valeur);
		System.out.println("Le nouveau solde de ce compte �pargne apr�s cr�ditation est maintenant de " + this.getSolde() + "�.");		
	}

}
