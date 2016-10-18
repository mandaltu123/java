package com.tuhin.javapreps.multiThreadings.onemoreset.basicsynchronization;

/**
 * Created by tuhinmandal on 22/07/16.
 */
public class Synchronization {

    private int counter = 0;


    public static void main(String[] args) {
        Synchronization synchronization = new Synchronization();
        synchronization.doSomething();
    }

    public synchronized void increment() {
        counter++;
    }

    public void doSomething() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });
        t1.start();
        t2.start();



        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        System.out.print(counter);
    }
}
