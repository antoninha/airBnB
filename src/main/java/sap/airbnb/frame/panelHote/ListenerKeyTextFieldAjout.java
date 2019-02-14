package sap.airbnb.frame.panelHote;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListenerKeyTextFieldAjout implements KeyListener {
    PanelHoteAjout panelHoteAjout;

    public ListenerKeyTextFieldAjout(PanelHoteAjout panelHoteAjout) {
        this.panelHoteAjout = panelHoteAjout;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==10){
            panelHoteAjout.validate();
        }
    }

    @Override

    public void keyReleased(KeyEvent e) {

    }
}
