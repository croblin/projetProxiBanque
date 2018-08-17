package gtm.proxibanque.lanceur;

import java.util.ArrayList;
import java.util.List;

import gtm.proxibanque.domaine.compte.Carte;
import gtm.proxibanque.domaine.compte.CompteCourant;
import gtm.proxibanque.domaine.compte.CompteEpargne;
import gtm.proxibanque.domaine.compte.TypeCarte;
import gtm.proxibanque.domaine.personne.Client;
import gtm.proxibanque.domaine.personne.Conseiller;
import gtm.proxibanque.domaine.personne.Gerant;
import gtm.proxibanque.domaine.personne.TypeClient;
import gtm.proxibanque.domaine.structure.Agence;

public class LanceurProxiBanqueSI {

	public static void main(String[] args) {
		
		// Déclarations + instanciations + affectations
		
		// Jeu de données pour l'application
		
		Agence agenceA = new Agence(56897, "05/02/2006", "Agence de Paris 14", 5, "rue", "Charles Rouxel", 75014, "Paris");
		Agence agenceB = new Agence(42397, "05/06/2006", "Agence de Paris 9", 21, "rue", "Lavoisier", 75009, "Paris");
		
		Gerant gerantA = new Gerant(5689725, "Roblin", "Christophe", agenceA);
		Gerant gerantB = new Gerant(4239714, "Peter", "Hanson", agenceB);
		
		Conseiller conseillerA1 = new Conseiller(568972517, "Bicant", "Anthony", agenceA, gerantA);
		Conseiller conseillerA2 = new Conseiller(568972513, "Kazohar", "Renato", agenceA, gerantA);
		Conseiller conseillerA3 = new Conseiller(568972564, "Boudjaoui", "Lyes", agenceA, gerantA);
		Conseiller conseillerA4 = new Conseiller(568972581, "Steve", "Bertand", agenceA, gerantA);
		Conseiller conseillerA5 = new Conseiller(568972537, "Oppou", "Kuru", agenceA, gerantA);
		
		Conseiller conseillerB1 = new Conseiller(423971456, "Yayah", "Toufix", agenceB, gerantB);
		Conseiller conseillerB2 = new Conseiller(423971449, "Fekir", "Nabille", agenceB, gerantB);
		Conseiller conseillerB3 = new Conseiller(423971499, "Sacré", "Sarah", agenceB, gerantB);
		Conseiller conseillerB4 = new Conseiller(423971456, "Armstrong", "Nell", agenceB, gerantB);
		Conseiller conseillerB5 = new Conseiller(423971411, "Sànchez", "Alexis", agenceB, gerantB);
		
		// Affectations des conseillers à l'agence A
		
		gerantA.getListeConseillersACharge().add(conseillerA1);
		gerantA.getListeConseillersACharge().add(conseillerA2);
		gerantA.getListeConseillersACharge().add(conseillerA3);
		gerantA.getListeConseillersACharge().add(conseillerA4);
		gerantA.getListeConseillersACharge().add(conseillerA5);
		
		gerantB.getListeConseillersACharge().add(conseillerB1);
		gerantB.getListeConseillersACharge().add(conseillerB2);
		gerantB.getListeConseillersACharge().add(conseillerB3);
		gerantB.getListeConseillersACharge().add(conseillerB4);
		gerantB.getListeConseillersACharge().add(conseillerB5);
		
		// Utilisations
		
		List<Client> listeClients = new ArrayList<>();
		
		TypeClient typeClient = TypeClient.Particulier;
		System.out.println(typeClient.getDebitMaxAutorise());
		System.out.println(typeClient.getLibelleClient());		
		
		Client client = new Client(2, "ROB", "Chris", 54, "Boulevard", "Charles Rouxel", 75013, "Paris", "0101010101", TypeClient.Particulier);
		Client clientBis = new Client(2, "ROBLIN", "Christophe", 54, "Boulevard", "Charles Rouxel", 75013, "Paris", "0101010101", TypeClient.Particulier);
		System.out.println(client.getCompteCourant());
		
		//client.getCompteCourant().crediter(300f);
		client.getCompteCourant().debiter(6000f);
		clientBis.getCompteCourant().debiter(6000f);
		System.out.println("Apres debit : " + client.getCompteCourant().getSolde());
		
		
		conseillerA1.creerClient(client);
		conseillerA1.creerClient(clientBis);
		conseillerA1.creerCompteEpargne(client);
		client.getCompteEpargne().crediter(500f);
		
		gerantA.auditerAgence();
		
		clientBis.getCompteCourant().crediter(500f);
		conseillerA2.creerClient(clientBis);	
		conseillerA2.creerCompteEpargne(clientBis);
		conseillerA2.ajouterCarte(clientBis);
		System.out.println(conseillerA2.getClient(clientBis).getCompteCourant().getCarteRattachee());
		System.out.println(conseillerA2.getClient(clientBis).getCompteEpargne().getCarteRattachee());
		
		
		//System.out.println(conseillerA1.getListeClientsACharge());
		/*conseillerA1.supprimerClient(client);
		System.out.println(conseillerA1.getListeClientsACharge());*/
				
		conseillerA1.effectuerVirement(client, clientBis, 100f);
		
	}

}
