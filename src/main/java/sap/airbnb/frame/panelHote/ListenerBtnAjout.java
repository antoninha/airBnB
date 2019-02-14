package sap.airbnb.frame.panelHote;
import sap.airbnb.menu.GestionHotes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerBtnAjout implements ActionListener {
    private String prenom;
    private String nom;
    private int age;
    private int delaiReponse;


    public ListenerBtnAjout(String prenom, String nom, int age, int delaiReponse) {
        
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.delaiReponse = delaiReponse;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //try {
            GestionHotes.ajouterHote(prenom,nom,age,delaiReponse);
        //} catch (Exception a){
        //    System.out.println("Erreur ajoutHote, champs vides ou non correctement renseignés");
        //}
    }
}
