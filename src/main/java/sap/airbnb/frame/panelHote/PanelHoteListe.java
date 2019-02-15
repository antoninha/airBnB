package sap.airbnb.frame.panelHote;

import sap.airbnb.data.AirBnBData;
import sap.airbnb.utilisateurs.Hote;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelHoteListe extends JPanel {

    //private ArrayList<JLabel> hotesLabel;

    public PanelHoteListe() {

        int nbHotes = AirBnBData.getInstance().getHotes().size();

        //hotesLabel = new ArrayList<>();

        setLayout(new GridLayout(nbHotes,1));

        for (Hote hote : AirBnBData.getInstance().getHotes()) {

            JLabel hoteLabel = new JLabel(
                hote.getPrenom()
                + " " + hote.getNom()
                + " " +"(" + hote.getAge() + " ans)"
                + " " +"s'engage à répondre dans les " + hote.getDelaiReponse() + " heure(s)."
            );
            //hotesLabel.add(hoteLabel);
            add(hoteLabel);
        }
    }
}
