import java.util.Scanner;
import moe.caiomi.cesar.*;

public class Main {

	public static void main(String[] args) {
		Cesar c = new Cesar(3);
		String fichier = "/home/chronos/eclipse-workspace/31-César/src/data.txt";
		System.out.print("Bienvenue dans le programme de codage-decodage CESAR ! \r\n[C]odage ou [D]écodage césar ? ");
		Scanner choix = new Scanner(System.in);
		switch (choix.nextLine()) {
			case "C":
				System.out.println("Veuillez saisir un texte au clavier :");
				System.out.println("(Ce texte devra etre de 50 caracteres maximum)");
				Scanner sc = new Scanner(System.in);
				String texte = sc.nextLine();
				c.Coder_Cesar(texte);
				System.out.println(c.getMessageDecode());
				c.enrFichier(fichier, c.getMessageDecode());
				break;
			
			case "D":
				c.lireFichier(fichier);
				System.out.println(c.getMessageDecode());
				break;
		
			default:
				break;
		}
		
		
		//c.Decoder_Cesar("a");
		//System.out.println("Resultat = " + c.getMessageDecode());
		//System.out.println(c.getMessageCode());

	}
}
