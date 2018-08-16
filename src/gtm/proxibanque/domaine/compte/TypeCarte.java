package gtm.proxibanque.domaine.compte;

public enum TypeCarte {
	
	VisaElectron("carte Visa Electron"),
	VisaPremier("carte Visa Premier");
	
	private String libelleCarte;
		
	TypeCarte(String libelleCarte) {
		this.libelleCarte = libelleCarte;
	}

	public String getLibelleCarte() {
		return libelleCarte;
	}
}
