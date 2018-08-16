package gtm.proxibanque.domaine.compte;

public class CompteCourant extends Compte implements IOperationCompte {
	
	// Attributs
	
	private static float autorisationDecouvert = 1000f;
	
	// Constructeurs
	
	public CompteCourant(int numCompte, float solde, String dateOuverture) {
		super(numCompte, solde, dateOuverture);
	}
	
	// Acesseurs et mutateurs

	public static float getAutorisationDecouvert() {
		return autorisationDecouvert;
	}

	public static void setAutorisationDecouvert(float autorisationDecouvert) {
		CompteCourant.autorisationDecouvert = autorisationDecouvert;
	}
	
	// M�thodes m�tier

	@Override
	public String toString() {
		return "CompteCourant [autorisationDecouvert=" + autorisationDecouvert + ", " + super.toString() + "]";
	}

	@Override
	public boolean debiter(float valeur) {
		float soldeApresDebit = this.getSolde() - valeur;
		if(soldeApresDebit < - 1000.0f) {
			System.out.println("Vous ne pouvez pas d�biter de votre compte courant le montant demand� qui est de " + valeur + "�. ");
			System.out.println("Vous allez d�passer votre autorisation de d�couvert.");
			return false;
		}
		else {
			this.setSolde(this.getSolde() - valeur);
			System.out.println("Vous venez de d�biter de votre compte courant la valeur demand� qui �tait de " + valeur + "�.");
			System.out.println("Votre nouveau solde de votre compte courant est maintenant de " + this.getSolde() + "�.");
			return true;
		}
	}

	@Override
	public void crediter(float valeur) {
		this.setSolde(this.getSolde() + valeur);
		System.out.println("Le nouveau solde de votre compte courant apr�s cr�ditation est maintenant de " + this.getSolde() + "�.");
	}
}
