package dip.lry.carnet;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Panneau extends JPanel {
    
    /*************************** ATTRIBUTS ********************************/

    private JComboBox titre;
    private JTextField nom, prenom;
    private JTextArea adresse;
    private JPanel panLabel, panSaisie;
    private JLabel labTitre, labNom, labPrenom, labAdresse;

    /****************************************** CONSTRUCTEUR ****************************************/

    public Panneau() {
        super();
        this.titre = new JComboBox();
        this.nom = new JTextField();
        this.prenom = new JTextField();
        this.adresse = new JTextArea();
        this.panLabel = new JPanel();
        this.panSaisie = new JPanel();
        this.labTitre = new JLabel("Civilité");
        this.labNom = new JLabel("Nom");
        this.labPrenom = new JLabel("Prénom");
        this.labAdresse = new JLabel("Adresse");

        this.titre.addItem("Mme");
        this.titre.addItem("Mr");

        this.panLabel = new JPanel(new GridLayout(4, 1, 5, 15));
        this.panSaisie = new JPanel(new GridLayout(4, 1, 5, 5));
		
		this.add(this.panLabel, BorderLayout.NORTH);
		this.add(this.panSaisie,BorderLayout.SOUTH);

        this.panLabel.add(this.labTitre);
        this.panLabel.add(this.labNom);
        this.panLabel.add(this.labPrenom);
        this.panLabel.add(this.labAdresse);
        this.panSaisie.add(this.titre);
        this.panSaisie.add(this.nom);
        this.panSaisie.add(this.prenom);
        this.panSaisie.add(this.adresse);

        this.setVisible(true);
    }

    /****************************************** GETTERS / SETTERS ****************************************/

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
