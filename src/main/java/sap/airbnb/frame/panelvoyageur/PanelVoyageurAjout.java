package sap.airbnb.frame.panelvoyageur;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * PanelVoyageurAjout
 */
public class PanelVoyageurAjout extends JPanel {

    private JLabel prenomLabel;
    private JLabel nomLabel;
    private JLabel ageLabel;

    private JTextField prenomField;
    private JTextField nomField;
    private JTextField ageField;

    private JButton ajouterButton;
    private JButton annulerButton;

    public PanelVoyageurAjout() {

        GridBagConstraints gbc = new GridBagConstraints();

        setLayout(new GridBagLayout());

        prenomLabel = new JLabel("Prénom :");
        nomLabel = new JLabel("Nom :");
        ageLabel = new JLabel("Âge :");

        prenomField = new JTextField();
        prenomField.setToolTipText("Entrez votre prénom");

        nomField = new JTextField();
        nomField.setToolTipText("Entrez votre nom");

        ageField = new JTextField();
        ageField.setToolTipText("Entrez votre âge");
        ajouterButton = new JButton("Ajouter");
        annulerButton = new JButton("Annuler");

        gbc.gridx = gbc.gridy = 0;
        gbc.gridheight = gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets.right = 3;
        add(prenomLabel, gbc);
        
        gbc.gridy++;
        add(nomLabel, gbc);

        gbc.gridy++;
        add(ageLabel, gbc);

        gbc.gridy++;
        gbc.gridx += 2;
        gbc.insets.right = 0;
        add(ajouterButton, gbc);

        gbc.gridx--;
        add(annulerButton, gbc);

        gbc.gridy--;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(ageField, gbc);

        gbc.gridy--;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(nomField, gbc);

        gbc.gridy--;
        add(prenomField, gbc);
    }
}
