import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {
    private JPanel conteneur;
    private GridBagLayout boite;
    private JLabel indications, indCle;
    private JComboBox key;
    private JTextArea message;
    private JButton btnCoder, btnDecoder;
    private JButton btnOuvrir, btnEnr, btnSend;
    private JTextField adresseIP;
    private GUI structure;

    public Panneau() {
        super();

        this.boite = new GridBagLayout();
        this.indications = new JLabel("Message :");
        this.indCle = new JLabel("Clé :");
        this.key = new JComboBox();
        this.message = new JTextArea();
        this.btnCoder = new JButton("Coder");
        this.btnDecoder = new JButton("Décoder");
        this.btnOuvrir = new JButton("Ouvrir");
        this.btnEnr = new JButton("Enregistrer");
        this.btnSend = new JButton("Envoyer");
        this.adresseIP = new JTextField();

        //this.add()
    }
}
