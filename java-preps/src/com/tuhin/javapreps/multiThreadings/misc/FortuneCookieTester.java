package com.tuhin.javapreps.multiThreadings.misc;

import java.util.Scanner;

/**
 * Created by tuhinmandal on 18/07/16.
 */
public class FortuneCookieTester {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        Thread cookie3 = new Thread(new FortuneCookie("you will play the guitar ", " like ringing a bell", 1000));
        Thread cookie2 = new Thread(new FortuneCookie("you will ", " travel the world", 3000));

        //setting priority: since i am running on mac, i am expecting setting priorit
        //will behave as PRIORITY PREEMPTION.
        //but unfortunately

        //cookie2.setPriority(Thread.MAX_PRIORITY);
        //cookie3.setPriority(Thread.MIN_PRIORITY);
        cookie2.start();
        cookie3.start();

        cookie3.yield();

        /**
         * Creating an anonymous inner class with runnable interface to
         * spawn a thread
         */

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("anonymous inner class");
                        System.out.println("anonymous inner class");
                        System.out.println("anonymous inner class");
                        System.out.println("anonymous inner class");
                    }
                }
        ).start();


        /** try {
         /**
         * who is joining which thread ?
         *
         * we said cookie2.join.
         * since this thread is spawned from main thread,
         * so main thread will wait tile cookie2 finishes
         *
         cookie2.join();

         } catch (InterruptedException e) {
         e.printStackTrace();
         }

         **/
        System.out.println("Enter anything: ");
        scanner.next();
        System.out.println("input request in satisfied in main");
        try {
            Thread.sleep(3000);//at this point main goes into SLEEP state
        } catch (InterruptedException e) {
        }
        System.out.println("I slept for 3 seconds");

    }
}
