package gtm.proxibanque.domaine.compte;

public class Carte {
	
	// Attributs
	
	private int numCarte;
	private int crypto;
	private String nomClient;
	private String prenomClient;
	private TypeCarte typeCarte;
		
	// Constructeurs
	
	public Carte(int numCarte, int crypto, String nomClient, String prenomClient, TypeCarte typeCarte) {
		super();
		this.numCarte = numCarte;
		this.crypto = crypto;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.typeCarte = typeCarte;
	}
	
	// Accesseurs et mutateurs

	public int getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}

	public int getCrypto() {
		return crypto;
	}

	public void setCrypto(int crypto) {
		this.crypto = crypto;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	
	public TypeCarte getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(TypeCarte typeCarte) {
		this.typeCarte = typeCarte;
	}
	
	// Méthodes métier

	@Override
	public String toString() {
		return "Carte [numCarte=" + numCarte + ", crypto=" + crypto + ", nomClient=" + nomClient + ", prenomClient="
				+ prenomClient + ", typeCarte=" + typeCarte.getLibelleCarte() + "]";
	}	
}
