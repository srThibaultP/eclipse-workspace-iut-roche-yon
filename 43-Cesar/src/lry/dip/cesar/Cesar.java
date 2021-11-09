package lry.dip.cesar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.Writer;

import javax.swing.JFileChooser;

import lry.dip.cesarGUI.*;

public class Cesar {
	private int key = 3;
	private String messageCode = "";
	private String messageDecode = "";
	private JFileChooser selectionFichier;
	private File fichier;
	private FileReader fichierLecture;
	private BufferedReader cacheFichier;
	
	public Cesar(int pKey) {
		this.key = pKey;
		this.selectionFichier = new JFileChooser();
	}

	public void Coder_Cesar(String motAcoder){
		this.messageCode = "";
		this.messageDecode = motAcoder;
		for(int i = 0; i < this.messageDecode.length(); i++){
			char c = this.messageDecode.charAt(i);
			int temp;
			if(Character.isLetter(c)){
				if(Character.isUpperCase(c)){
					int ascii = (int) c;
					ascii += key;
					if (ascii > 90) {
						temp = ascii - 91;
						ascii = 65 + temp;
					}
					c = (char) ascii;
				}else{
					int ascii = (int) c;
					ascii += key;
					if (ascii > 122) {
						temp = ascii - 123;
						ascii = 97 + temp;
					}
					c = (char) ascii;
				}
			}
			this.messageCode += c;
		}
	}
	
	public void Decoder_Cesar(String motAdecoder){
		this.messageDecode = "";
		this.messageCode = motAdecoder;
		for(int i = 0; i < this.messageCode.length(); i++){
			char c = this.messageCode.charAt(i);
			int temp = 0;
			if(Character.isLetter(c)){
				if(Character.isUpperCase(c)){
					int ascii = (int) c;
					ascii -= key;
					if (ascii < 64) {
						temp = 64 - ascii;
						ascii = 90 - temp;
					}
					c = (char) ascii;
				}else{//LOWERCASE
					int ascii = (int) c;
					ascii -= key;
					if (ascii < 96) {
						temp = 96 - ascii;
						ascii = 122 - temp;
					}
					c = (char) ascii;
				}
			}
			this.messageDecode += c;
		}
	}
/*
	public void enrFichier(String cheminFichier, String texte) {
		try {
			Writer fichier = new java.io.FileWriter(cheminFichier);
			fichier.write(texte);
			fichier.close();
		} catch (Exception e) {
			System.out.println("Erreur d'enregistrement du fichier : " + e);
		}
	}
*/
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



/*
	public void lireFichier(String cheminFichier) {
		try {
			Reader fichier = new java.io.FileReader(cheminFichier);
			int c;
			String txt = "";
			while ((c = fichier.read()) != -1) {
				txt += (char) c;
			}
			Decoder_Cesar(txt);
			fichier.close();
		} catch (Exception e) {
			System.out.println("Erreur de lecture du fichier : " + e);
		}
	}
*/
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
