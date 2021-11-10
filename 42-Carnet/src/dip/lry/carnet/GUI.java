package dip.lry.carnet;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener{
    private JMenuBar menuBar;
    private JMenu menuFichier;
    private JMenuItem itemAjouter, itemSupprimer, itemQuitter;
    private JTable tableau;
    private ModeleTable donnees;
    private JScrollPane scroll;

    public GUI(int pLarg, int pHaut, boolean pResize, String pTitre) {
        super();
        this.setTitle(pTitre);
        this.setResizable(pResize);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.menuBar = new JMenuBar();
        this.menuFichier = new JMenu("Fichier");
        this.itemAjouter = new JMenuItem("Ajouter");
        this.itemSupprimer = new JMenuItem("Supprimer");
        this.itemQuitter = new JMenuItem("Quitter");

        this.donnees = new ModeleTable();
        this.tableau = new JTable(this.donnees);
        this.scroll = new JScrollPane(this.tableau);
        this.add(scroll);
        
        

        

        //Menu Fichier
        this.menuFichier.add(this.itemAjouter);
        this.menuFichier.add(this.itemSupprimer);
        this.menuFichier.add(this.itemQuitter);
        
        this.menuBar.add(this.menuFichier);
        
        this.setJMenuBar(menuBar);
        this.setSize(pLarg, pHaut);
        this.setVisible(true);
        this.setLayout(null);

        this.getItemAjouter().addActionListener(this);
        this.getItemSupprimer().addActionListener(this);
        this.getItemQuitter().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent actBtn) {
        if (actBtn.getSource() == this.getItemQuitter()) {
            if (JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter ?", "Quitter", 0) == 0) {
                System.exit(0);
            }
        }
        else if (actBtn.getSource() == this.getItemAjouter()) {
            System.out.println("Je suis bien dans la fenêtre ajouter");
        }
        else if (actBtn.getSource() == this.getItemSupprimer()) {
            
        }
    }

    public JMenuItem getItemAjouter() {
        return itemAjouter;
    }

    public void setItemAjouter(JMenuItem itemAjouter) {
        this.itemAjouter = itemAjouter;
    }

    public JMenuItem getItemSupprimer() {
        return itemSupprimer;
    }

    public void setItemSupprimer(JMenuItem itemSupprimer) {
        this.itemSupprimer = itemSupprimer;
    }

    public JMenuItem getItemQuitter() {
        return itemQuitter;
    }

    public void setItemQuitter(JMenuItem itemQuitter) {
        this.itemQuitter = itemQuitter;
    }


    
}
