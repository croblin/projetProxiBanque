package gtm.proxibanque.domaine.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gtm.proxibanque.domaine.personne.Client;

public class Bourse {
	
	// Attributs
	
	private String id;
	private String nom;
	private Map<Client, String> listeClientsAvecPatrimoine;
	
	public Bourse(String id, String nom) {
		this.id = id;
		this.nom = nom;
		this.listeClientsAvecPatrimoine = new HashMap<>();		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Map<Client, String> getListeClientsAvecPatrimoine() {
		return listeClientsAvecPatrimoine;
	}

	public void setListeClientsAvecPatrimoine(Map<Client, String> listeClientsAvecPatrimoine) {
		this.listeClientsAvecPatrimoine = listeClientsAvecPatrimoine;
	}

	
	
	

}
