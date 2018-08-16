package gtm.proxibanque.lanceur;

import gtm.proxibanque.domaine.compte.Carte;
import gtm.proxibanque.domaine.compte.CompteCourant;
import gtm.proxibanque.domaine.compte.CompteEpargne;
import gtm.proxibanque.domaine.compte.TypeCarte;
import gtm.proxibanque.domaine.personne.Client;
import gtm.proxibanque.domaine.personne.TypeClient;
import gtm.proxibanque.domaine.structure.Agence;

public class LanceurProxiBanqueSI {

	public static void main(String[] args) {
		
		TypeClient typeClient = TypeClient.Particulier;
		System.out.println(typeClient.getDebitMaxAutorise());
		System.out.println(typeClient.getLibelleClient());
		
		Agence agence = new Agence(0, "16/08/2018", "ProxiBanque", 83, "Rue", "Charles Rouxel", 75014, "Paris 14");
		System.out.println(agence.getDateCreation());
		
		CompteCourant cc = new CompteCourant(12345, 3000.0f, "16/08/2018");
				
		CompteCourant.setAutorisationDecouvert(2000);
		
		//System.out.println(cc);		
		
		CompteEpargne ce = new CompteEpargne(12388, 3000.0f, "16/08/2018");
		
		//System.out.println(ce);	
		
		ce.ajouterCarte(new Carte(125896, 265, "ROB", "Chris", TypeCarte.VisaElectron));
		
		System.out.println(ce);	
		
		cc.debiter(4000f);
		
		cc.debiter(1);
		
		Client client = new Client(2, "ROB", "Chris", 54, "Boulevard", "Charles Rouxel", 75013, "Paris 13", "0101010101", TypeClient.Particulier);
		System.out.println(client);
		
		cc.crediter(300f);
		
		ce.debiter(3000f);
	}

}
