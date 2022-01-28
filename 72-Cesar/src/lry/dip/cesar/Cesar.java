/**
 * @Author: Thibault PECH
 * @Date:   2022-01-05 13:45:55
 * @Last Modified by:   Thibault PECH
 * @Last Modified time: 2022-01-28 12:43:45
 */

package lry.dip.cesar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Writer;
import javax.swing.JFileChooser;

import lry.dip.cesarGUI.*;
import lry.dip.socket.*;

public class Cesar {
	/********************************************ATTRIBUTS**********************************************/

	//Clé de base à 3
	private int key = 3;

	//On met les variables à zero
	private String messageCode = "";
	private String messageDecode = "";

	//Gestionnaire de fichiers
	private JFileChooser selectionFichier;
	private File fichier;
	private FileReader fichierLecture;
	private BufferedReader cacheFichier;

	/********************************************CONSTRUCTEUR*******************************************/

	public Cesar(int pKey) {
		this.key = pKey;
		// On initialise le gestionnaire de fichier
		this.selectionFichier = new JFileChooser();
	}

	/**********************************************METHODES********************************************/

	public void Coder_Cesar(String motAcoder) {
		this.messageCode = "";
		int ascii = 0;

		// On parcours le message à coder
		for (int i = 0; i < motAcoder.length(); i++) {
			ascii = motAcoder.charAt(i);
			// On code le message
			if ((ascii >= 97 && ascii <= 122 - this.key) || (ascii >= 65 && ascii <= 90 - this.key)) {
				ascii += this.key;
			} else if ((ascii >= 122 - this.key && ascii <= 122) || (ascii >= 90 - this.key && ascii <= 90)) {
				ascii = ascii - 26 + this.key;
			}

			this.messageCode += (char) ascii;
		}
	}

	public void Decoder_Cesar(String motAdecoder) {
		this.messageDecode = "";
		int ascii = 0;

		// On parcours le message à décoder
		for (int i = 0; i < motAdecoder.length(); i++) {
			ascii = motAdecoder.charAt(i);
			// On décode le message
			if ((ascii >= 97 + this.key && ascii <= 122) || (ascii >= 65 + this.key && ascii <= 90)) {
				ascii -= this.key;
			} else if ((ascii >= 97 && ascii <= 97 + this.key) || (ascii >= 65 && ascii <= 65 + this.key)) {
				ascii = ascii - this.key + 26;
			}

			this.messageDecode += (char) ascii;
		}
	}

	public void enrFichier(GUI cheminFichier) {
		// Si on désire enregistrer un fichier
		if (this.selectionFichier.showOpenDialog(cheminFichier) == 0) {
			this.fichier = this.selectionFichier.getSelectedFile();
			// On ouvre le fichier en écriture
			try {
				Writer ecriture = new java.io.FileWriter(this.fichier);
				ecriture.write(this.messageCode);
				ecriture.close();

			} catch (Exception e) {
				System.out.println("Erreur d'enregistrement du fichier : " + e);
			}
		}
	}

	public void lireFichier(GUI cheminFichier) {
		this.messageCode = "";
		// Si on désire lire un fichier
		if (this.selectionFichier.showOpenDialog(cheminFichier) == 0) {
			try {
				// On ouvre le fichier en lecture
				this.fichierLecture = new FileReader(new File(this.selectionFichier.getSelectedFile().getAbsolutePath()));
				this.cacheFichier = new BufferedReader(this.fichierLecture);
				String lettre = new String();

				// On lit le fichier
				while ((lettre = this.cacheFichier.readLine()) != null) {
					this.messageCode = String.valueOf(this.messageCode) + lettre;
				}
				// On ferme le fichier
				this.cacheFichier.close();
				this.fichierLecture.close();

			} catch (Exception e) {
				System.out.println("Erreur de lecture du fichier : " + e);
			}
		}
	}

	public void envoyer(String ip) {
		clientSocketTCP client = new clientSocketTCP();
		//Utilisation du port 8080 pour la communication
		if(client.connecter(8080,ip) == true) {
			client.envoyerRequete(this.messageCode);
			while(!client.recevoirReponse()) {
			client.recevoirReponse();
			}
			client.deconnecter();	
		}
	}

	/**********************************************GETTERS / SETTERS**********************************/
	
	public String getMessageDecode() {
		return messageDecode;
	}

	public void setMessageDecode(String pMessage) {
		this.messageDecode = pMessage;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String pMessage) {
		this.messageCode = pMessage;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int pKey) {
		this.key = pKey;
	}

}
