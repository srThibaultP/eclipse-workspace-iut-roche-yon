import lry.dip.clientSocketUDP;
public class App {
    public static void main(String[] args) throws Exception {
        clientSocketUDP client = new clientSocketUDP();
        client.envoyerRequete("shutdown now", 29810, "192.168.43.197");
        while (true) {
            client.recevoirReponse();
        }
    }
}
