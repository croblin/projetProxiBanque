package gtm.proxibanque.domaine.compte;

public class CompteEpargne extends Compte implements IOperationCompte {
	
	// Attributs
	
	private static float tauxRemuneration = 3f;
	
	// Constructeurs
	
	public CompteEpargne(int numCompte, float solde, String dateOuverture) {
		super(numCompte, solde, dateOuverture);
	}
	
	// Accesseurs et mutateurs

	public static float getTauxRemuneration() {
		return tauxRemuneration;
	}

	public static void setTauxRemuneration(float tauxRemuneration) {
		CompteEpargne.tauxRemuneration = tauxRemuneration;
	}
	
	// Méthodes métier

	@Override
	public String toString() {
		return "CompteEpargne [tauxRémunération=" + tauxRemuneration + ", " + super.toString() + "]";
	}

	@Override
	public boolean debiter(float valeur) {
		float soldeApresDebit = this.getSolde() - valeur;
		if(soldeApresDebit < 0.0f) {
			System.out.println("Vous ne pouvez pas débiter de votre compte épargne le montant demandé qui est de " + valeur + "€. ");
			System.out.println("Vous n'avez pas le droit d'être à découvert.");
			return false;
		}
		else {
			this.setSolde(this.getSolde() - valeur);
			System.out.println("Vous venez de débiter de votre compte courant la valeur demandé qui était de " + valeur + "€.");
			System.out.println("Votre nouveau solde de votre compte épargne est maintenant de " + this.getSolde() + "€.");
			return true;
		}		
	}

	@Override
	public void crediter(float valeur) {
		this.setSolde(this.getSolde() + valeur);
		System.out.println("Le nouveau solde de votre compte épargne après créditation est maintenant de " + this.getSolde() + "€.");		
	}

}
