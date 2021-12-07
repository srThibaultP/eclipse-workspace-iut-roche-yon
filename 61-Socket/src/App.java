import lry.dip.clientSocketUDP;
import lry.dip.serveurSocketUDP;
public class App {
    public static void main(String[] args) throws Exception {
        clientSocketUDP client = new clientSocketUDP();
        serveurSocketUDP serveur = new serveurSocketUDP();
        client.envoyerRequete("shutdown now", 29810, "192.168.43.197");
        /*serveur.lancerServeur(29810, "192.168.43.67");
        while (true) {
            serveur.recevoirRequete();
        }*/
    }
}
