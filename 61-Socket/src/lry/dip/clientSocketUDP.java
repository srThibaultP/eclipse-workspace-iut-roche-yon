package lry.dip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.SocketException;
import java.net.UnknownHostException;

public class clientSocketUDP {
    private Inet4Address IPServeur;
    private int portServeur;
    private Inet4Address IPClient;
    private int portClient;
    private DatagramSocket clientSocket;
    private DatagramPacket dataSend;
    private DatagramPacket dataRec;
    private byte[] bufferSend;
    private byte[] bufferRec;

    /***************************** CONSTRUCTEUR **********************************/
    public clientSocketUDP(){
        this.IPServeur = null;
        this.portServeur = 0;
        this.IPClient = null;
        this.portClient = 0;
        this.clientSocket = null;
        this.dataSend = null;
        this.dataRec = null;
        //this.bufferSend = null;
        //this.bufferRec = null;
        
        try {
            this.clientSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        //this.dataRec = new DatagramPacket(this.bufferRec, this.bufferRec.length);
    }
    
    /************************ METHODE ****************************************/
    public void envoyerRequete(String message, int pPort, String pIP){
        this.portServeur = pPort;
        try {
            this.IPServeur = (Inet4Address) Inet4Address.getByName(pIP);
        } catch (UnknownHostException e) {
            System.out.println("Erreur d'adresse IP");
            e.printStackTrace();
        }
        System.out.println("Envoi de la requete : " + message + " au serveur " + this.IPServeur + ":" + this.portServeur);
        this.bufferSend = message.getBytes();
        this.dataSend = new DatagramPacket(this.bufferSend, this.bufferSend.length, this.IPServeur, this.portServeur);
        try {
            this.clientSocket.send(this.dataSend);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean recevoirReponse(){
        byte[] bufferRec = new byte[256];
        DatagramPacket packet = new DatagramPacket(bufferRec, bufferRec.length);

        try {
            clientSocket.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String msg;
        msg = new String(packet.getData()).trim();

        System.out.println("Message reçu :" + packet.getAddress().getHostAddress() + ": " + msg);
        return false;
    }

}