package sap.airbnb.frame.panelvoyageur;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sap.airbnb.data.AirBnBData;
import sap.airbnb.utilisateurs.Voyageur;

/**
 * PanelVoyageurListe
 */
public class PanelVoyageurListe extends JPanel {

    private final JTable voyageursTable;
    private final JScrollPane voyageursScrollPane;

    public PanelVoyageurListe() {

        ArrayList<Voyageur> voyageursArrayList = AirBnBData.getInstance().getVoyageurs();
        int nbVoyageurs = voyageursArrayList.size();

        /*Object[][] voyageursArray = new Object[nbVoyageurs][3];
        String[] columnNames = {"Prénom", "Nom", "Âge"};*/

        Object[][] voyageursArray = new Object[nbVoyageurs][1];
        String[] columnNames = {"Voyageurs présents sur AirBnB"};
        int i = 0;

        for (Voyageur voyageur : voyageursArrayList) {
            
            String identiteVoyageur = 
                voyageur.getPrenom() + " " +
                voyageur.getNom() + " (" +
                voyageur.getAge() + " ans)";
            Object[] contentLine = {identiteVoyageur};

            /*String prenom = voyageursArrayList.get(i).getPrenom();
            String nom = voyageursArrayList.get(i).getNom();
            int age = voyageursArrayList.get(i).getAge();
            Object[] contentLine = {prenom, nom, age};*/

            voyageursArray[i++] = contentLine;
        }
        voyageursTable = new JTable(voyageursArray, columnNames);
        voyageursScrollPane = new JScrollPane(voyageursTable);
        voyageursTable.setEnabled(false);

        setLayout(new GridBagLayout());
        add(voyageursScrollPane);
    }
}
