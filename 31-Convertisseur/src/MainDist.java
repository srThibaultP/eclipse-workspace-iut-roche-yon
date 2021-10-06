import java.util.Scanner;

import lry.dip.mesure.*;

public class MainDist {
    public static void main(String[] args) {
        Distance t = new Distance(0, 0, 0);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i != 2; i++) {
            switch (sc.nextLine()) {
                case "M":
                    Scanner nbM = new Scanner(System.in);
                    t.convMetre(nbM.nextDouble());
                    System.out.println(t.getInch() + " Inch");
                    System.out.println(t.getMile() + " Mile");
                    break;
                case "I":
                    Scanner nbI = new Scanner(System.in);
                    t.convInch(nbI.nextDouble());
                    System.out.println(t.getMetre() + " Metre");
                    System.out.println(t.getMile() + "  Mile");
                    break;
                case "L":
                    Scanner nbL = new Scanner(System.in);
                    t.convMile(nbL.nextDouble());
                    System.out.println(t.getMetre() + " Metre");
                    System.out.println(t.getInch() + " Inch");
                    break;
                default:
                    break;
            }
        }
        System.out.println(t.getDistance());
    }
}
