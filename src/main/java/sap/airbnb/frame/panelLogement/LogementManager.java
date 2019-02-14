package sap.airbnb.frame.panels;

import javax.swing.*;

import sap.airbnb.logements.Logement;
import sap.airbnb.menu.Menu;

import java.awt.*;


public class LogementManager {

    static BoxLayout box;
    public JPanel getLogementList(){

        JPanel panel = new JPanel();


        for( Logement logement : Menu.listLogements){
            JLabel labelLogement = new JLabel(logement.toString());
            panel.add(labelLogement);
        }

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        return panel;
    }

    public JPanel addLogement(){
        JPanel main = new JPanel();
        JPanel panel = new JPanel();
        JPanel test2 = new JPanel();
        JPanel panel2 = new JPanel();


        box = new BoxLayout(main,BoxLayout.PAGE_AXIS);
        main.setLayout(box);


        JLabel t = new JLabel("bouh");
        // Panel1 ID HOTE
        JLabel idHote = new JLabel("id hote");

        JTextField idHoteText = new JTextField();
        idHoteText.setColumns(7);

        panel.add(idHote);
        panel.add(idHoteText);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // PANEL2 TARIF

        JLabel tarifParNuit = new JLabel("id hote");

        JTextField tarifParNuitText = new JTextField();
        idHoteText.setColumns(7);

        panel2.add(tarifParNuit);
        panel2.add(tarifParNuitText);
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        // PANEL3

        test2.add(t);
        main.add(panel);
        main.add(test2);



        return main;

    }


}
