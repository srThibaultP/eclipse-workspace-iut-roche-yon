import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener{
    private JPanel conteneur;
    private JPanel conteneurBtn;
    private BorderLayout structure;
    private JButton btnTracer;
    private JButton btnEffacer;
    private contImage fond;

    public GUI(int pLarg, int pHaut, boolean pResize, String pTitre, Image pDessin) {
        super();

        this.setTitle(pTitre);
        this.setSize(pLarg, pHaut);
        this.setResizable(pResize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.structure = new BorderLayout();

        this.conteneur = new JPanel();
        this.conteneurBtn = new JPanel();
        this.btnTracer = new JButton("Tracer");
        this.btnEffacer = new JButton("Effacer");
        this.fond = new contImage(pDessin);

        this.conteneur.setLayout(structure);
        this.add(this.fond, this.structure.CENTER);

        this.conteneurBtn.setLayout(structure);
        this.conteneurBtn.add(this.btnTracer, this.structure.EAST);
        this.conteneurBtn.add(this.btnEffacer, this.structure.WEST);

        this.btnTracer.addActionListener(this);
        this.btnEffacer.addActionListener(this);

        this.add(this.conteneur, this.structure.NORTH);
        this.add(this.conteneurBtn, this.structure.SOUTH);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent actBtn) {
        if (actBtn.getSource() == btnEffacer) {
            this.fond.setVisible(false);
        }
        if (actBtn.getSource() == btnTracer) {
            this.fond.setVisible(true);
        }
    }
}
