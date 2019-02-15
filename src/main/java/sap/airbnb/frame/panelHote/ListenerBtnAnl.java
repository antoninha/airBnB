package sap.airbnb.frame.panelHote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerBtnAnl implements ActionListener {
    PanelHoteAjout panelHoteAjout;

    public ListenerBtnAnl(PanelHoteAjout panelHoteAjout) {
        this.panelHoteAjout = panelHoteAjout;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panelHoteAjout.resetChamps();
    }
}
