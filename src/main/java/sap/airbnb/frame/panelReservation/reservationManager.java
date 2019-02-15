package sap.airbnb.frame.panelReservation;

import sap.airbnb.data.AirBnBData;
import sap.airbnb.logements.Logement;
import sap.airbnb.menu.GestionReservations;
import sap.airbnb.reservations.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class reservationManager {
    static BoxLayout box;
    static AirBnBData data = AirBnBData.getInstance();

    ///////////////////////////////////////
    //          LISTE RESERVATION PANEL
    //
    public static JPanel getReservationList(){

        JPanel panel = new JPanel();


        for( Reservation reservation : data.getReservations()){

            JLabel labelReservation = new JLabel( "date d'arrivée le :"+
                    reservation.getSejour().getDateArrivee().toString() + " situé au " + reservation.getSejour().getLogement().getAdresse()+
                    " par "+ reservation.getVoyageur().getPrenom() + " "+reservation.getVoyageur().getNom()
            );
            panel.add(labelReservation);
        }

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        return panel;
    }


    ///////////////////////////////////////
    //          ADD RESERVATION PANEL
    //
    public static JPanel addReservation(){
        JPanel panel = new JPanel();


        return panel;
    }
    static JComboBox comboBox;

    ///////////////////////////////////////
    //          DELETE RESERVATION PANEL
    //
    public static JPanel deleteReservation(){
        JPanel panel = new JPanel();
        JPanel main = new JPanel();

        comboBox = loadComboResa();

        JButton suprimButton = new JButton("Suprimmer");

        suprimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    GestionReservations.supprimerReservation(comboBox.getSelectedIndex());

                    panel.remove(comboBox);

                    comboBox = loadComboResa();


                    panel.add(comboBox);
                    panel.revalidate();
                    panel.repaint();
                }
                catch(Exception E)
                {

                }

            }
        });

        panel.add(comboBox);
        main.add(panel);
        main.add(suprimButton);



        return main;
    }

    private static JComboBox loadComboResa(){

        String logementInter = "";
        String[] logementFormated = new String[data.getReservations().size()];
        int iteration = 0;
        for(Reservation reservation : data.getReservations()){

            logementInter = "date arrivée : " + reservation.getSejour().getDateArrivee()
                    + " au " + reservation.getSejour().getLogement().getAdresse();
            logementFormated[iteration] = logementInter + " / id :" + iteration;
            iteration++;
        }

        JComboBox combo = new JComboBox(logementFormated);

        return combo;
    }

}
