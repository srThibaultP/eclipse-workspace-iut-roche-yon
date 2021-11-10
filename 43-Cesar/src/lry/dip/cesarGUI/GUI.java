package lry.dip.cesarGUI;

import javax.swing.JFrame;
import java.awt.event.*;

import lry.dip.cesar.Cesar;

public class GUI extends JFrame implements ActionListener {
    private Panneau fond;
    private Cesar cesar;

    public GUI(int pLarg, int pHaut, boolean pResize, String pTitre) {
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

        this.fond.getBtnCoder().addActionListener(this);
        this.fond.getBtnDecoder().addActionListener(this);
        this.fond.getBtnEnr().addActionListener(this);
        this.fond.getBtnOuvrir().addActionListener(this);
        this.fond.getBtnSend().addActionListener(this);
        this.fond.getKey().addActionListener(this);
    }

    public void actionPerformed(ActionEvent actBtn) {
        if (actBtn.getSource() == this.fond.getBtnCoder()) {
            this.cesar.Coder_Cesar(this.fond.getMessage().getText());
            this.fond.getMessage().setText(this.cesar.getMessageCode());

        } else if (actBtn.getSource() == this.fond.getBtnDecoder()) {
            this.cesar.Decoder_Cesar(this.fond.getMessage().getText());
            this.fond.getMessage().setText(this.cesar.getMessageDecode());

        } else if (actBtn.getSource() == this.fond.getBtnEnr()) {
            this.cesar.enrFichier(this);

        } else if (actBtn.getSource() == this.fond.getBtnOuvrir()) {
            this.cesar.lireFichier(this);
            this.fond.getMessage().setText(this.cesar.getMessageCode());

        } else if (actBtn.getSource() == this.fond.getBtnSend()) {
            System.out.println("Ping");
            
        } else if (actBtn.getSource() == this.fond.getKey()) {
            this.cesar.setKey(this.fond.getKey().getSelectedIndex() + 3);

        }
    }
}
