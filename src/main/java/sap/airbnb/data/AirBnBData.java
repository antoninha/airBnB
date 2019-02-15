package sap.airbnb.data;

import sap.airbnb.logements.Appartement;
import sap.airbnb.logements.Logement;
import sap.airbnb.logements.Maison;
import sap.airbnb.reservations.Reservation;
import sap.airbnb.reservations.SejourCourt;
import sap.airbnb.reservations.SejourFactory;
import sap.airbnb.utilisateurs.Hote;
import sap.airbnb.utilisateurs.Voyageur;
import sap.airbnb.reservations.Sejour;

import java.util.ArrayList;
import java.util.Date;

public final class AirBnBData {

    private static final AirBnBData INSTANCE = new AirBnBData();

    private final ArrayList<Hote> hotes;
    private final ArrayList<Voyageur> voyageurs;
    private final ArrayList<Logement> logements;
    private final ArrayList<Sejour> sejours;
    private final ArrayList<Reservation> reservations;


    private AirBnBData() {

        hotes = new ArrayList<>();
        voyageurs = new ArrayList<>();
        logements = new ArrayList<>();
        sejours = new ArrayList<>();
        reservations = new ArrayList<>();



        // Reservation



        // Hotes
        hotes.add(new Hote("Bardu", "Peter", 30, 12));
        hotes.add(new Hote("Bardu", "Tom", 34, 12));
        hotes.add(new Hote("Albert", "Max", 33, 24));
        hotes.add(new Hote("Patrick", "Martin", 32, 12));
        hotes.add(new Hote("Jeanne", "Voisin", 26, 24));
        hotes.add(new Hote("Maurice", "Meunier", 46, 12));

        // Voyageurs
        voyageurs.add(new Voyageur("ALBERT", "Jean", 21));
        voyageurs.add(new Voyageur("DURANT", "Marcel", 75));
        voyageurs.add(new Voyageur("HIKET", "Colette", 63));



        // Logements
        logements.add(new Maison(hotes.get(4), 100, "82 rue Colbert, 37000 Tours", 100, 4, 1000, true));
        logements.add(new Maison(hotes.get(1), 250, "84 rue Colbert, 37000 Tours", 80, 2, 2000, false));
        logements.add(new Maison(hotes.get(2), 80, "86 rue Colbert, 37000 Tours", 120, 2, 0, false));
        logements.add(new Appartement(hotes.get(1), 100, "85 rue Colbert, 37000 Tours", 100, 6, 0, 3));
        logements.add(new Maison(hotes.get(0), 40, "18 Bis rue Romain Rolland, 37230 Fondettes", 140, 10, 500, false));
        logements.add(new Maison(hotes.get(3), 35, "146 Rue George Sand, 59553 Cuincy", 120, 2, 0, false));
        logements.add(new Maison(hotes.get(5), 60, "13 Rue de la Liberté, 62800 Liévin", 90, 4, 2000, true));
        logements.add(new Appartement(hotes.get(2), 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 20));
        logements.add(new Appartement(hotes.get(4), 35, "111 Rue Colbert, 37000 Tours", 42, 2, 12, 0));

        // Sejours
        Date date = new Date(124,42,24);

        sejours.add(SejourFactory.getSejour(date,logements.get(1),3,1));
        sejours.add(SejourFactory.getSejour(date,logements.get(4),2,1));
        sejours.add(SejourFactory.getSejour(date,logements.get(6),1,1));

        sejours.get(0).afficher();

        reservations.add(new Reservation(sejours.get(0),voyageurs.get(0)));
        reservations.add(new Reservation(sejours.get(1),voyageurs.get(0)));
        reservations.add(new Reservation(sejours.get(2),voyageurs.get(0)));

    }

    public static AirBnBData getInstance() {
        return INSTANCE;
    }

    public ArrayList<Hote> getHotes() {
        return hotes;
    }

    public ArrayList<Logement> getLogements() {
        return logements;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void addAppartement(int idHote, int tarif, String adresse, int superficie, int nbVoyageur, int superficieBalcon, int numeroEtage){
        logements.add(new Appartement(hotes.get(idHote), tarif, adresse, superficie, nbVoyageur, superficieBalcon, numeroEtage));
    }

    public void addMaison(int idHote, int tarif, String adresse, int superficie, int nbVoyageur,int superficieJardin, boolean possedePisicine){
        logements.add(new Maison(hotes.get(idHote), tarif, adresse, superficie, nbVoyageur, superficieJardin, possedePisicine));
    }



    public ArrayList<Voyageur> getVoyageurs() {
        return voyageurs;
    }
}
