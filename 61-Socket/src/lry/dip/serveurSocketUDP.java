package lry.dip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class serveurSocketUDP {

    private Inet4Address IPServeur = null;
    private int PortServeur = 0;
    private Inet4Address IPClient = null;
    private int PortClient = 0;
    private DatagramSocket ServerSocket;
    private DatagramPacket dataSend;
    private DatagramPacket dataRec;
    private byte[] bufferSend;
    private byte[] bufferRec;
    private String message;

    /***************************** CONSTRUCTEUR **********************************/
    public serveurSocketUDP() {
        System.out.println("lancement du socket");
    }

    /************************ METHODE ****************************************/
    public void lancerServeur(int pPort, String pIP) {
        this.PortServeur = pPort;

        try {
            this.IPServeur = (Inet4Address) InetAddress.getByName(pIP);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {

            this.ServerSocket = new DatagramSocket(this.PortServeur, this.IPServeur);
            this.bufferSend = new byte[50];
            this.dataSend = new DatagramPacket(this.bufferSend, 50);
            this.bufferRec = new byte[50];
            this.dataRec = new DatagramPacket(this.bufferRec, this.bufferRec.length,
                    this.ServerSocket.getLocalAddress(), this.ServerSocket.getLocalPort());
            System.out.println("Serveur en fonctionnement sur le port : " + this.ServerSocket.getLocalPort()
                    + " à l'addresse " + this.ServerSocket.getLocalAddress());
        } catch (SocketException e) {

            e.printStackTrace();
        }

    }

    public void arreterServeur() {

    }

    public void envoyerReponse(String pMessage) {
    }

    public boolean recevoirRequete() {
        try {
            System.out.println("Message recu");
            this.ServerSocket.receive(this.dataRec);

        } catch (IOException e) {
            System.out.println("Pas de message");
            e.printStackTrace();
        }

        this.IPClient = (Inet4Address) this.dataRec.getAddress();
        this.PortClient = this.dataRec.getPort();
        System.out.println("Client est connecté et son message est: " + this.dataRec.getLength());
        this.message = "";
        for (int i = 0; i < this.dataRec.getLength(); i++) {
            this.message = String.valueOf(this.message) + (char) this.bufferRec[i];
        }
        System.out.println("Le message est : " + this.message);

        return false;
    }

}