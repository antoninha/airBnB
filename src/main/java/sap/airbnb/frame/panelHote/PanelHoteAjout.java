package sap.airbnb.frame.panelHote;

import javax.swing.*;
import java.awt.*;

public class PanelHoteAjout extends  JPanel{

    private JTextField champTextePrenom = new JTextField("");
    private JTextField champTexteNom = new JTextField("");
    private JTextField champTexteAge = new JTextField(0);
    private JTextField champTexteDelaiReponse = new JTextField(0);
    private JLabel labelPrenom = new JLabel("Prénom");
    private JLabel labelNom = new JLabel("Nom");
    private JLabel labelAge = new JLabel("Age");
    private JLabel labelDelaiReponse = new JLabel("Delai de Réponse (en heure)");
    private JButton btnValider = new JButton("Valider");
    private JButton btnAnnuler = new JButton("Annuler");

    public PanelHoteAjout() {
        setLayout(new GridLayout(5,1));

        Panel panelPrenom = new Panel();
        panelPrenom.add(labelPrenom);
        champTextePrenom.setPreferredSize(new Dimension(150,18));
        panelPrenom.add(champTextePrenom);

        Panel panelNom = new Panel();
        panelNom.add(labelNom);
        champTexteNom.setPreferredSize(new Dimension(220,18));
        panelNom.add(champTexteNom);

        Panel panelAge = new Panel();
        panelAge.add(labelAge);
        champTexteAge.setPreferredSize(new Dimension(40,18));
        panelAge.add(champTexteAge);

        Panel panelDelaiReponse = new Panel();
        panelDelaiReponse.add(labelDelaiReponse);
        champTexteDelaiReponse.setPreferredSize(new Dimension(40,18));
        panelDelaiReponse.add(champTexteDelaiReponse);

        Panel panelBtn = new Panel();
        panelBtn.add(btnValider);
        panelBtn.add(btnAnnuler);

        add(panelPrenom);
        add(panelNom);
        add(panelAge);
        add(panelDelaiReponse);
        add(panelBtn);

        ListenerBtnAjout clicBtnAjouter = new ListenerBtnAjout(champTextePrenom,champTexteNom,champTexteAge,champTexteDelaiReponse);
        btnValider.addActionListener(clicBtnAjouter);
    }
}
