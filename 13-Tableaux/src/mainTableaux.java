import java.util.Scanner;

public class mainTableaux {
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner (System.in);
		
		double[] devises = new double[5];
		devises[0] = sc.nextInt();
		devises[1] = (1.16*devises[0]);
		devises[2] = (129.86*devises[0]);
		devises[3] = (0.86*devises[0]);
		devises[4] = (7.5*devises[0]);
		System.out.println(devises[0] + "€");
		System.out.println(devises[1] + "$");
		System.out.println(devises[2] + "¥");
		System.out.println(devises[3] + "£");
		System.out.println(devises[4] + "¥");
		*/
//-------------------------------------------------	
		/*
		int deux[] = new int[200];
		for (int i=0 ; i < 200 ; i++) {
			deux[i] = 2*(i+1);
			System.out.println(deux[i]);
		}
		*/
//--------------------------------------------------
		/*
		String[][] guitares = {
				{"User", "Gibson Les Paul", "Gretsch G5034", "Seagull S6", "Godin 5th av"},
				{"Mick", "18", "1", "27", "12"},
				{"Keith", "4", "25", "0", "2"},
				{"Brian", "25", "41", "36", "2"},
				{"Ronnie", "1", "2", "2", "1"},
		};
		for(int i=0; i < 5; i++) {
			for(int j=0; j < 5; j++) {
				System.out.print(guitares[i][j] + " | ");
			}
			System.out.println("");
		}
		*/
//---------------------------------------------------
		int[][] tableau= new int [100][2];
		
		int pair = 0;
		int impair = 1;
		for(int i=0; i <= 99; i++) {
			tableau[i][0]= pair;
			tableau[i][1] = impair;
			impair = impair +2 ;
			pair = pair +2;
			
		}
		for(int i=0; i < 99; i++) {
			for(int j=0; j <= 1; j++) {
				System.out.print(tableau[i][j] + " | ");
			}
			System.out.println("");
		}
	}
}
