import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class mainArdoise {
    public static void main(String[] args) {
        Image img;
        try {
            img = ImageIO.read(new File("smiley.png"));
            new GUI(400, 400, false, "Ardoise Magique", img);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Working dir:  " + System.getProperty("user.dir"));
        }
        
    }
}
