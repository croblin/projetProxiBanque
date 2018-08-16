package gtm.proxibanque.domaine.compte;

public enum TypeClient {
	
	PARTICULIER("client particulier", 5000),
	ENTREPRISE("client entreprise", 50000);
	
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
