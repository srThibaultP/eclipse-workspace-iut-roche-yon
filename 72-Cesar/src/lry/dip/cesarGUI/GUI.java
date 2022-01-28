/**
 * @Author: Thibault PECH
 * @Date:   2022-01-05 13:45:55
 * @Last Modified by:   Thibault PECH
 * @Last Modified time: 2022-01-28 12:37:45
 */

package lry.dip.cesarGUI;

import javax.swing.JFrame;
import java.awt.event.*;

import lry.dip.cesar.Cesar;

public class GUI extends JFrame implements ActionListener {

    /*******************************ATTRIBUTS***********************************/

    private Panneau fond;
    private Cesar cesar;

    /******************************CONSTRUCTEURS********************************/

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

        //Permet de lancer du code quand on appuie sur un bouton
        this.fond.getBtnCoder().addActionListener(this);
        this.fond.getBtnDecoder().addActionListener(this);
        this.fond.getBtnEnr().addActionListener(this);
        this.fond.getBtnOuvrir().addActionListener(this);
        this.fond.getBtnSend().addActionListener(this);
        this.fond.getKey().addActionListener(this);
    }

    /********************************************METHODES***************************************/
    
    // Permet de lancer du code quand on appuie sur un bouton
    public void actionPerformed(ActionEvent actBtn) {
        if (actBtn.getSource() == this.fond.getBtnCoder()) {
            // On code le texte
            this.cesar.Coder_Cesar(this.fond.getMessage().getText());
            this.fond.getMessage().setText(this.cesar.getMessageCode());

        } else if (actBtn.getSource() == this.fond.getBtnDecoder()) {
            // On décode le texte
            this.cesar.Decoder_Cesar(this.fond.getMessage().getText());
            this.fond.getMessage().setText(this.cesar.getMessageDecode());

        } else if (actBtn.getSource() == this.fond.getBtnEnr()) {
            // On enregistre le texte
            this.cesar.enrFichier(this);

        } else if (actBtn.getSource() == this.fond.getBtnOuvrir()) {
            // On lit le fichier
            this.cesar.lireFichier(this);
            this.fond.getMessage().setText(this.cesar.getMessageCode());

        } else if (actBtn.getSource() == this.fond.getBtnSend()) {
            // On envoie le texte
            cesar.envoyer(this.fond.getAdresseIP().getText());
            System.out.println("Ping");
            
        } else if (actBtn.getSource() == this.fond.getKey()) {
            // On lit la clé sélectionné
            this.cesar.setKey(this.fond.getKey().getSelectedIndex() + 3);   //On fait + 3 car l'index commence à 0

        }
    }
}
