package sap.airbnb.frame.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import sap.airbnb.frame.AirbnbFrame;
import sap.airbnb.frame.panelHote.*;
import sap.airbnb.frame.panelLogement.LogementManager;
import sap.airbnb.frame.panelvoyageur.*;

/**
 * MenuBar
 */
public class MenuBar extends JMenuBar {

    private JMenu fileMenu;
        private JMenuItem quitFileMenuItem;

    private JMenu hostMenu;
        private JMenuItem addHostMenuItem;
        private JMenuItem subHostMenuItem;
        private JMenuItem lstHostMenuItem;

    private JMenu homeMenu;
        private JMenuItem addHomeMenuItem;
        private JMenuItem subHomeMenuItem;
        private JMenuItem lstHomeMenuItem;

    private JMenu trvlMenu;
        private JMenuItem addTrvlMenuItem;
        private JMenuItem subTrvlMenuItem;
        private JMenuItem lstTrvlMenuItem;

    private JMenu resvMenu;
        private JMenuItem stsResvMenuItem;
        private JMenuItem addResvMenuItem;
        private JMenuItem subResvMenuItem;
        private JMenuItem lstResvMenuItem;

    private ItemListener itemListener;

    public MenuBar() {
        
        fileMenu = new JMenu("Fichier");
            quitFileMenuItem = new JMenuItem("Quitter");

        hostMenu = new JMenu("Hotes");
            lstHostMenuItem = new JMenuItem("Lister");
            addHostMenuItem = new JMenuItem("Ajouter");
            subHostMenuItem = new JMenuItem("Supprimer");

        homeMenu = new JMenu("Logements");
            lstHomeMenuItem = new JMenuItem("Lister");
            addHomeMenuItem = new JMenuItem("Ajouter");
            subHomeMenuItem = new JMenuItem("Supprimer");

        trvlMenu = new JMenu("Voyageurs");
            lstTrvlMenuItem = new JMenuItem("Lister");
            addTrvlMenuItem = new JMenuItem("Ajouter");
            subTrvlMenuItem = new JMenuItem("Supprimer");

        resvMenu = new JMenu("Réservations");
            stsResvMenuItem = new JMenuItem("Rechercher séjour");
            lstResvMenuItem = new JMenuItem("Lister");
            addResvMenuItem = new JMenuItem("Ajouter");
            subResvMenuItem = new JMenuItem("Supprimer");

        itemListener = new ItemListener();

        activeMenuBar();
    }

    private void activeMenuBar() {

        activeFileMenu();
        activeHostMenu();
        activeHomeMenu();
        activeTrvlMenu();
        activeResvMenu();
    }

    private void activeFileMenu() {

        add(fileMenu);

        fileMenu.add(quitFileMenuItem);
        quitFileMenuItem.addActionListener(itemListener);
    }

    private void activeHostMenu() {
    
        add(hostMenu);

        hostMenu.add(lstHostMenuItem);
        lstHostMenuItem.addActionListener(itemListener);

        hostMenu.add(addHostMenuItem);
        addHostMenuItem.addActionListener(itemListener);

        hostMenu.add(subHostMenuItem); 
        subHostMenuItem.addActionListener(itemListener);
    }

    private void activeHomeMenu() {
    
        add(homeMenu);
        
        homeMenu.add(lstHomeMenuItem);
        lstHomeMenuItem.addActionListener(itemListener);

        homeMenu.add(addHomeMenuItem);
        addHomeMenuItem.addActionListener(itemListener);

        homeMenu.add(subHomeMenuItem); 
        subHomeMenuItem.addActionListener(itemListener);
    }

    private void activeTrvlMenu() {
    
        add(trvlMenu);
        
        trvlMenu.add(lstTrvlMenuItem);
        lstTrvlMenuItem.addActionListener(itemListener);

        trvlMenu.add(addTrvlMenuItem);
        addTrvlMenuItem.addActionListener(itemListener);

        trvlMenu.add(subTrvlMenuItem); 
        subTrvlMenuItem.addActionListener(itemListener);
    }

    private void activeResvMenu() {
    
        add(resvMenu);
        
        resvMenu.add(stsResvMenuItem);
        stsResvMenuItem.addActionListener(itemListener);

        resvMenu.add(lstResvMenuItem);
        lstResvMenuItem.addActionListener(itemListener);

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

                if (item == lstHostMenuItem) {
                    
                    airbnbFrame.setContentPane(new PanelHoteListe());
                }
                if (item == addHostMenuItem) {
                    
                    airbnbFrame.setContentPane(new PanelHoteAjout());
                }
                if (item == subHostMenuItem) {

                    airbnbFrame.setContentPane(new PanelHoteSupprime());
                }
                if (item == lstHomeMenuItem) {

                    airbnbFrame.setContentPane(LogementManager.getLogementList());
                }
                if (item == addHomeMenuItem) {

                    airbnbFrame.setContentPane(LogementManager.addLogement());
                }
                if (item == lstTrvlMenuItem) {
                    
                    airbnbFrame.setContentPane(new PanelVoyageurListe());
                }
                if (item == addTrvlMenuItem) {
                    
                    airbnbFrame.setContentPane(new PanelVoyageurAjout());
                }
                airbnbFrame.setVisible(true);
            }
        }
    }
}
