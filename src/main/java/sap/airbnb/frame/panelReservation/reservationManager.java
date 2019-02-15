package sap.airbnb.frame.panelReservation;

import com.sun.tools.javac.tree.JCTree;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import sap.airbnb.data.AirBnBData;
import sap.airbnb.frame.panelLogement.LogementManager;
import sap.airbnb.logements.Logement;
import sap.airbnb.menu.GestionReservations;
import sap.airbnb.reservations.*;
import sap.airbnb.utilisateurs.Voyageur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import static sap.airbnb.frame.panelLogement.LogementManager.checkInt;

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

        JLabel labelLogement = new JLabel("Logement : ");
        JComboBox comboBoxLogement = LogementManager.loadLogement();

        JLabel nbNuits = new JLabel("Nombre de nuits");
        JTextField nbNuitsText = new JTextField();
        nbNuitsText.setColumns(7);

        JLabel nbVoyageur = new JLabel("Nombre de voyageurs");
        JTextField nbVoyageurText = new JTextField();
        nbVoyageurText.setColumns(7);

        JComboBox comboBoxVoyageur = loadVoyageur();

        JLabel reussiteMess = new JLabel("");

        UtilDateModel model = new UtilDateModel();
        model.setDate(2019,02,15);
        Properties p = new Properties();
        p.put("text.today", "Jour");
        p.put("text.month", "Mois");
        p.put("text.year", "Annéee");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());


        JButton ajouter = new JButton("Ajouter");

        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                Date selectedDate = (Date) datePicker.getModel().getValue();
                if(selectedDate != null
                        && comboBoxVoyageur.getItemCount() != 0
                        && comboBoxLogement.getItemCount() != 0
                        && checkInt(nbNuitsText.getText())
                        && checkInt(nbVoyageurText.getText())
                        ){

                    Sejour sejour =
                            SejourFactory.getSejour(selectedDate,
                                    data.getLogements().get(comboBoxLogement.getSelectedIndex()),
                                    Integer.parseInt(nbNuitsText.getText()),
                                    Integer.parseInt(nbVoyageurText.getText())

                            );

                        GestionReservations.ajouterReservation(
                                new Reservation(sejour,
                                        data.getVoyageurs().get(comboBoxVoyageur.getSelectedIndex()))
                        );

                        reussiteMess.setText("Ajout réussi");

                }

                else{
                    reussiteMess.setText("Un des champs est mal renseigné. ");
                }

                }
                catch(IllegalArgumentException a)
                {
                    reussiteMess.setText("Un des champs est mal renseigné. " + a.getMessage());
                }
                catch(Exception a)

                {
                    reussiteMess.setText("Un des champs est mal renseigné. ");
                }



            }
        });



        panel.add(labelLogement);
        panel.add(comboBoxLogement);
        panel.add(nbNuits);
        panel.add(nbNuitsText);
        panel.add(nbVoyageur);
        panel.add(nbVoyageurText);
        panel.add(new JLabel("date : "));
        panel.add(datePicker);
        panel.add(new JLabel("Voyageur :"));
        panel.add(comboBoxVoyageur);
        panel.add(ajouter);
        panel.add(reussiteMess);




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




    ///////////////////////////////////////
    //          PARTIE FONCTION
    //

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


    private static JComboBox loadVoyageur(){

        String voyageurInter = "";
        String[] voyageurFormated = new String[data.getVoyageurs().size()];
        int iteration = 0;
        for(Voyageur voyageur : data.getVoyageurs()){

            voyageurInter = voyageur.getNom()+" "+voyageur.getPrenom();
            voyageurFormated[iteration] = voyageurInter + " / id :" + iteration;

            iteration++;
        }
        JComboBox comboBox = new JComboBox(voyageurFormated);
        return comboBox;

    }

    public static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }

}
