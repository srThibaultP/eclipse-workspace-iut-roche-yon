import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements MouseListener {
/**************ATTRIBUTS***********************************/
    private JPanel fond;
    private JPanel pan1, pan2, pan3, pan4;
    private GridLayout structure;
/**************CONSTRUCTEURS******************************/
    public GUI (int pLarg, int pHaut, boolean pResize, String pTitre) {
        super();
        
        this.setTitle(pTitre);
        this.setSize(pLarg, pHaut);
        this.setResizable(pResize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.structure = new GridLayout(2, 2);
        this.setLayout(this.structure);

        this.pan1 = new JPanel();
        this.pan2 = new JPanel();
        this.pan3 = new JPanel();
        this.pan4 = new JPanel();

        this.pan1.setBackground(Color.BLACK);
        this.pan2.setBackground(Color.GRAY);
        this.pan3.setBackground(Color.BLUE);
        this.pan4.setBackground(Color.RED);

        this.add(this.pan1, this.structure);
        this.add(this.pan2, this.structure);
        this.add(this.pan3, this.structure);
        this.add(this.pan4, this.structure);

        this.pan1.addMouseListener(this);
        this.pan2.addMouseListener(this);
        this.pan3.addMouseListener(this);
        this.pan4.addMouseListener(this);

        this.setVisible(true);
    }
/**************METHODES***********************************/
    public void mouseClicked(MouseEvent actSouris) {
        ((JComponent) actSouris.getSource()).setBackground(Color.GREEN);
    }
    public void mousePressed(MouseEvent actSouris) {
        ((JComponent) actSouris.getSource()).setBackground(Color.ORANGE);
    }
    public void mouseReleased(MouseEvent actSouris) {
        ((JComponent) actSouris.getSource()).setBackground(Color.YELLOW);
    }
    public void mouseEntered(MouseEvent actSouris) {
        ((JComponent) actSouris.getSource()).setBackground(Color.MAGENTA);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
