package sap.airbnb.frame.panelHote;

import sap.airbnb.menu.GestionHotes;

import javax.swing.*;
import java.awt.*;

public class PanelHoteAjout extends  JPanel{

    private JTextField champTextePrenom = new JTextField("");
    private JTextField champTexteNom = new JTextField("");
    private JTextField champTexteAge = new JTextField("0");
    private JTextField champTexteDelaiReponse = new JTextField("0");
    private JLabel labelPrenom = new JLabel("Prénom");
    private JLabel labelNom = new JLabel("Nom");
    private JLabel labelAge = new JLabel("Age");
    private JLabel labelDelaiReponse = new JLabel("Delai de Réponse (en heure)");
    private JButton btnValider = new JButton("Valider");
    private JButton btnAnnuler = new JButton("Annuler");
    private JLabel labelErreur = new JLabel("");

    public PanelHoteAjout() {
        setLayout(new GridLayout(6,1));

        JPanel panelPrenom = new JPanel();
        panelPrenom.add(labelPrenom);
        champTextePrenom.setPreferredSize(new Dimension(150,18));

        panelPrenom.add(champTextePrenom);

        JPanel panelNom = new JPanel();
        panelNom.add(labelNom);
        champTexteNom.setPreferredSize(new Dimension(220,18));
        panelNom.add(champTexteNom);

        JPanel panelAge = new JPanel();
        panelAge.add(labelAge);
        champTexteAge.setPreferredSize(new Dimension(40,18));
        panelAge.add(champTexteAge);

        JPanel panelDelaiReponse = new JPanel();
        panelDelaiReponse.add(labelDelaiReponse);
        champTexteDelaiReponse.setPreferredSize(new Dimension(40,18));
        panelDelaiReponse.add(champTexteDelaiReponse);

        JPanel panelBtn = new JPanel();
        panelBtn.add(btnValider);
        panelBtn.add(btnAnnuler);

        JPanel panelErreur = new JPanel();
        panelErreur.add(labelErreur);

        add(panelPrenom);
        add(panelNom);
        add(panelAge);
        add(panelDelaiReponse);
        add(panelBtn);
        add(panelErreur);

        ListenerBtnAjout clicBtnAjouter = new ListenerBtnAjout(this);
        btnValider.addActionListener(clicBtnAjouter);

        ListenerKeyTextFieldAjout listenerKeyTextFieldAjout = new ListenerKeyTextFieldAjout(this);
        champTextePrenom.addKeyListener(listenerKeyTextFieldAjout);
        champTexteNom.addKeyListener(listenerKeyTextFieldAjout);
        champTexteAge.addKeyListener(listenerKeyTextFieldAjout);
        champTexteDelaiReponse.addKeyListener(listenerKeyTextFieldAjout);

    }

    public void validate(){

        String prenom = champTextePrenom.getText();
        String nom = champTexteNom.getText();

        try {
            int age = Integer.parseInt(champTexteAge.getText());
            int delaiReponse = Integer.parseInt(champTexteDelaiReponse.getText());
            if (champTextePrenom.getText().equals("") || champTexteNom.getText().equals("") || champTexteAge.getText().equals("") || champTexteDelaiReponse.getText().equals("")) {
                triggerError("Tous les champs doivent être renseignés");
            }else {
                GestionHotes.ajouterHote(prenom, nom, age, delaiReponse);

                champTexteNom.setText("");
                champTextePrenom.setText("");
                champTexteAge.setText("0");
                champTexteDelaiReponse.setText("0");

                labelErreur.setText("");
            }

        }catch (NumberFormatException e){
            triggerError("Les champs Age et Delai de réponse doivent contenir un nombre");
        }


    }

    public void triggerError(String msgErreur) {
        labelErreur.setText(msgErreur);
    }


}
