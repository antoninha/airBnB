package sap.airbnb.reservations;

import java.util.Date;

import sap.airbnb.logements.Logement;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {

	private int tarif;

	public SejourCourt(Date dateArrivee, Logement logement, int nbNuits, int nbVoyageurs) {
		super(dateArrivee, logement, nbNuits, nbVoyageurs);
		miseAJourTarif();
	}

	@Override
	public void afficher() {
		afficherSejour();
		
		System.out.println("Le prix de ce séjour est de " + tarif + "€");
	}


	public boolean beneficiePromotion() {
		return false;
	}

	public int getTarif() {
		return tarif;
	}

	public void miseAJourTarif() {
		this.tarif = getNbNuits() * getLogement().getTarifParNuit();	
	}

	public boolean verficationNombreDeNuits() {
		
		return getNbNuits() >= 1 && getNbNuits() <= 5;
	}
}
