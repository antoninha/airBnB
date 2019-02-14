package sap.airbnb.frame.panelLogement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import sap.airbnb.data.AirBnBData;
import sap.airbnb.logements.Logement;
import sap.airbnb.menu.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public final class LogementManager {

    static BoxLayout box;
    static AirBnBData Data;

    ///////////////////////////////////////
    //          LISTE LOGEMENT PANEL
    //
    public static JPanel getLogementList(){

        JPanel panel = new JPanel();
        AirBnBData data = AirBnBData.getInstance();


        for( Logement logement : data.getLogements()){
            JLabel labelLogement = new JLabel(logement.toString());
            panel.add(labelLogement);
        }

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        return panel;
    }

    ///////////////////////////////////////
    //          AJOUT LOGEMENT PANEL
    //

    public static JPanel addLogement(){

        JPanel main = new JPanel();
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel2.setMaximumSize(panel2.getPreferredSize());
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        JPanel appart1 = new JPanel();
        JPanel appart2 = new JPanel();

        JPanel maison1 = new JPanel();
        JPanel maison2 = new JPanel();

        Data = AirBnBData.getInstance();

        box = new BoxLayout(main,BoxLayout.PAGE_AXIS);
        main.setLayout(box);


        // Panel1 ID HOTE
        JLabel idHote = new JLabel("Id de l'hote :");

        JTextField idHoteText = new JTextField();
        idHoteText.setColumns(7);

        panel.add(idHote);
        panel.add(idHoteText);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // PANEL2 TARIF

        JLabel tarifParNuit = new JLabel("Tarif par nuit : ");

        JTextField tarifParNuitText = new JTextField();
        tarifParNuitText.setColumns(7);

        panel2.add(tarifParNuit);
        panel2.add(tarifParNuitText);
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        // PANEL3 ADRESSE

        JLabel adresse = new JLabel("Adresse : ");
        JTextField adresseText = new JTextField();
        adresseText.setColumns(7);
        panel3.add(adresse);
        panel3.add(adresseText);
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

        // PANEL4
        // SUPERFICIE
        JLabel superficie = new JLabel("Superficie : ");
        JTextField superficieText = new JTextField();
        superficieText.setColumns(7);
        panel4.add(superficie);
        panel4.add(superficieText);
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

        // PANEL5
        // NOMBRE DE VOYAGEUR MAXIMUM
        //
        JLabel nbVoyageurMax = new JLabel("Nombre de voyageur maximum : ");
        JTextField nbVoyageurMaxText = new JTextField();
        nbVoyageurMaxText.setColumns(7);
        panel5.add(nbVoyageurMax);
        panel5.add(nbVoyageurMaxText);
        panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

        ButtonGroup bg = new ButtonGroup();

        JRadioButton br1 = new JRadioButton("Maison");
        JRadioButton br2 = new JRadioButton("Appartement");

        bg.add(br1);
        bg.add(br2);





        // APPARTEMENT

        JLabel superficieBalcon = new JLabel("Superficie balcon : ");
        JTextField superficieBalconText = new JTextField("0");
        superficieBalconText.setColumns(7);
        appart1.add(superficieBalcon);
        appart1.add(superficieBalconText);
        appart1.setVisible(false);


        JLabel numAppart = new JLabel("Numero appartement : ");
        JTextField numAppartText = new JTextField();
        numAppartText.setColumns(7);

        appart2.add(numAppart);
        appart2.add(numAppartText);
        appart2.setVisible(false);




        // MAISON

        JLabel superficieJardin = new JLabel("Superficie jardin");
        JTextField superficieJardinText = new JTextField("0");
        superficieJardinText.setColumns(7);

        maison1.add(superficieJardin);
        maison1.add(superficieJardinText);
        maison1.setVisible(false);

        ButtonGroup groupPiscine = new ButtonGroup();

        JRadioButton gp1 = new JRadioButton("Oui");
        JRadioButton gp2 = new JRadioButton("Non");

        gp1.setSelected(false);

        groupPiscine.add(gp1);
        groupPiscine.add(gp2);

        JLabel labelPiscine = new JLabel("Possede piscine : ");

        maison2.add(labelPiscine);
        maison2.add(gp1);
        maison2.add(gp2);
        maison2.setVisible(false);

        // LABEL REUSSITE

        JLabel labelReussite = new JLabel("");



        //
        //
        //                         EVENT LISTENER



        JButton buttonAdd = new JButton("Ajouter");

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // SI TOUT LES CHAMPS DE LOGEMENT SONT REMPLIS

                if(checkInt(nbVoyageurMaxText.getText())  && checkInt(superficieText.getText()) &&
                        adresseText.getText() != "" && checkInt(tarifParNuitText.getText()) &&
                        checkInt(idHoteText.getText() ) && (br1.isSelected() || br2.isSelected())
                        && checkHote(idHoteText.getText())
                        )


                {
                    int nbVoyageurInt = Integer.parseInt(nbVoyageurMaxText.getText());
                    int superficieInt = Integer.parseInt(superficieText.getText());
                    int tarifInt = Integer.parseInt(superficieText.getText());
                    int idHoteInt = Integer.parseInt(idHoteText.getText());

                if(br1.isSelected()){
                    if(checkInt(superficieJardinText.getText()) && (gp1.isSelected() || gp2.isSelected() )){


                        int superficieJardinInt = Integer.parseInt(superficieJardinText.getText());

                        Data.addMaison(idHoteInt,tarifInt,adresseText.getText(),
                                superficieInt,nbVoyageurInt,
                                superficieJardinInt , gp1.isSelected() );

                        labelReussite.setText("La maison a été ajouté");

/*
                        for(Logement log : Data.getLogements()){
                            log.afficher();
                        }
                        */

                    }
                    else{
                        labelReussite.setText("Il y a une erreur dans le formulaire");
                    }
                }
                else{
                    if(checkInt(superficieBalconText.getText()) && checkInt(numAppartText.getText()))
                    {
                       int superficieBalconInt = Integer.parseInt(superficieBalconText.getText());
                       int numAppartInt = Integer.parseInt(numAppartText.getText());

                       Data.addAppartement(idHoteInt,tarifInt,adresseText.getText(),
                               superficieInt,nbVoyageurInt,superficieBalconInt,numAppartInt);

                       for(Logement log : Data.getLogements()){
                           log.afficher();
                       }

                        labelReussite.setText("L'appartement a été ajouté");



                    }
                    else{
                        labelReussite.setText("Il y a une erreur dans le formulaire");
                    }

                }


                }
                else{
                    labelReussite.setText("Il y a une erreur dans le formulaire");
                }

            }
        });


        br1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maison1.setVisible(true);
                maison2.setVisible(true);
                appart1.setVisible(false);
                appart2.setVisible(false);

            }
        });

        br2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maison1.setVisible(false);
                maison2.setVisible(false);
                appart1.setVisible(true);
                appart2.setVisible(true);
            }
        });

        //
        //
        // AJOUT AU MAIN JPANEL

        panel.setMaximumSize(panel.getPreferredSize());
        panel2.setMaximumSize(panel2.getPreferredSize());
        panel3.setMaximumSize(panel3.getPreferredSize());
        panel4.setMaximumSize(panel4.getPreferredSize());
        panel5.setMaximumSize(panel5.getPreferredSize());
        appart1.setMaximumSize(appart1.getPreferredSize());
        appart2.setMaximumSize(appart2.getPreferredSize());
        maison1.setMaximumSize(maison1.getPreferredSize());
        maison2.setMaximumSize(maison2.getPreferredSize());


        main.add(panel);
        main.add(panel2);
        main.add(panel3);
        main.add(panel4);
        main.add(panel5);

        main.add(br1);
        main.add(br2);

        main.add(appart1);
        main.add(appart2);

        main.add(maison1);
        main.add(maison2);
        main.add(buttonAdd);
        main.add(labelReussite);



        return main;

    }

    private static boolean checkInt(String stringToTest){
        try{
           Integer.parseInt(stringToTest);
           return true;
        }
        catch(Exception e)
        {
           return false;
        }

    }

    private static boolean checkHote(String idHote){
        try{
            Data.getHotes().get(Integer.parseInt(idHote));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
