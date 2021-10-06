import java.util.Scanner;

import lry.dip.mesure.Temperature;

public class MainTemp {
    public static void main(String[] args) {
        Temperature t = new Temperature(0, 0, 0);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i != 2; i++) {
            switch (sc.nextLine()) {
                case "C":
                    Scanner nbC = new Scanner(System.in);
                    t.convCel(nbC.nextDouble());
                    // System.out.println(t.getFahrenheit() + "F");
                    // System.out.println(t.getKelvin() + "K");
                    break;
                case "K":
                    Scanner nbK = new Scanner(System.in);
                    t.convKel(nbK.nextDouble());
                    System.out.println(t.getFahrenheit() + "F");
                    System.out.println(t.getCelsius() + "C");
                    break;
                case "F":
                    Scanner nbF = new Scanner(System.in);
                    t.convFar(nbF.nextDouble());
                    System.out.println(t.getCelsius() + "C");
                    System.out.println(t.getKelvin() + "K");
                    break;
                default:
                    break;
            }
        }
    }
}
