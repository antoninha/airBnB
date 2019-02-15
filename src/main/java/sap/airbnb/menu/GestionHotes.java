package sap.airbnb.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import sap.airbnb.data.AirBnBData;
import sap.airbnb.logements.Logement;
import sap.airbnb.utilisateurs.Hote;

public class GestionHotes {

	static void listerHotes() {

		System.out.println("-------------------------------------");
		System.out.println("Liste des hôtes ");

		for (int i = 0; i < Menu.listHotes.size(); i++) {
			System.out.print("Numéro " + i + " : ");
			Menu.listHotes.get(i).afficher();
			System.out.println();
		}

		System.out.println("Saisir une option : ");
		System.out.println("1 : Ajouter un hôte");
		System.out.println("2 : Supprimer un hôte");
		System.out.println("3 : Retour");

		try {
			switch (Menu.choix(3)) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				Menu.listerMenu();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Une erreur est survenue lors de la saisie");
			Menu.scanner.next();
			listerHotes();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Une erreur est survenue lors de la suppression");
			listerHotes();
		}
	}

	public static void ajouterHote(String prenom, String nom, int age, int delaisReponse) throws InputMismatchException {

		Hote newHote = new Hote(prenom, nom, age, delaisReponse);
		AirBnBData.getInstance().getHotes().add(newHote);

	}

	public static void supprimerHote(Hote hote) throws InputMismatchException, IndexOutOfBoundsException {

		boolean logementASuppr = false;
		ArrayList listeHote = AirBnBData.getInstance().getHotes();
		ArrayList<Logement> listeLogementASuppr = new ArrayList<>();
		listeHote.remove(hote);

		for (Logement logement: AirBnBData.getInstance().getLogements()) {
			if(logement.getHote() == hote){
				listeLogementASuppr.add(logement);
				logementASuppr = true;
			}
		}

		if (logementASuppr){
			for (int i = 0; i < listeLogementASuppr.size() ; i++) {
				AirBnBData.getInstance().getLogements().remove(listeLogementASuppr.get(i));
			}
		}
	}
}
