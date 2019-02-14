package sap.airbnb.frame.panelHote;

import sap.airbnb.data.AirBnBData;
import sap.airbnb.utilisateurs.Hote;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelHoteListe extends JPanel {

    private int nbHotes = AirBnBData.getInstance().getHotes().size();
    private ArrayList<JLabel> labelHote = new ArrayList<>();

    public PanelHoteListe() {
        for (int i = 0; i < nbHotes ; i++) {
            labelHote.add(new JLabel());
        }

        setLayout(new GridLayout(nbHotes,1));
        for (int i = 0; i < labelHote.size(); i++) {
            add(labelHote.get(i));
            Hote hote = AirBnBData.getInstance().getHotes().get(i);
            labelHote.get(i).setText(
                      "Hôte n°" + i
                    + "/Prénom : " + hote.getPrenom()
                    + "/Nom : " + hote.getNom()
                    + "/Age : " + hote.getAge()
                    + "/Delai de réponse : " + hote.getDelaiReponse()
            );

        }
    }
}
