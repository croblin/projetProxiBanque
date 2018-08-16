package gtm.proxibanque.domaine.personne;

public class Client {
	
	// Attribtus
	
	private int id;
	private String nom;
	private String prenom;
	private int numVoie;
	private String typeVoie;
	private String libelleAdresse;
	private int cp;
	private String ville;
	private String telephone;
	private TypeClient typeClient;
	
	// Constructeurs
	
	public Client(int id, String nom, String prenom, int numVoie, String typeVoie, String libelleAdresse, int cp,
			String ville, String telephone, TypeClient typeClient) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numVoie = numVoie;
		this.typeVoie = typeVoie;
		this.libelleAdresse = libelleAdresse;
		this.cp = cp;
		this.ville = ville;
		this.telephone = telephone;
		this.typeClient = typeClient;
	}
	
	// Accesseurs et mutateurs

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNumVoie() {
		return numVoie;
	}

	public void setNumVoie(int numVoie) {
		this.numVoie = numVoie;
	}

	public String getTypeVoie() {
		return typeVoie;
	}

	public void setTypeVoie(String typeVoie) {
		this.typeVoie = typeVoie;
	}

	public String getLibelleAdresse() {
		return libelleAdresse;
	}

	public void setLibelleAdresse(String libelleAdresse) {
		this.libelleAdresse = libelleAdresse;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public TypeClient getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(TypeClient typeClient) {
		this.typeClient = typeClient;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numVoie=" + numVoie + ", typeVoie="
				+ typeVoie + ", libelleAdresse=" + libelleAdresse + ", cp=" + cp + ", ville=" + ville + ", telephone="
				+ telephone + ", typeClient=" + typeClient.getLibelleClient() + ", debitMaxAutorise=" + typeClient.getDebitMaxAutorise() + "]";
	}	
}
