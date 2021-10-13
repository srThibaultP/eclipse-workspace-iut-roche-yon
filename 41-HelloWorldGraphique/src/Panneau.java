import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel{
/**********************************ATTRIBUTS***********************************/
    private Image img;

/**********************************CONSTRUCTEURS*******************************/
    public Panneau(Image pImage) {
        super(); //A cause de héritage -> extends
        this.img = pImage;
    }

/**********************************METHODES************************************/
    @Override
    public void paintComponent(Graphics crayon) {
        crayon.drawImage(this.img, 150, 150, null);
    }

}
