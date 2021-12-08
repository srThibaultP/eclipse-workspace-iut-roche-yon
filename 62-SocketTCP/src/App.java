import lry.dip.socket.*;
public class App {
    public static void main(String[] args) {
        boolean messageLa = false;
        serveurSocketTCP serveur = new serveurSocketTCP();
        serveur.lancerServeur(8080, "192.168.50.252");
        serveur.attendreClient();
        while (serveur.recevoirRequete()) {
            System.out.println("Message reçu: " + serveur.getReponse());
            serveur.envoyerReponse("hello tcp");
            serveur.deconnecterClient();
            serveur.arreterServeur();
        }
    }
}
