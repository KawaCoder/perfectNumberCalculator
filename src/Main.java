import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static int somme;
    static int nombre;
    static int nbofpn;
    static long startTime;
    static long endTime;
    static String nombrestr= " ";
    static String filename;


    public static void savefile() throws Exception {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("saved");
            FileOutputStream fos = new FileOutputStream(file, false);
            fos.write(nombrestr.getBytes());
            fos.close();
        }
    }

    public static void main(String[] args) throws Exception {


        ArrayList<Integer> nombres_parfaits = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);


        System.out.println("Up to what number do you want to compute the perfect numbers?");
        nbofpn = sc.nextInt();
        filename="Perfect_number"+nbofpn+".txt";
        FileOutputStream fos2 = new FileOutputStream(filename, true);
        fos2.write("e".getBytes());
        fos2.close();


        System.out.println("The perfect numbers found will be saved in a text file \nnamed \"Perfect_number"+nbofpn+".txt\" in the same directory as the perfectNumberCalculator.jar file. \nFrom which number to start?");
        nombre = sc.nextInt();


        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        for (int i = nombre; i <= nbofpn; i++){

            for (int ii = 1; ii <= nombre/2; ii++) {

                if (i % ii == 0) {
                    somme=somme+ii;

                }

                if (i==somme){
                    nombres_parfaits.add(i);
                    nombrestr = String.valueOf(nombres_parfaits);
                    savefile();
                    System.out.println(i);
                    break;

                }


            }
            somme = 0;


            nombre++;


        }



        endTime = System.currentTimeMillis();


        System.out.println("Perfect_number"+nbofpn+".txt saved. The perfect numbers up to " + nbofpn + " have been found in "+(endTime - startTime)+" ms.");


    }
}


