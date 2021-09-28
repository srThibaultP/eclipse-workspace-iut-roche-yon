import java.util.Scanner;
/*
public class main_Variables {
	public static void main(String[] args) {
		char lettre;
		int ascii;
		boolean test = false;
		
		while (!test) {
			Scanner sc = new Scanner(System.in);
			lettre = sc.next().charAt(0);
			ascii = (int) lettre;
			
			
			if(ascii >= 65 && ascii <= 90 || ascii >= 97 && ascii <= 122) {
				System.out.println(lettre);
				System.out.println(ascii);
				test = true;
			}
		}
	}
}
*/

public class main_Variables {
	public static void main(String[] args) {
		char lettre;
		int ascii = 0;
		boolean test = false;
		
		while (!test) {
			if(ascii >= 65 && ascii <= 90 || ascii >= 97 && ascii <= 122) {
				System.out.println((char)ascii);
				System.out.println(ascii);
				ascii++;
			} else ascii++;
		}
	}
}