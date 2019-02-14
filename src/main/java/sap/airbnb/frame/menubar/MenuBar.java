package sap.airbnb.frame.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import sap.airbnb.frame.AirbnbFrame;
import sap.airbnb.frame.panelHote.PanelHoteListe;

/**
 * MenuBar
 */


public class MenuBar extends JMenuBar {

    private JMenu fileMenu;
        private JMenuItem quitFileMenuItem;

    private JMenu hostMenu;
        private JMenuItem addHostMenuItem;
        private JMenuItem subHostMenuItem;
        private JMenuItem listHostMenuItem;

    private JMenu homeMenu;
        private JMenuItem addHomeMenuItem;
        private JMenuItem subHomeMenuItem;
        private JMenuItem listHomeMenuItem;

    private JMenu stayMenu;
        private JMenuItem addStayMenuItem;
        private JMenuItem subStayMenuItem;
        private JMenuItem listStayMenuItem;
        private JMenuItem searchStayMenuItem;

    private JMenu resvMenu;
        private JMenuItem addResvMenuItem;
        private JMenuItem subResvMenuItem;
        private JMenuItem listResvMenuItem;

    public MenuBar() {
        
        fileMenu = new JMenu("Fichier");
        add(fileMenu);
            quitFileMenuItem = new JMenuItem("Quitter");
            fileMenu.add(quitFileMenuItem);
            quitFileMenuItem.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    ((JFrame)getTopLevelAncestor()).dispose();
                }
            });

        hostMenu = new JMenu("Hotes");
        add(hostMenu);
            listHostMenuItem = new JMenuItem("Lister");
            hostMenu.add(listHostMenuItem);
            listHostMenuItem.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent e) {

                    AirbnbFrame airbnbFrame = ((AirbnbFrame)getTopLevelAncestor());

                   // airbnbFrame.setMainPanel(new PanelHoteListe());
                }
            });
            addHostMenuItem = new JMenuItem("Ajouter");
            hostMenu.add(addHostMenuItem);
            subHostMenuItem = new JMenuItem("Supprimer");
            hostMenu.add(subHostMenuItem);

        homeMenu = new JMenu("Logements");
        add(homeMenu);
            listHomeMenuItem = new JMenuItem("Lister");
            homeMenu.add(listHomeMenuItem);
            addHomeMenuItem = new JMenuItem("Ajouter");
            homeMenu.add(addHomeMenuItem);
            subHomeMenuItem = new JMenuItem("Supprimer");
            homeMenu.add(subHomeMenuItem);

        stayMenu = new JMenu("Séjours");
        add(stayMenu);
            searchStayMenuItem = new JMenuItem("Rechercher");
            stayMenu.add(searchStayMenuItem);
            listStayMenuItem = new JMenuItem("Lister");
            stayMenu.add(listStayMenuItem);
            addStayMenuItem = new JMenuItem("Ajouter");
            stayMenu.add(addStayMenuItem);
            subStayMenuItem = new JMenuItem("Supprimer");
            stayMenu.add(subStayMenuItem);

        resvMenu = new JMenu("Réservations");
        add(resvMenu);
            listResvMenuItem = new JMenuItem("Lister");
            resvMenu.add(listResvMenuItem);
            addResvMenuItem = new JMenuItem("Ajouter");
            resvMenu.add(addResvMenuItem);
            subResvMenuItem = new JMenuItem("Supprimer");
            resvMenu.add(subResvMenuItem);
    }

}

