package sap.airbnb.frame.panelHote;

import sap.airbnb.menu.GestionHotes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerBtnSuppr implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        JFrame frame = (JFrame) button.getTopLevelAncestor();
        PanelHoteSupprime panelHoteSupprime = (PanelHoteSupprime)button.getParent();

        GestionHotes.supprimerHote(panelHoteSupprime.getIdSelect());
        frame.setContentPane(new PanelHoteSupprime());
        frame.setVisible(true);
    }
}
