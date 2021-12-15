import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;


public class GUI extends JFrame implements ActionListener {
    private JPanel conteneur, south, north;
    private JProgressBar barreProgress;
    private JTextField nbreFichiers;
    private JTextArea listeFichiers;
    private JButton btnLancer, btnArret;
    private tachesSwingWorker tacheRecherche;

    public GUI(int pLarg, int pHaut, String pTitre) {
        this.setSize(pLarg, pHaut);
        this.setResizable(true);
        this.setTitle(pTitre);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.barreProgress = new JProgressBar();
        this.nbreFichiers = new JTextField(1000);
        this.listeFichiers = new JTextArea(50, 50);
        this.btnLancer = new JButton("Lancer");
        this.btnArret = new JButton("Arrêter");

        this.conteneur = new JPanel();
        this.conteneur.add(new JScrollPane(this.listeFichiers, 22, 30));

        this.north = new JPanel();
        this.north.add(this.btnLancer);
        this.north.add(this.btnArret);
        this.conteneur.add(this.north);

        this.south = new JPanel();
        this.south.add(this.barreProgress);
        this.south.add(this.nbreFichiers);
        this.conteneur.add(this.south);

        this.setContentPane(this.conteneur);
        this.setVisible(true);
        this.tacheRecherche = new tachesSwingWorker(this);
        this.btnLancer.addActionListener(this);
        this.btnArret.addActionListener(this);
    }
    
    public void afficher(String nomFichier) {}

    public void modifierBarre(int pEtat) {}

    public void afficherResultat(int pNombre) {}

    public void actionPerformed(ActionEvent actBtn) {}
}
