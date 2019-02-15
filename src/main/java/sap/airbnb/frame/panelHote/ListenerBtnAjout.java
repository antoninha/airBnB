package sap.airbnb.frame.panelHote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerBtnAjout implements ActionListener {
    PanelHoteAjout panelHoteAjout;


    public ListenerBtnAjout(PanelHoteAjout panelHoteAjout) {

        this.panelHoteAjout = panelHoteAjout;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            panelHoteAjout.validate();
        }catch (Exception a){
            panelHoteAjout.triggerError("erreur validate()");
        }

    }

}
