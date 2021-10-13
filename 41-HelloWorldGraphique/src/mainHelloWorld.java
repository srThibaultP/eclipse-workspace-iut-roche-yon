import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class mainHelloWorld {
    public static void main(String[] args) {
        Image img;
        try {
            img = ImageIO.read(new File("/home/chronos/eclipse-workspace/41-HelloWorldGraphique/img/smiley.png"));
            new GUI("Hello Wolrd Graphique", img, "Bonjour la DIP !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
