import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI (int pLarg, int pHaut, boolean pResize, String pTitre) {
        super();
        
        this.setTitle(pTitre);
        this.setSize(pLarg, pHaut);
        this.setResizable(pResize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        GridLayout structure = new GridLayout();

        

        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent actBtn) {}
}
