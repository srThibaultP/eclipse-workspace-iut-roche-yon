import javax.swing.JPanel;
import java.awt.*;

public class contImage extends JPanel{
    private Image dessin;
    private Boolean flag;

    public contImage(Image pDessin){
        super();
        this.dessin = pDessin;
    }
    @Override
    public void paintComponent(Graphics crayon){
        crayon.drawImage(this.dessin, 150, 150, null);
    }
    public void setFlag(boolean pFlag){}
}
