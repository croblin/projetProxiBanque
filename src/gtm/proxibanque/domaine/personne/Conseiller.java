package gtm.proxibanque.domaine.personne;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import gtm.proxibanque.domaine.compte.Carte;
import gtm.proxibanque.domaine.compte.CompteEpargne;
import gtm.proxibanque.domaine.compte.TypeCarte;
import gtm.proxibanque.domaine.structure.Agence;

public class Conseiller {
	
	// Attributs
	
	private int id;
	private String nom;
	private String prenom;
	private Agence agenceRattachee;
	private Gerant gerantSuperieur;
	private List<Client> listeClientsACharge;
	
	// Constructeurs	
	
	public Conseiller(int id, String nom, String prenom, Agence agenceRattachee, Gerant gerantSuperieur) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.agenceRattachee = agenceRattachee;
		this.gerantSuperieur = gerantSuperieur;
		this.listeClientsACharge = new ArrayList<>();
	}

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

	public Gerant getGerantSuperieur() {
		return gerantSuperieur;
	}

	public void setGerantSuperieur(Gerant gerantSuperieur) {
		this.gerantSuperieur = gerantSuperieur;
	}

	public List<Client> getListeClientsACharge() {
		return listeClientsACharge;
	}
	
	//M�thode permettant de r�cup�rer un client dans la liste des clients rattach�e au conseiller
	public Client getClient(Client client) {
		return this.listeClientsACharge.get(this.listeClientsACharge.indexOf(client));
	}

	public void setListeClientsACharge(List<Client> listeClientsACharge) {
		this.listeClientsACharge = listeClientsACharge;
	}
	
	// M�thodes m�tier
	
	public void creerClient(Client client) {
		this.listeClientsACharge.add(client);
		System.out.println("Le client " + client.getNom() + " " + client.getPrenom() + " a bien �t� cr��.");
		System.out.println("Il est maintenant rattach� au conseiller " + this.nom + " " + this.prenom);
	}
	
	public boolean creerCompteEpargne(Client client) {
		if(this.listeClientsACharge.contains(client)) {
			this.getClient(client).setCompteEpargne(new CompteEpargne("1056" + client.getId(), 0.0f, LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
			System.out.println("Le client " + client.getNom() + " " + client.getPrenom() + " a maintenant un compte �pargne.");
			System.out.println("Le num�ro de compte est " + this.listeClientsACharge.get(this.listeClientsACharge.indexOf(client)).getCompteEpargne().getNumCompte());
			this.getClient(client).getCompteEpargne().setSolde(50f);
			System.out.println("Le solde actuel est de 50�");
			System.out.println("Le taux de r�mun�ration est actuellement de " + CompteEpargne.getTauxRemuneration() + "%");
			return true;
		}
		else {
			System.out.println("Le client soumis n'est pas rattach� � ce conseiller. Choisissez-en un autre");
			return false;
		}		
	}
	
	public boolean modifierClient(Client client) {
		if(this.listeClientsACharge.contains(client)) {
			int index = this.listeClientsACharge.indexOf(client);
			Scanner sc = new Scanner(System.in);
			System.out.println("Le nom du client est : " + client.getNom() +". Veuillez entrer une nouvelle saisie :");
			client.setNom(sc.nextLine());
			System.out.println("Le pr�nom du client est : " + client.getPrenom() +". Veuillez entrer une nouvelle saisie :");
			client.setPrenom(sc.nextLine());
			System.out.println("Le num�ro de voie du client est : " + client.getNumVoie() +". Veuillez entrer une nouvelle saisie :");
			client.setNumVoie(sc.nextInt());
			sc.nextLine();
			System.out.println("Le type de voie d'adresse du client est : " + client.getTypeVoie() +". Veuillez entrer une nouvelle saisie :");
			client.setTypeVoie(sc.nextLine());
			System.out.println("Le libell� de l'adresse du client est : " + client.getLibelleAdresse() +". Veuillez entrer une nouvelle saisie :");
			client.setLibelleAdresse(sc.nextLine());
			System.out.println("Le code postal de l'adresse du client est : " + client.getCp() +". Veuillez entrer une nouvelle saisie :");
			client.setCp(sc.nextInt());
			sc.nextLine();
			System.out.println("La ville de l'adresse du client est : " + client.getVille() +". Veuillez entrer une nouvelle saisie :");
			client.setVille(sc.nextLine());
			System.out.println("Le num�ro de t�l�phone du client est : " + client.getTelephone() +". Veuillez entrer une nouvelle saisie :");
			client.setTelephone(sc.nextLine());
			System.out.println("Les nouvelles donn�es du client sont les suivantes : ");
			System.out.println("	Nom : " + client.getNom());
			System.out.println("	Pr�nom : " + client.getPrenom());
			System.out.println("	Num�ro de voie : " + client.getNumVoie());
			System.out.println("	Type de voie : " + client.getTypeVoie());
			System.out.println("	Libell� de l'adresse : " + client.getLibelleAdresse());
			System.out.println("	Code postal : " + client.getCp());
			System.out.println("	Ville : " + client.getVille());
			System.out.println("	T�l�phone : " + client.getTelephone());
			this.listeClientsACharge.set(index, client);
			return true;
		}
		else {
			System.out.println("Le client soumis n'est pas rattach� � ce conseiller. Choisissez-en un autre");
			return false;
		}
	}
	
	public boolean afficherClient(Client client) {
		if(this.listeClientsACharge.contains(client)) {
			System.out.println("Les donn�es actuelles du client sont les suivantes : ");
			System.out.println("	Nom : " + client.getNom());
			System.out.println("	Pr�nom : " + client.getPrenom());
			System.out.println("	Num�ro de voie : " + client.getNumVoie());
			System.out.println("	Type de voie : " + client.getTypeVoie());
			System.out.println("	Libell� de l'adresse : " + client.getLibelleAdresse());
			System.out.println("	Code postal : " + client.getCp());
			System.out.println("	Ville : " + client.getVille());
			System.out.println("	T�l�phone : " + client.getTelephone());
			return true;
		}
		else {
			System.out.println("Le client soumis n'est pas rattach� � ce conseiller. Choisissez-en un autre");
			return false;
		}
	}
	
	public boolean supprimerClient(Client client) {
		if(this.listeClientsACharge.contains(client)) {
			this.listeClientsACharge.remove(this.listeClientsACharge.indexOf(client));
			System.out.println("Le client " + client.getNom() + " " + client.getPrenom() + " a bien �t� supprim�.");
			System.out.println("Il n'est maintenant plus rattach� au conseiller " + this.nom + " " + this.prenom);	
			return true;
		}
		else {
			System.out.println("Le client soumis n'est pas rattach� � ce conseiller. Choisissez-en un autre");
			return false;
		}
	}
	
	public boolean ajouterCarte(Client client) {
		if(this.listeClientsACharge.contains(client)) {
			String choixCarte;
			String choixCompte;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("Deux types de cartes sont propos�s : la carte Visa Electron et la carte Visa Premier.");
				System.out.println("Tapez E en majuscule pour la carte Visa Electron, ou P en majuscule pour la carte Visa Premier :");
				choixCarte = sc.nextLine();
			}
			while(!choixCarte.equals("E") && !choixCarte.equals("P"));
			// G�n�ration du crypto de la carte
			String crypto = "";
			Random rand = new Random();
			crypto = crypto + rand.nextInt(9);
			crypto = crypto + rand.nextInt(9);
			crypto = crypto + rand.nextInt(9);
			if(choixCarte.equals("E")) {
				do {
					System.out.println("La carte Visa Electron peut �tre associ� au compte courant ou au compte �pargne.");
					System.out.println("Tapez C en majuscule pour le compte courant, ou E en majuscule pour le compte �pargne :");
					choixCompte = sc.nextLine();
				}
				while(!choixCarte.equals("C") && !choixCarte.equals("E"));
				if(choixCompte.equals("C")) {
					
					Carte carte = new Carte("689" + client.getCompteCourant().getNumCompte(), Integer.parseInt(crypto), client.getNom(), client.getPrenom(), TypeCarte.VisaElectron);
					this.getClient(client).getCompteCourant().setCarteRattachee(carte);
				}
				else if(choixCompte.equals("E") && client.getCompteEpargne() != null) {
					Carte carte = new Carte("689" + client.getCompteEpargne().getNumCompte(), Integer.parseInt(crypto), client.getNom(), client.getPrenom(), TypeCarte.VisaElectron);
					this.getClient(client).getCompteEpargne().setCarteRattachee(carte);
				}
				else {
					System.out.println("Vous ne pouvez pas rattaher de carte au compte �pargne du client " + client.getNom() + " " + client.getPrenom() +".");
					System.out.println("Ce dernier ne poss�de pas de compte �pargne.");
					return false;
				}
			}
			else if(choixCarte.equals("P")) {
				do {
					System.out.println("La carte Visa Premier peut �tre associ� au compte courant ou au compte �pargne.");
					System.out.println("Tapez C en majuscule pour le compte courant, ou E en majuscule pour le compte �pargne :");
					choixCompte = sc.nextLine();
				}
				while(!choixCompte.equals("C") && !choixCompte.equals("E"));
				if(choixCompte.equals("C")) {
					
					Carte carte = new Carte("689" + client.getCompteCourant().getNumCompte(), Integer.parseInt(crypto), client.getNom(), client.getPrenom(), TypeCarte.VisaPremier);
					this.getClient(client).getCompteCourant().setCarteRattachee(carte);
				}
				else if(choixCompte.equals("E") && client.getCompteEpargne() != null) {
					Carte carte = new Carte("689" + client.getCompteEpargne().getNumCompte(), Integer.parseInt(crypto), client.getNom(), client.getPrenom(), TypeCarte.VisaPremier);
					this.getClient(client).getCompteEpargne().setCarteRattachee(carte);
				}
				else {
					System.out.println("Vous ne pouvez pas rattaher de carte au compte �pargne du client " + client.getNom() + " " + client.getPrenom() +".");
					System.out.println("Ce dernier ne poss�de pas de compte �pargne.");
					return false;
				}
			}			
			return true;
		}
		else {
			System.out.println("Le client soumis n'est pas rattach� � ce conseiller. Choisissez-en un autre");
			return false;
		}
	}
	
	// M�thode pour effectuer un virement de compte � compte depuis un m�me client
	public boolean effectuerVirement(Client client, float solde) {
		if(this.listeClientsACharge.contains(client)) {
			int index = this.listeClientsACharge.indexOf(client);
			Scanner sc = new Scanner(System.in);
			String choixCompte;
			if(this.listeClientsACharge.get(index).getCompteEpargne() != null) {
				do {
					System.out.println("Voulez-vous effectuer un virement depuis le compte courant ou le compte �pargne ?");
					System.out.println("Tapez C en majuscule pour le compte courant, ou E en majuscule pour le compte �pargne :");
					choixCompte = sc.nextLine();
				}
				while(!choixCompte.equals("C") && !choixCompte.equals("E"));
				if(choixCompte.equals("C")) {
					if(this.listeClientsACharge.get(index).getCompteCourant().debiter(solde)) {
						this.listeClientsACharge.get(index).getCompteEpargne().crediter(solde);
						return true;
					}
					else return false;
				}
				else if(choixCompte.equals("E")) {
					if(this.listeClientsACharge.get(index).getCompteEpargne().debiter(solde)) {
						this.listeClientsACharge.get(index).getCompteCourant().crediter(solde);
						return true;
					}
					else return false;
				}	
				else return false;
			}
			else {
				System.out.println("Vous ne pouvez pas effectuer de virement sur les compte du client " + client.getNom() + " " + client.getPrenom() +".");
				System.out.println("Ce dernier ne poss�de pas de compte �pargne.");
				return false;
			}
		}		
		else {
			System.out.println("Le client soumis n'est pas rattach� � ce conseiller. Choisissez-en un autre");
			return false;
		}		
	}
	
	// M�thode pour effectuer un virement de compte � compte d'un client � un autre
	public boolean effectuerVirement(Client clientDebiteur, Client clientCredite, float solde) {
		Scanner sc = new Scanner(System.in);
		String choixCompte;
		do{
			System.out.println("Voulez-vous effectuer un virement depuis le compte courant ou le compte �pargne du client "	+ clientDebiteur.getNom() + " " + clientDebiteur.getPrenom() + " ?");
			System.out.println("Tapez C en majuscule pour le compte courant, ou E en majuscule pour le compte �pargne :");
			choixCompte = sc.nextLine();
		} while (!choixCompte.equals("C") && !choixCompte.equals("E"));
		// On va d�biter le compte courant du client d�biteur
		if(choixCompte.equals("C")) {
			do{
				System.out.println("Voulez-vous effectuer un virement vers le compte courant ou le compte �pargne du client " + clientCredite.getNom() + " " + clientCredite.getPrenom() + " ?");
				System.out.println("Tapez C en majuscule pour le compte courant, ou E en majuscule pour le compte �pargne :");
				choixCompte = sc.nextLine();
			} while (!choixCompte.equals("C") && !choixCompte.equals("E"));
			// On va d�biter le compte courant du client d�biteur, et cr�diter le compte
			// courant du client cr�dit�
			if(choixCompte.equals("C")) {
				if(clientDebiteur.getCompteCourant().debiter(solde)) {
					clientCredite.getCompteCourant().crediter(solde);
					System.out.println("R�sultats de la transaction :");
					System.out.println("	Client d�biteur : " + clientDebiteur.getNom() + " " + clientDebiteur.getPrenom());
					System.out.println("		Solde du compte courant : " +clientDebiteur.getCompteCourant().getSolde());
					if(clientDebiteur.getCompteEpargne() != null) {
						System.out.println("		Solde du compte �pargne : " +clientDebiteur.getCompteEpargne().getSolde());
					}
					System.out.println("	Client cr�dit� : " + clientCredite.getNom() + " " + clientCredite.getPrenom());
					System.out.println("		Solde du compte courant : " +clientCredite.getCompteCourant().getSolde());
					if(clientCredite.getCompteEpargne() != null) {
						System.out.println("		Solde du compte �pargne : " +clientCredite.getCompteEpargne().getSolde());
					}
					return true;
				}
				else return false;
			}
			// On va d�biter le compte courant du client d�biteur, et cr�diter le compte
			// �pargne du client cr�dit�
			else if(choixCompte.equals("E")) {
				if(clientCredite.getCompteEpargne() != null) {
					if(clientDebiteur.getCompteCourant().debiter(solde)) {
						clientCredite.getCompteEpargne().crediter(solde);
						System.out.println("R�sultats de la transaction :");
						System.out.println("	Client d�biteur : " + clientDebiteur.getNom() + " " + clientDebiteur.getPrenom());
						System.out.println("		Solde du compte courant : " +clientDebiteur.getCompteCourant().getSolde());
						if(clientDebiteur.getCompteEpargne() != null) {
							System.out.println("		Solde du compte �pargne : " +clientDebiteur.getCompteEpargne().getSolde());
						}
						System.out.println("	Client cr�dit� : " + clientCredite.getNom() + " " + clientCredite.getPrenom());
						System.out.println("		Solde du compte courant : " +clientCredite.getCompteCourant().getSolde());
						if(clientCredite.getCompteEpargne() != null) {
							System.out.println("		Solde du compte �pargne : " +clientCredite.getCompteEpargne().getSolde());
						}
						return true;
					}
					else return false;
				} 
				else {
					System.out.println("Vous ne pouvez pas effectuer de virement sur les comptes du client " + clientCredite.getNom() + " " + clientCredite.getPrenom() + ".");
					System.out.println("Ce dernier ne poss�de pas de compte �pargne.");
					return false;
				}
			}
			else return false;
		}
		// On va d�biter le compte �pargne du client d�biteur
		else if(choixCompte.equals("E")) {
			if(clientDebiteur.getCompteEpargne() != null) {
				do{
					System.out.println("Voulez-vous effectuer un virement vers le compte courant ou le compte �pargne du client " + clientCredite.getNom() + " " + clientCredite.getPrenom() + " ?");
					System.out.println("Tapez C en majuscule pour le compte courant, ou E en majuscule pour le compte �pargne :");
					choixCompte = sc.nextLine();
				} while(!choixCompte.equals("C") && !choixCompte.equals("E"));
				// On va d�biter le compte �pargne du client d�biteur, et cr�diter le compte
				// courant du client cr�dit�
				if(choixCompte.equals("C")) {
					if(clientDebiteur.getCompteEpargne().debiter(solde)) {
						clientCredite.getCompteCourant().crediter(solde);
						System.out.println("R�sultats de la transaction :");
						System.out.println("	Client d�biteur : " + clientDebiteur.getNom() + " " + clientDebiteur.getPrenom());
						System.out.println("		Solde du compte courant : " +clientDebiteur.getCompteCourant().getSolde());
						if(clientDebiteur.getCompteEpargne() != null) {
							System.out.println("		Solde du compte �pargne : " +clientDebiteur.getCompteEpargne().getSolde());
						}
						System.out.println("	Client cr�dit� : " + clientCredite.getNom() + " " + clientCredite.getPrenom());
						System.out.println("		Solde du compte courant : " +clientCredite.getCompteCourant().getSolde());
						if(clientCredite.getCompteEpargne() != null) {
							System.out.println("		Solde du compte �pargne : " +clientCredite.getCompteEpargne().getSolde());
						}
						return true;
					}
					else return false;
				}
				// On va d�biter le compte �pargne du client d�biteur, et cr�diter le compte
				// �pargne du client cr�dit�
				else if(choixCompte.equals("E")) {
					if(clientCredite.getCompteEpargne() != null) {
						if(clientDebiteur.getCompteEpargne().debiter(solde)) {
							clientCredite.getCompteEpargne().crediter(solde);
							System.out.println("R�sultats de la transaction :");
							System.out.println("	Client d�biteur : " + clientDebiteur.getNom() + " " + clientDebiteur.getPrenom());
							System.out.println("		Solde du compte courant : " +clientDebiteur.getCompteCourant().getSolde());
							if(clientDebiteur.getCompteEpargne() != null) {
								System.out.println("		Solde du compte �pargne : " +clientDebiteur.getCompteEpargne().getSolde());
							}
							System.out.println("	Client cr�dit� : " + clientCredite.getNom() + " " + clientCredite.getPrenom());
							System.out.println("		Solde du compte courant : " +clientCredite.getCompteCourant().getSolde());
							if(clientCredite.getCompteEpargne() != null) {
								System.out.println("		Solde du compte �pargne : " +clientCredite.getCompteEpargne().getSolde());
							}
							return true;
						}
						else return false;
					}
					else {
						System.out.println("Vous ne pouvez pas effectuer de virement sur les comptes du client " + clientCredite.getNom() + " " + clientCredite.getPrenom() + ".");
						System.out.println("Ce dernier ne poss�de pas de compte �pargne.");
						return false;
					}
				}
				else return false;
			}
			else {
				System.out.println("Vous ne pouvez pas effectuer de virement depuis les comptes du client "	+ clientDebiteur.getNom() + " " + clientDebiteur.getPrenom() + ".");
				System.out.println("Ce dernier ne poss�de pas de compte �pargne.");
				return false;
			}			
		}
		else return false;
	}

	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", agenceRattachee=" + agenceRattachee
				+ ", gerantSuperieur=" + gerantSuperieur + ", listeClientsACharge=" + listeClientsACharge + "]";
	}
}
