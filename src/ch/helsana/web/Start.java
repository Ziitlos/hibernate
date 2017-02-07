package ch.helsana.web;

import java.util.Random;

/**
 * Created by hkfq4 on 07.02.2017.
 */
public class Start {

    //psvm shortcut für main Class
    public static void main(String[] args) {

        System.out.println("Hellooooo");

        long millis = new java.util.Date().getTime();
        System.out.println("Millis: " + millis);

        int a = 0;
        for(int i = 0; i < 100; i++){
            a = a + 1;
            System.out.println(a);
        }

        System.out.println("Zähler: " + a);

        long millis1 = new java.util.Date().getTime();
        System.out.println("Millis: " + millis1);

        long millis2 = new java.util.Date().getTime();
        System.out.println("Millis: " + millis2);

        Random randomGenerator = new Random();
        //for (int idx = 1; idx <= 10; ++idx){
            int randomInt = randomGenerator.nextInt(1000);
            System.out.println("Generated : " + randomInt);
        //}


    }

}
