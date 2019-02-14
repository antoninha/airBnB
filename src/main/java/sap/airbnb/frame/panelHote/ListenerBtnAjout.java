package sap.airbnb.frame.panelHote;
import sap.airbnb.menu.GestionHotes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerBtnAjout implements ActionListener {

    private JTextField champTextePrenom;
    private JTextField champTexteNom;
    private JTextField champTexteAge;
    private JTextField champTexteDelaiReponse;

    public ListenerBtnAjout(JTextField champTextePrenom, JTextField champTexteNom, JTextField champTexteAge, JTextField champTexteDelaiReponse) {
        this.champTextePrenom = champTextePrenom;
        this.champTexteNom = champTexteNom;
        this.champTexteAge = champTexteAge;
        this.champTexteDelaiReponse = champTexteDelaiReponse;
    }

    @Override
    public void actionPerformed(ActionEvent e){
                String prenom = champTextePrenom.getText();
                String nom = champTexteNom.getText();
                int age =Integer.parseInt(champTexteAge.getText());
                int delaiReponse =Integer.parseInt(champTexteDelaiReponse.getText());
                GestionHotes.ajouterHote(prenom,nom,age,delaiReponse);


    }
}
