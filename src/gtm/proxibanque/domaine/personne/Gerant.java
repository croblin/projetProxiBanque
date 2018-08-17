package gtm.proxibanque.domaine.personne;

import java.util.ArrayList;
import java.util.List;

import gtm.proxibanque.domaine.structure.Agence;

public class Gerant {
	
	// Attributs
	
	private int id;
	private String nom;
	private String prenom;
	private Agence agenceRattachee;
	private List<Conseiller> listeConseillersACharge;
	
	// Constructeurs
	
	public Gerant(int id, String nom, String prenom, Agence agenceRattachee) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.agenceRattachee = agenceRattachee;
		this.listeConseillersACharge = new ArrayList<>();
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

	public Agence getAgenceRattachee() {
		return agenceRattachee;
	}

	public void setAgenceRattachee(Agence agenceRattachee) {
		this.agenceRattachee = agenceRattachee;
	}	
	
	public List<Conseiller> getListeConseillersACharge() {
		return listeConseillersACharge;
	}

	public void setListeConseillersACharge(List<Conseiller> listeConseillersACharge) {
		this.listeConseillersACharge = listeConseillersACharge;
	}
	
	// Méthodes métier

	// Méthode permettant de faire l'audit de l'agence dont le gérant à la charge
	public void auditerAgence() {
		int nombreComptesIrreguliers = 0;
		for(Conseiller conseiller : this.listeConseillersACharge) {
			for(Client client : conseiller.getListeClientsACharge()) {
				// On vérifie que le client est un particulier, c'est-à-dire que ces comptes ne doivent pas être débiteurs de plus de 5000 €
				if(client.getTypeClient().getLibelleClient().equals("client particulier")) {
					if(client.getCompteCourant().getSolde() < -5000f) {
						nombreComptesIrreguliers++;
					}
					else if(client.getCompteEpargne() != null && client.getCompteEpargne().getSolde() < -5000f) {
						nombreComptesIrreguliers++;
					}
				}
				// On vérifie que le client est une entreprise, c'est-à-dire que ces comptes ne doivent pas être débiteurs de plus de 50000 €
				if(client.getTypeClient().getLibelleClient().equals("client entreprise")) {
					if(client.getCompteCourant().getSolde() < -50000f) {
						nombreComptesIrreguliers++;
					}
					else if(client.getCompteEpargne() != null && client.getCompteEpargne().getSolde() < -50000f) {
						nombreComptesIrreguliers++;
					}
				}
			}
		}
		System.out.println("Résultats de l'audit après analyse de l'agence " + this.agenceRattachee.getNom() + " de la banque ProxiBanque :");
		System.out.println("	Il y a " + nombreComptesIrreguliers + " compte(s) qui présente(nt) une irrégularité.");
	}

	@Override
	public String toString() {
		return "Gerant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", agenceRattachee=" + agenceRattachee
				+ "]";
	}
}
