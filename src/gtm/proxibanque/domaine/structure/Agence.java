package gtm.proxibanque.domaine.structure;

/**
 * Agence est la classe repr�sentant une agence appartenant � la banque ProxiBanque.
 * 
 * @author croblin / hramkhalawon
 * @version 1.0
 */

public class Agence {
	
	// Attributs
	
	/**
     * L'identifiant de l'agence. Unique pour chaque agence.
     * 
     */
	private int id;
	
	/**
     * La date de cr�ation de l'agence.
     *     
     */
	private String dateCreation;
	
	/**
     * Le nom de l'agence.
     *     
     */
	private String nom;
	
	/**
     * Le num�ro associ� � l'adresse de l'agence.
     *     
     */
	private int numAdresse;
	
	/**
     * Le type de voie o� se situe l'agence.
     *     
     */	
	private String typeVoie;
	
	/**
     * Le libell� de l'adresse de l'agence.
     *     
     */
	private String libelleAdresse;
	
	/**
     * Le code postal de l'agence.
     *     
     */
	private int cp;
	
	/**
     * La ville o� se situe de l'agence.
     *     
     */
	private String ville;
	
	// Constructeurs
	
	/**
     * Le constructeur de l'agence. Avec l'appel de ce constructeur, tous les champs de l'agence seront renseign�s.
     *     
     * @param id
     * 		L'identifiant unique de l'agence.
     * @param dateCreation
     * 		La date de cr�ation de l'agence.
     * @param nom
     * 		Le nom de l'agence.
     * @param numAdresse
     * 		Le num�ro associ� � l'adresse de l'agence.
     * @param typeVoie
     * 		Le type de voie o� se situe l'agence.
     * @param libelleAdresse
     * 		Le libell� de l'adresse de l'agence.
     * @param cp
     * 		Le code postal de l'agence.
     * @param ville
     * 		La ville o� se situe l'agence.
     */
	
	public Agence(int id, String dateCreation, String nom, int numAdresse, String typeVoie, String libelleAdresse, int cp, String ville) {
		this.id = id;
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.numAdresse = numAdresse;
		this.typeVoie = typeVoie;
		this.libelleAdresse = libelleAdresse;
		this.cp = cp;
		this.ville = ville;
	}
	
	// Accesseurs et mutateurs

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumAdresse() {
		return numAdresse;
	}

	public void setNumAdresse(int numAdresse) {
		this.numAdresse = numAdresse;
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

	// M�thodes m�tier
	
	/**
     * La m�thode toString. Red�finie avec l'annotation @Override. 
     *     
     */
	
	@Override
	public String toString() {
		return "Agence [id=" + id + ", dateCreation=" + dateCreation + ", nom=" + nom + ", numAdresse=" + numAdresse
				+ ", typeVoie=" + typeVoie + ", libelleAdresse=" + libelleAdresse + ", cp=" + cp + ", ville=" + ville
				+ "]";
	}
}
