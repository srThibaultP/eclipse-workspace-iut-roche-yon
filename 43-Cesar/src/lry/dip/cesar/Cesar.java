package lry.dip.cesar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Writer;
import javax.swing.JFileChooser;

import lry.dip.cesarGUI.*;

public class Cesar {
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

	public Cesar(int pKey) {
		this.key = pKey;
		this.selectionFichier = new JFileChooser();
	}

	public void Coder_Cesar(String motAcoder) {
		this.messageCode = "";
		int ascii = 0;

		for (int i = 0; i < motAcoder.length(); i++) {
			ascii = motAcoder.charAt(i);
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
		for (int i = 0; i < motAdecoder.length(); i++) {
			ascii = motAdecoder.charAt(i);
			if ((ascii >= 97 + this.key && ascii <= 122) || (ascii >= 65 + this.key && ascii <= 90)) {
				ascii -= this.key;
			} else if ((ascii >= 97 && ascii <= 97 + this.key) || (ascii >= 65 && ascii <= 65 + this.key)) {
				ascii = ascii - this.key + 26;
			}
			this.messageDecode += (char) ascii;
		}
	}

	public void enrFichier(GUI cheminFichier) {
		if (this.selectionFichier.showOpenDialog(cheminFichier) == 0) {
			this.fichier = this.selectionFichier.getSelectedFile();

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
		if (this.selectionFichier.showOpenDialog(cheminFichier) == 0) {

			try {
				this.fichierLecture = new FileReader(new File(this.selectionFichier.getSelectedFile().getAbsolutePath()));
				this.cacheFichier = new BufferedReader(this.fichierLecture);
				String lettre = new String();

				while ((lettre = this.cacheFichier.readLine()) != null) {
					this.messageCode = String.valueOf(this.messageCode) + lettre;
				}

				this.cacheFichier.close();
				this.fichierLecture.close();

			} catch (Exception e) {
				System.out.println("Erreur de lecture du fichier : " + e);
			}
		}
	}

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
