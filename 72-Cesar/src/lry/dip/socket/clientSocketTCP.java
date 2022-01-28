/**
 * @Author: Thibault PECH
 * @Date:   2022-01-26 10:24:41
 * @Last Modified by:   Thibault PECH
 * @Last Modified time: 2022-01-28 12:33:20
 * Ceci est une librairie récupéré du TP 62-Socket
 */

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

    /***************************** CONSTRUCTEUR *****************************************************/
    public clientSocketTCP() {

    }

    /******************************** METHODE *******************************************************/

    public boolean connecter(int pPort, String pIP) {

        this.PortServeur = pPort;

        try {
            // Affectation de l'adresse IP du client (local) et du serveur (distant)
            this.IPClient  = (Inet4Address) InetAddress.getLocalHost();
            this.IPServeur = (Inet4Address) InetAddress.getByName(pIP);
        } catch (UnknownHostException e) {
            System.out.println("Erreur lors de la récupération de l'adresse IP :");
            e.printStackTrace();
        }

        try {
            System.out.println("Démarrage du processus de connection");
            // Création d'un socket client
            this.client = new Socket(this.IPServeur, this.PortServeur);
            // Préparation de la lecture et de l'écriture dans le flux (l'écriture n'est pas nécessaire ici)
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
        // Envoi d'un message au serveur
        this.fluxSortie.println(message);
        System.out.println("Envoi du message :" + message);
    }

    public void deconnecter() {
        // Fermeture de la connexion
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
        // Réception d'une réponse du serveur
        try {
            this.ligne = this.reponse.readLine(); // Lecture de la ligne recu du serveur
            System.out.println("Réponse serveur: " + this.ligne);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        // Si la réponse est vide, le serveur renvoye un message d'erreur
        if (this.ligne != null) {
            return true;
        } else {
            return false;
        }
    }
}