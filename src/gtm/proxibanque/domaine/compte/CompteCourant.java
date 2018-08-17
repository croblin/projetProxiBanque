package gtm.proxibanque.domaine.compte;

public class CompteCourant extends Compte implements IOperationCompte {
	
	// Attributs
	
	private static float autorisationDecouvert = 1000f;
	
	// Constructeurs
	
	public CompteCourant(String numCompte, float solde, String dateOuverture) {
		super(numCompte, solde, dateOuverture);
	}
	
	// Acesseurs et mutateurs

	public static float getAutorisationDecouvert() {
		return autorisationDecouvert;
	}

	public static void setAutorisationDecouvert(float autorisationDecouvert) {
		CompteCourant.autorisationDecouvert = autorisationDecouvert;
	}
	
	// Méthodes métier

	@Override
	public String toString() {
		return "CompteCourant [autorisationDecouvert=" + autorisationDecouvert + ", " + super.toString() + "]";
	}

	@Override
	public boolean debiter(float valeur) {
		float soldeApresDebit = this.getSolde() - valeur;
		if(soldeApresDebit < - CompteCourant.autorisationDecouvert) {
			System.out.println("Vous ne pouvez pas débiter de ce compte courant le montant demandé qui est de " + valeur + "€. ");
			System.out.println("Vous allez dépasser l'autorisation de découvert.");
			return false;
		}
		else {
			this.setSolde(this.getSolde() - valeur);
			System.out.println("Vous venez de débiter de ce compte courant la valeur demandé qui était de " + valeur + "€.");
			System.out.println("Le nouveau solde de ce compte courant est maintenant de " + this.getSolde() + "€.");
			return true;
		}
	}

	@Override
	public void crediter(float valeur) {
		this.setSolde(this.getSolde() + valeur);
		System.out.println("Le nouveau solde de ce compte courant après créditation est maintenant de " + this.getSolde() + "€.");
	}
}
