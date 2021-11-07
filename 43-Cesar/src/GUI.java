import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame {
    private Panneau fond;

    public GUI (int pLarg, int pHaut, boolean pResize, String pTitre) {        
        this.setTitle(pTitre);
        this.setSize(pLarg, pHaut);
        this.setResizable(pResize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.fond = new Panneau();
        add(this.fond);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent actBtn) {}
}
