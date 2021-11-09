import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;

import lry.dip.cesar.Cesar;

public class GUI extends JFrame implements ActionListener {
    private Panneau affichage;
    private Cesar cesar;

    public GUI (int pLarg, int pHaut, boolean pResize, String pTitre) {        
        this.setTitle(pTitre);
        this.setSize(pLarg, pHaut);
        this.setResizable(pResize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.cesar = new Cesar(2);
        this.affichage = new Panneau();
        add(this.affichage);
        setVisible(true);   

        this.affichage.getBtnCoder().addActionListener(this);
        this.affichage.getBtnDecoder().addActionListener(this);
        this.affichage.getBtnEnr().addActionListener(this);
        this.affichage.getBtnOuvrir().addActionListener(this);
        this.affichage.getBtnSend().addActionListener(this);
        this.affichage.getKey().addActionListener(this);
    }

    public void actionPerformed (ActionEvent actBtn) {
        if (actBtn.getSource() == this.affichage.getBtnCoder()) {
            this.cesar.Coder_Cesar(this.affichage.getMessage().getText());
            this.affichage.getMessage().setText(this.cesar.getMessageCode());
        }
        else if (actBtn.getSource() == this.affichage.getBtnDecoder()) {
            this.cesar.Decoder_Cesar(this.affichage.getMessage().getText());
            this.affichage.getMessage().setText(this.cesar.getMessageDecode());
        }
        else if (actBtn.getSource() == this.affichage.getBtnEnr()) {
            this.affichage.enrFichier(this);
            
        }
        else if (actBtn.getSource() == this.affichage.getBtnOuvrir()) {
            
        }
        else if (actBtn.getSource() == this.affichage.getBtnSend()) {
            
        }
        else if (actBtn.getSource() == this.affichage.getKey()) {
            
        }
    }
}
