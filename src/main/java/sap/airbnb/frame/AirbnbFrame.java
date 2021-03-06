package sap.airbnb.frame;

import java.awt.Dimension;

import javax.swing.*;

import sap.airbnb.frame.menubar.MenuBar;

/**
 * AirbnbFrame
 */
public class AirbnbFrame extends JFrame {

    private JMenuBar menuBar;

    public AirbnbFrame() {
        
        menuBar = new MenuBar();

        setTitle("AirBnB");
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(menuBar);
    }
}
