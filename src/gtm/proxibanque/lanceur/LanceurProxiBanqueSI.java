package gtm.proxibanque.lanceur;

import gtm.proxibanque.domaine.compte.TypeClient;
import gtm.proxibanque.domaine.structure.Agence;

public class LanceurProxiBanqueSI {

	public static void main(String[] args) {
		
		TypeClient typeClient = TypeClient.PARTICULIER;
		System.out.println(typeClient.getDebitMaxAutorise());
		System.out.println(typeClient.getLibelleClient());
		
		Agence agence = new Agence(0, "16/08/2018", "ProxiBanque", 83, "Rue", "Charles Rouxel", 75014, "Paris 14");
		System.out.println(agence.getDateCreation());
	}

}
