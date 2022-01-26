package lry.dip.cesarGUI;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {
    private GridBagLayout boite;
    private JLabel indications, indCle;
    private JComboBox key;
    private JTextArea message;
    private JButton btnCoder, btnDecoder;
    private JButton btnOuvrir, btnEnr, btnSend;
    private JTextField adresseIP;

    public Panneau() {
        super();
        
        /***********************************ATTRIBUTS********************************************/

        this.boite = new GridBagLayout();
        this.indications = new JLabel("Message :");
        this.indCle = new JLabel("Clé :");
        this.key = new JComboBox();
        this.message = new JTextArea(10, 25);
        this.btnCoder = new JButton("Coder");
        this.btnDecoder = new JButton("Décoder");
        this.btnOuvrir = new JButton("Ouvrir");
        this.btnEnr = new JButton("Enregistrer");
        this.btnSend = new JButton("Envoyer");
        this.adresseIP = new JTextField(30);

        //Ajout des valeurs dans la combobox
        this.key.addItem("3");
        this.key.addItem("4");
        this.key.addItem("5");

        this.setLayout(this.boite);

        /*
         * Positionnement du GUI, arguments disponible dans la doc:
         * https://docs.oracle.com/javase/7/docs/api/java/awt/GridBagConstraints.html
        */
        this.add(this.indCle, new GridBagConstraints(0, 0, 1, 1, 0, 0, 25, 2, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.key, new GridBagConstraints(1, 0, 1, 1, 0, 0, 25, 2, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.indications, new GridBagConstraints(0, 1, 1, 1, 0, 0, 25, 2, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.message, new GridBagConstraints(0, 2, 2, 1, 0, 0, 25, 2, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.btnCoder, new GridBagConstraints(0, 3, 1, 1, 0, 0, 25, 2, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.btnDecoder, new GridBagConstraints(1, 3, 1, 1, 0, 0, 25, 2, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.btnOuvrir, new GridBagConstraints(0, 4, 1, 1, 0, 0, 25, 2, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.btnEnr, new GridBagConstraints(1, 4, 1, 1, 0, 0, 25, 2, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.adresseIP, new GridBagConstraints(0, 6, 2, 1, 0, 0, 25, 2, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.btnSend, new GridBagConstraints(0, 7, 2, 1, 0, 0, 25, 2, new Insets(0, 0, 0, 0), 0, 0));
    }

    /********************************************************GETTERS**********************************************************/

    public JTextArea getMessage() {
        return this.message;
    }

    public JButton getBtnCoder() {
        return this.btnCoder;
    }

    public JButton getBtnDecoder() {
        return this.btnDecoder;
    }

    public JButton getBtnOuvrir() {
        return this.btnOuvrir;
    }

    public JButton getBtnEnr() {
        return this.btnEnr;
    }

    public JButton getBtnSend() {
        return this.btnSend;
    }

    public JComboBox getKey() {
        return key;
    }

    public JTextField getAdresseIP() {
        return adresseIP;
    }
}
