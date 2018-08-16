package gtm.proxibanque.lanceur;

import gtm.proxibanque.domaine.compte.TypeClient;

public class LanceurProxiBanqueSI {

	public static void main(String[] args) {
		
		TypeClient typeClient = TypeClient.PARTICULIER;
		System.out.println(typeClient.getDebitMaxAutorise());
	}

}
