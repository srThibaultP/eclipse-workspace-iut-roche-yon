import java.util.Scanner;

import moe.caiomi.cesar.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String texte = sc.nextLine();
		Cesar c = new Cesar(3);
		c.Coder_Cesar(texte);
		System.out.println(c.getMessageDecode());
		System.out.println(c.getMessageCode());
	}
}
