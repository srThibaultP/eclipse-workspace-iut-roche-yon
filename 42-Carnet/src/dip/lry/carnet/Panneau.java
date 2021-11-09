package dip.lry.carnet;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panneau extends JPanel {
    private JComboBox titre;
    private JTextField nom, prenom;
    private JTextArea adresse;
    private JPanel panLabel, panSaisie;
    private JLabel labTitre, labNon, labPrenom, labAdresse;


    public void Panneau() {}

    public JComboBox getTitre() {
        return titre;
    }

    public JTextField getNom() {
        return nom;
    }

    public JTextField getPrenom() {
        return prenom;
    }

    public JTextArea getAdresse() {
        return adresse;
    }   
}
