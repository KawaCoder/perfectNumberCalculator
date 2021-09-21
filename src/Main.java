import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/* This Source Code Form is subject to the terms of the Mozilla Public
 *  License, v. 2.0. If a copy of the MPL was not distributed with this
 *  file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *  License holder: DR34M-M4K3R#7751 */



public class Main {


    static long startTime;
    static long endTime;
    static String nombrestr= " ";
    static String filename;

    public static boolean isperfect(int number){
        int somme = 0;

        for (int ii = 1; ii <= number /2; ii++) {

            if (number % ii == 0) {
                somme=somme+ii;

            }
        }
        return (number==somme);

    }

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


        ArrayList<Integer> nombres_parfaits = new ArrayList<>();

        Scanner sc = new Scanner(System.in);


        System.out.println("Up to what number do you want to compute the perfect numbers?");
        int max = sc.nextInt();
        filename="Perfect_number"+ max +".txt";
        FileOutputStream fos2 = new FileOutputStream(filename, true);
        fos2.write("e".getBytes());
        fos2.close();


        System.out.println("The perfect numbers found will be saved in a text file \nnamed \"Perfect_number"+ max +".txt\" in the same directory as the perfectNumberCalculator.jar file. \nFrom which number to start?");
        int min = sc.nextInt();


        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        for (int i = min; i <= max; i++){

                if (isperfect(i)){
                    nombres_parfaits.add(i);
                    nombrestr = String.valueOf(nombres_parfaits);
                    savefile();
                    System.out.println(i);
                    //break;

                }


        }



        endTime = System.currentTimeMillis();


        System.out.println("Perfect_number"+ max +".txt saved. The perfect numbers up to " + max + " have been found in "+(endTime - startTime)+" ms.");


    }
}


