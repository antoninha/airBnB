package sap.airbnb;

import java.util.ArrayList;
import java.util.Date;

import sap.airbnb.data.AirBnBData;
import sap.airbnb.data.Search;
import sap.airbnb.logements.Logement;
import sap.airbnb.utilisateurs.Voyageur;
import sap.airbnb.reservations.*;

public class Main {

    public static void main(String[] args) {

        /*
        Search.SearchBuilder searchBuilder = new Search.SearchBuilder(2).possedeBalcon(false);
        Search search = searchBuilder.build();
        ArrayList<Logement> logements = search.result();

        for (Logement logement: logements) {
            System.out.println("--------------------------");
            logement.afficher();
        }

        */


        Voyageur voyageur = AirBnBData.getInstance().getVoyageurs().get(0);

        // Critères de mon séjour
        Date dateArrivee = new Date(1552255232322l);
        Logement logement = AirBnBData.getInstance().getLogements().get(1);
        int nbNuits = 2;
        int nbVoyageurs = 2;

        Sejour sejour = SejourFactory.getSejour(dateArrivee, logement, nbNuits, nbVoyageurs);

        // Réservation
        Reservation reservation = new Reservation(sejour, voyageur);
        reservation.afficher();
    }
}
