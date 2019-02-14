package sap.airbnb.frame.panelHote;

import javax.swing.*;

public class PanelHoteAjout extends JPanel {

    private JPanel panelListeHote = new JPanel();
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

    public PanelHoteAjout() {

        add(labelPrenom);
        add(champTextePrenom);

        add(labelNom);
        add(champTexteNom);

        add(labelAge);
        add(champTexteAge);

        add(labelDelaiReponse);
        add(champTexteDelaiReponse);

        add(btnValider);
        add(btnAnnuler);

        ListenerBtnAjout clicBtnAjouter = new ListenerBtnAjout(
            champTextePrenom.getText(),
            champTextePrenom.getText(),
            Integer.parseInt(champTexteAge.getText()),
            Integer.parseInt(champTexteDelaiReponse.getText())
        );
        btnValider.addActionListener(clicBtnAjouter);
    }

    public JPanel getPanelListeHote() {

        return panelListeHote;
    }
}
