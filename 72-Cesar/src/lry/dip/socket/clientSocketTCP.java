package lry.dip.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientSocketTCP {

    private Inet4Address IPServeur = null;
    private int PortServeur = 0;
    private PrintWriter fluxSortie;
    private Socket client = null;
    private Inet4Address IPClient = null;
    private InputStreamReader fluxEntree;
    private BufferedReader reponse = null;
    private String ligne;

    /****************************
     * CONSTRUCTEUR
     *****************************************************/
    public clientSocketTCP() {

    }

    /*******************************
     * METHODE
     *******************************************************/

    public boolean connecter(int pPort, String pIP) {

        this.PortServeur = pPort;

        try {
            this.IPClient = (Inet4Address) InetAddress.getLocalHost();
            this.IPServeur = (Inet4Address) InetAddress.getByName(pIP);
        } catch (UnknownHostException e) {

            e.printStackTrace();
        }

        try {
            System.out.println("Démarrage du processus de connection");
            this.client = new Socket(this.IPServeur, this.PortServeur);
            this.fluxEntree = new InputStreamReader(this.client.getInputStream());
            this.fluxSortie = new PrintWriter(this.client.getOutputStream(), true);
            this.IPClient = (Inet4Address) this.client.getLocalAddress();
            this.reponse = new BufferedReader(this.fluxEntree);

            System.out.println("Connecté en tant que: " + this.IPClient);
            System.out.println("Connecté au serveur: " + this.IPServeur);

            return true;

        } catch (IOException e) {

            System.out.println("Client non connecté");

            e.printStackTrace();

            return false;
        }
    }

    public void envoyerRequete(String message) {
        this.fluxSortie.println(message);

        System.out.println("Envoi du message :" + message);
    }

    public void deconnecter() {
        this.IPServeur = null;
        this.IPClient = null;

        try {
            this.fluxEntree.close();
            this.fluxSortie.close();
            this.client.close();

            System.out.println("Déconnection du serveur");

        } catch (IOException e) {

            System.out.println("Echec de la déconnection du serveur");
            e.printStackTrace();
        }
    }

    public boolean recevoirReponse() {

        try {
            this.ligne = this.reponse.readLine(); // Lecture de la ligne recu du serveur

            System.out.println("Réponse serveur: " + this.ligne);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (this.ligne != null) {
            return true;
        } else {
            return false;
        }
    }
}