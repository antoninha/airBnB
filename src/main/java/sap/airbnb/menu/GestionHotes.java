package sap.airbnb.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import sap.airbnb.data.AirBnBData;
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
				supprimerHote();
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
		System.out.println(prenom);
		System.out.println(nom);
		System.out.println(age);
		System.out.println(delaisReponse);
		AirBnBData.getInstance().getHotes().add(newHote);

	}

	private static void supprimerHote() throws InputMismatchException, IndexOutOfBoundsException {

		System.out.println("-------------------------------------");
		System.out.println("Supprimer un hôte");

		System.out.print("Numéro : ");
		int numero = Menu.scanner.nextInt();
		System.out.println();

		Menu.listHotes.remove(numero);

		System.out.println("Votre hôte a été supprimé avec succés");
		listerHotes();
	}
}
