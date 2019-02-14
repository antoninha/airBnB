package sap.airbnb;


import java.util.ArrayList;

import sap.airbnb.logements.Logement;
import sap.airbnb.utilisateurs.Hote;
import sap.airbnb.utilisateurs.Voyageur;
import sap.airbnb.reservations.*;
import sap.airbnb.frame.panelLogement.*;

import javax.swing.*;

public class Main {
    static int iteration = 0;
    static JFrame frame;
    static JLabel count;


    public static ArrayList<Hote> listHotes;
    public static ArrayList<Logement> listLogements;
    public static ArrayList<Voyageur> listVoyageurs;
    public static ArrayList<Reservation> listReservations;

    public static void main(String[] args) {





        frame = new JFrame();


         LogementManager logementManger = new LogementManager();

        // Fenetre principale
        frame.setTitle("Hello !");
        frame.setSize(320,140);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = logementManger.getLogementList();

        frame.add(panel);
        //frame.pack();
        frame.setVisible(true);

    }

}
