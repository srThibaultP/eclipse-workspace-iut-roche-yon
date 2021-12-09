import java.net.SocketException;

import lry.dip.socket.*;
public class App {
    public static void main(String[] args) throws SocketException {
        boolean end = false;
        serveurSocketTCP serveur = new serveurSocketTCP();
        serveur.lancerServeur(8080, "192.168.50.252");
        serveur.attendreClient();
        while (!end) {
            System.out.println("Message reçu: " + serveur.getMessage());
            serveur.envoyerReponse("hello tcp👑");
            serveur.deconnecterClient();
            serveur.arreterServeur();
            end = true;
        }
    }
}
