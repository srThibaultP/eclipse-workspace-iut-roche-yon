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


    public Panneau() {
        super();
        this.titre = new JComboBox();
        this.nom = new JTextField("Nom");
        this.prenom = new JTextField("Prénom");
        this.adresse = new JTextArea("Adresse");
        this.panLabel = new JPanel();
        this.panSaisie = new JPanel();
        this.labTitre = new JLabel();
        this.labNon = new JLabel();
        this.labPrenom = new JLabel();
        this.labAdresse = new JLabel();

        
    }

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
