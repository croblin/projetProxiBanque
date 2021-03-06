package gtm.proxibanque.domaine.personne;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import gtm.proxibanque.domaine.compte.CompteCourant;
import gtm.proxibanque.domaine.compte.CompteEpargne;

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
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private Conseiller conseillerRattache;
	
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
		this.compteCourant = new CompteCourant("1224" + id, 0.0f, LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
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
	
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
	
	public Conseiller getConseillerRattache() {
		return conseillerRattache;
	}

	public void setConseillerRattache(Conseiller conseillerRattache) {
		this.conseillerRattache = conseillerRattache;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numVoie=" + numVoie + ", typeVoie="
				+ typeVoie + ", libelleAdresse=" + libelleAdresse + ", cp=" + cp + ", ville=" + ville + ", telephone="
				+ telephone + ", typeClient=" + typeClient.getLibelleClient() + ", debitMaxAutorise=" + typeClient.getDebitMaxAutorise() + "]";
	}	
}
