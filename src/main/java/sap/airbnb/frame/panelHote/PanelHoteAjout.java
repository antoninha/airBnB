package sap.airbnb.frame.panelHote;

import sun.tools.jps.Jps;

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

        panelListeHote.add(labelPrenom);
        panelListeHote.add(champTextePrenom);

        panelListeHote.add(labelNom);
        panelListeHote.add(champTexteNom);

        panelListeHote.add(labelAge);
        panelListeHote.add(champTexteAge);

        panelListeHote.add(labelDelaiReponse);
        panelListeHote.add(champTexteDelaiReponse);

        panelListeHote.add(btnValider);
        panelListeHote.add(btnAnnuler);

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
