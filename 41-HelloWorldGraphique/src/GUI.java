import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
/**********************************ATTRIBUTS*****************************/
    private Panneau fond;
    private JLabel affTexte;
    private BorderLayout structure;

/**********************************CONSTRUCTEURS*******************************/
    public GUI (String pTitre, Image pImg, String pTexte) {
        super();
        this.setTitle(pTitre);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panneau image = new Panneau(pImg);
        this.affTexte = new JLabel(pTexte);
        this.fond = new Panneau(pImg);
        this.structure = new BorderLayout(200, 2);
        this.setLayout(this.structure);
        this.add(this.affTexte, this.structure.SOUTH);
        this.add(this.fond, this.structure.CENTER);
        this.add(image);
        
    }

}
