import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;

import lry.dip.cesar.Cesar;

public class GUI extends JFrame implements ActionListener {
    private Panneau fond;
    private Cesar cesar;

    public GUI (int pLarg, int pHaut, boolean pResize, String pTitre) {        
        this.setTitle(pTitre);
        this.setSize(pLarg, pHaut);
        this.setResizable(pResize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.cesar = new Cesar(2);
        this.fond = new Panneau();
        add(this.fond);
        setVisible(true);   

        this.fond.getConteneur().getBtnCoder().addActionListener(this);
        this.fond.getConteneur().getBtnDecoder().addActionListener(this);
        this.fond.getConteneur().getBtnEnr().addActionListener(this);
        this.fond.getConteneur().getBtnOuvrir().addActionListener(this);
        this.fond.getConteneur().getBtnSend().addActionListener(this);
        this.fond.getConteneur().getKey().addActionListener(this);
        this.fond.getConteneur().getBtnInfoBox().addActionListener(this);
    }

    public void actionPerformed (ActionEvent actBtn) {}
}
