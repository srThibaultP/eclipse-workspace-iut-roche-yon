package lry.dip.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class serveurSocketTCP {
    private ServerSocket serveur = null;
    private Inet4Address IPServeur = null;
    private int portServeur = 0;
    private OutputStream fluxSortie = null;
    private PrintWriter reponse = null;
    private Socket client = null;
    private Inet4Address IPClient = null;
    private int PortClient = 0 ;
    private InputStream fluxEntree = null;
    private InputStreamReader bufferEntree = null;
    private BufferedReader requete = null;

    
    public serveurSocketTCP(){}

    public void lancerServeur(int pPort, String pIP){
        System.out.println("Démarrage du serveur");
        this.portServeur = pPort;
        try {
            this.IPServeur = (Inet4Address) Inet4Address.getByName(pIP);
        } catch (UnknownHostException e) {
            System.out.println("Erreur d'adresse IP");
            e.printStackTrace();
        }
        try {
            this.serveur = new ServerSocket(this.portServeur, 1, this.IPServeur);
            this.client = new Socket();
            System.out.println("Serveur on à l'adresse " + this.serveur.getInetAddress() + ":" + this.serveur.getLocalPort());
        } catch (IOException e) {
            System.out.println("Erreur de connexion au serveur");
            e.printStackTrace();
        }
    }

    public void arreterServeur(){
        System.out.println("Arrêt du serveur");
        try {
            this.serveur.close();
            this.portServeur = 0;
            this.PortClient = 0;
            this.IPServeur = null;
            this.IPClient = null;
        } catch (IOException e) {
            System.out.println("Serveur toujours online");
            e.printStackTrace();
        }
    }

    public void attendreClient(){
        try {
            this.client = this.serveur.accept();
            this.IPClient = (Inet4Address) this.client.getInetAddress();
            this.PortClient = this.client.getPort();
            System.out.println("Nouveau client: " + this.client.getInetAddress().toString() + ":" + this.client.getPort());

            this.fluxEntree = this.client.getInputStream();
            this.bufferEntree = new InputStreamReader(this.fluxEntree);
            this.fluxSortie = this.client.getOutputStream();
            this.reponse = new PrintWriter(this.fluxSortie, true);
            this.requete = new BufferedReader(this.bufferEntree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deconnecterClient(){
        System.out.println("Déconexion du client");
        try {
            this.client.close();
            this.fluxSortie.close();
            this.fluxEntree.close();
        } catch (IOException e) {
            System.out.println("Déconexion du client impossible");
            e.printStackTrace();
        }
    }

    public boolean recevoirRequete() {
        try {
            this.requete.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void envoyerReponse(String message) {
        System.out.println("Envoi du message: " + message);
        this.reponse.println(message);
    }


    public PrintWriter getReponse() {
        return reponse;
    }

    public void setReponse(PrintWriter reponse) {
        this.reponse = reponse;
    }

    public BufferedReader getRequete() {
        return requete;
    }

    public void setRequete(BufferedReader requete) {
        this.requete = requete;
    }

    
}
