package gtm.proxibanque.domaine.personne;

public enum TypeClient {
	
	Particulier("client particulier", 5000),
	Entreprise("client entreprise", 50000);
	
	private String libelleClient;
	private float debitMaxAutorise;
	
	TypeClient(String libelleClient, float debitMaxAutorise) {
		this.libelleClient = libelleClient;
		this.debitMaxAutorise = debitMaxAutorise;
	}

	public String getLibelleClient() {
		return libelleClient;
	}

	public float getDebitMaxAutorise() {
		return debitMaxAutorise;
	}	
}
