package sap.airbnb.frame.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import sap.airbnb.frame.AirbnbFrame;
import sap.airbnb.frame.panelHote.*;
import sap.airbnb.frame.panelLogement.LogementManager;

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

    private ItemListener itemListener;

    public MenuBar() {
        
        fileMenu = new JMenu("Fichier");
            quitFileMenuItem = new JMenuItem("Quitter");

        hostMenu = new JMenu("Hotes");
            listHostMenuItem = new JMenuItem("Lister");
            addHostMenuItem = new JMenuItem("Ajouter");
            subHostMenuItem = new JMenuItem("Supprimer");

        homeMenu = new JMenu("Logements");
            listHomeMenuItem = new JMenuItem("Lister");
            addHomeMenuItem = new JMenuItem("Ajouter");
            subHomeMenuItem = new JMenuItem("Supprimer");

        stayMenu = new JMenu("Séjours");
            searchStayMenuItem = new JMenuItem("Rechercher");
            listStayMenuItem = new JMenuItem("Lister");
            addStayMenuItem = new JMenuItem("Ajouter");
            subStayMenuItem = new JMenuItem("Supprimer");

        resvMenu = new JMenu("Réservations");
            listResvMenuItem = new JMenuItem("Lister");
            addResvMenuItem = new JMenuItem("Ajouter");
            subResvMenuItem = new JMenuItem("Supprimer");

        itemListener = new ItemListener();

        activeMenuBar();
    }

    private void activeMenuBar() {

        activeFileMenu();
        activeHostMenu();
        activeHomeMenu();
        activeStayMenu();
        activeResvMenu();
    }

    private void activeFileMenu() {

        add(fileMenu);

        fileMenu.add(quitFileMenuItem);
        quitFileMenuItem.addActionListener(itemListener);
    }

    private void activeHostMenu() {
    
        add(hostMenu);

        hostMenu.add(listHostMenuItem);
        listHostMenuItem.addActionListener(itemListener);

        hostMenu.add(addHostMenuItem);
        addHostMenuItem.addActionListener(itemListener);

        hostMenu.add(subHostMenuItem); 
        subHostMenuItem.addActionListener(itemListener);
    }

    private void activeHomeMenu() {
    
        add(homeMenu);
        
        homeMenu.add(listHomeMenuItem);
        listHomeMenuItem.addActionListener(itemListener);

        homeMenu.add(addHomeMenuItem);
        addHomeMenuItem.addActionListener(itemListener);

        homeMenu.add(subHomeMenuItem); 
        subHomeMenuItem.addActionListener(itemListener);
    }

    private void activeStayMenu() {
    
        add(stayMenu);
        
        stayMenu.add(searchStayMenuItem);
        searchStayMenuItem.addActionListener(itemListener);

        stayMenu.add(listStayMenuItem);
        listStayMenuItem.addActionListener(itemListener);

        stayMenu.add(addStayMenuItem);
        addStayMenuItem.addActionListener(itemListener);

        stayMenu.add(subStayMenuItem); 
        subStayMenuItem.addActionListener(itemListener);
    }

    private void activeResvMenu() {
    
        add(resvMenu);
        
        resvMenu.add(listResvMenuItem);
        listResvMenuItem.addActionListener(itemListener);

        resvMenu.add(addResvMenuItem);
        addResvMenuItem.addActionListener(itemListener);

        resvMenu.add(subResvMenuItem); 
        subResvMenuItem.addActionListener(itemListener);
    }

    /**
     * ItemListener
     */
    private class ItemListener implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent e) {
            
            JMenuItem item = (JMenuItem)e.getSource();
            AirbnbFrame airbnbFrame = ((AirbnbFrame)getTopLevelAncestor());

            if (item == quitFileMenuItem) {
                
                airbnbFrame.dispose();
            }
            else {

                if (item == listHostMenuItem) {
                    
                    airbnbFrame.setContentPane(new PanelHoteListe());
                }
                if (item == addHostMenuItem) {
                    
                    airbnbFrame.setContentPane(new PanelHoteAjout());
                }
                if (item == listHomeMenuItem) {

                    airbnbFrame.setContentPane(LogementManager.getLogementList());
                }
                if (item == addHomeMenuItem) {

                    airbnbFrame.setContentPane(LogementManager.addLogement());
                }
                airbnbFrame.setVisible(true);
            }
        }
    }
}
