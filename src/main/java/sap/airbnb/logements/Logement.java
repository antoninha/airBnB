package sap.airbnb.logements;

import sap.airbnb.utilisateurs.Hote;

public abstract class Logement {

	private final Hote hote;
	private final int tarifParNuit;
	private final String adresse;
	private final int superficie;
	private final int nbVoyageursMax;

	public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {

		this.hote = hote;
		this.tarifParNuit = tarifParNuit;
		this.adresse = adresse;
		this.superficie = superficie;
		this.nbVoyageursMax = nbVoyageursMax;
	}

	public void afficher() {

		System.out.print("l'hôte : ");
		hote.afficher();
		System.out.println(".");
	}

	public String toString(){
		String logementString;
		logementString = "tarif : " + tarifParNuit+ "€, situer à " + adresse + superficie+ " pour " + nbVoyageursMax+" maximum.";
		return logementString ;
	}

	public int getTarifParNuit() {
		return tarifParNuit;
	}

	public Hote getHote() {
		return hote;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getSuperficie() {
		return superficie;
	}

	public int getNbVoyageursMax() {
		return nbVoyageursMax;
	}
}
