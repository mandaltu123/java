package com.tuhin.javapreps.multiThreadings.synchronizatoin;

/**
 * Created by tuhinmandal on 18/07/16.
 */
public class TestCoffeePouringNDrinking {


    public static void main(String args[]) {

        Cup cup = new Cup(0); // initializing empty coffee cup

        Waiter bob = new Waiter(cup);
        Customer angusYoung = new Customer(cup);
        bob.start();
        angusYoung.start();


        //adding more delay to make sure that bob and angusYoung execution are complete,
        // only then we will get expected output
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // since we added data to the object 10 times and removed 10 times,
        //after execution we are expecting data (coffee) will be 0
        System.out.println("\n final output after thread runs :- " + cup.getCoffee());

    }

}
