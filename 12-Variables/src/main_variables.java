import java.util.Scanner;

public class main_variables {
	public static void main(String[] args) {
		/*
		//Déclaration var
		char texte;
		int num;
		boolean maybe;
		//Déclaration data clavier + affectation à var
		
		
		//Input -> a
		Scanner claviertxt = new Scanner(System.in);
		texte = claviertxt.next().charAt(0);
		
		//Input -> 97
		Scanner claviernum = new Scanner(System.in);
		num = claviernum.nextInt();
		
		//Input -> true
		Scanner clavierbool = new Scanner(System.in);
		maybe = clavierbool.nextBoolean();
		
		//Affichage console
		System.out.println(texte);
		System.out.println(num);
		System.out.println(maybe);
		*/
		
		//Input -> a
		char lettre = 'a';    
		int ascii = (int) lettre;
		System.out.println(ascii);
		
		
		//Input -> 97
		int num = 97;    
		//char converti = (char) num;
		System.out.println((char) num);
	}
}
