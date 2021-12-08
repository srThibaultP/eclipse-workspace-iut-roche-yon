package lry.dip.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

public class serveurSocketTCP {
    private ServerSocket serveur;
    private Inet4Address IPServeur;
    private int portServeur;
    private OutputStream fluxSortie;
    private PrintWriter reponse;
    private Socket client;
    private Inet4Address IPClient;
    private int PortClient;
    private InputStream fluxEntree;
    private InputStreamReader bufferEntree;
    private BufferedReader requete;

    
    public serveurSocketTCP(){}

    public void lancerServeur(int pPort, String pIP){}

    public void arreterServeur(){}

    public void attendreServeur(){}

    public void deconnecterClient(){}

    public boolean recevoirRequete() {
        return false;
    }

    public void envoyerReponse(String message) {}
}
