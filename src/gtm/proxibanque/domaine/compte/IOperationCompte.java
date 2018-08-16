package gtm.proxibanque.domaine.compte;

public interface IOperationCompte {
	
	public boolean debiter(float valeur);
	
	public void crediter(float valeur);
}
