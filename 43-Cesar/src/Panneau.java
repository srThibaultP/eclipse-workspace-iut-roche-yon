import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panneau extends JPanel{
    private JPanel conteneur;
    private GridBagLayout boite;
    private JLabel indications, indCle;
    private JComboBox key;
    private JTextArea message;
    private JButton btnCoder, btnDecoder;
    private JButton btnOuvrir, btnEnr, btnSend;
    private JTextField adresseIP;

    GridBagConstraints c = new GridBagConstraints();

    public Panneau() {
        this.boite = new GridBagLayout();
        this.indications = new JLabel("Message :");
        this.indCle = new JLabel("Clé :");
        this.key = new JComboBox();
        this.message = new JTextArea(10, 50);
        this.btnCoder = new JButton("Coder");
        this.btnDecoder = new JButton("Décoder");
        this.btnOuvrir = new JButton("Ouvrir");
        this.btnEnr = new JButton("Enregistrer");
        this.btnSend = new JButton("Envoyer");
        this.adresseIP = new JTextField(30);

        this.key.addItem("3");
        this.key.addItem("4");
        this.key.addItem("5");

        this.setLayout(this.boite);

        this.add(this.indCle, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.key, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.indications, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.message, new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.btnCoder, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.btnDecoder, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.btnOuvrir, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.btnEnr, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.adresseIP, new GridBagConstraints(0, 6, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(this.btnSend, new GridBagConstraints(0, 7, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    }


    public JTextArea getMessage() {
        return message;
    }

    public JButton getBtnCoder() {
        return btnCoder;
    }

    public JButton getBtnDecoder() {
        return btnDecoder;
    }

    public JButton getBtnOuvrir() {
        return btnOuvrir;
    }

    public JButton getBtnEnr() {
        return btnEnr;
    }

    public JButton getBtnSend() {
        return btnSend;
    }
}
