package sap.airbnb.frame;

import javax.swing.*;

import sap.airbnb.frame.menubar.MenuBar;

/**
 * AirbnbFrame
 */
public class AirbnbFrame extends JFrame {

    private JMenuBar menuBar;
    private JPanel mainPanel;

    public AirbnbFrame() {
        
        menuBar = new MenuBar();
        mainPanel = new JPanel();

        setTitle("AirBnB");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(menuBar);
        setContentPane(mainPanel);
    }

    /**
     * @param mainPanel the mainPanel to set
     */
    public void setMainPanel(JPanel pMainPanel) {

        setContentPane(pMainPanel);
        repaint();
    }
}
