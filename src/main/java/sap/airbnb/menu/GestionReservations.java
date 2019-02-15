package sap.airbnb.menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import sap.airbnb.data.AirBnBData;
import sap.airbnb.reservations.Reservation;
import sap.airbnb.reservations.Sejour;
import sap.airbnb.reservations.SejourCourt;
import sap.airbnb.reservations.SejourLong;

public class GestionReservations {

    protected static void listerReservations() {

        System.out.println("-------------------------------------");
        System.out.println("Liste des réservations ");

        for (int i = 0; i < Menu.listReservations.size(); i++) {
            System.out.print("Numéro " + i + " :");
            Menu.listReservations.get(i).afficher();
        }

        System.out.println("Saisir une option : ");
        System.out.println("1 : Ajouter une réservation");
        System.out.println("2 : Supprimer une réservation");
        System.out.println("3 : Retour");

        try {
            switch (Menu.choix(3)) {
                case 1:
                    //ajouterReservation();
                    break;
                case 2:
                    //supprimerReservation();
                    break;
                case 3:
                    Menu.listerMenu();
                    break;
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Une erreur est survenue lors de la suppression.");
            listerReservations();
        } catch (Exception e) {
            System.out.println("Une erreur est survenue (" + e.getMessage()
                    + ")");
            Menu.scanner.next();
            listerReservations();
        }
    }

    public static void ajouterReservation(Reservation reservation) throws Exception {

        AirBnBData.getInstance().getReservations().add(reservation);

    }

    public static void supprimerReservation(int numero) throws Exception {


        AirBnBData.getInstance().getReservations().remove(numero);
        System.out.println("Votre réservation a été supprimée avec succés");

    }
}
