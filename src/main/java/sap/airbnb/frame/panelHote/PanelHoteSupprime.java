package sap.airbnb.frame.panelHote;


import sap.airbnb.data.AirBnBData;
import sap.airbnb.utilisateurs.Hote;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;

public class PanelHoteSupprime extends JPanel implements ListSelectionListener {

    private JList listeDeroulanteHote;

    private int idSelect;

    ArrayList<String> tableauNomPrenomHote = new ArrayList<>();

    public PanelHoteSupprime() {

        for (Hote hote:AirBnBData.getInstance().getHotes()) {
            tableauNomPrenomHote.add(hote.getNom() + " " + hote.getPrenom());
        }

        if (tableauNomPrenomHote.size() != 0) {
            JButton btnSuppr = new JButton("Supprimer");

            JScrollPane scrollPane = new JScrollPane();
            listeDeroulanteHote = new JList(tableauNomPrenomHote.toArray());
            scrollPane.createVerticalScrollBar();
            scrollPane.setViewportView(listeDeroulanteHote);
            listeDeroulanteHote.addListSelectionListener(this);

            ListenerBtnSuppr clicBtnSuppr = new ListenerBtnSuppr();
            btnSuppr.addActionListener(clicBtnSuppr);

            add(scrollPane);
            add(btnSuppr);



        } else {
            JLabel labelListeVide = new JLabel("Il n'y a aucun hôte");
            add(labelListeVide);
        }


    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        idSelect = listeDeroulanteHote.getSelectedIndex();
    }


    public int getIdSelect() {
        return idSelect;
    }

}
