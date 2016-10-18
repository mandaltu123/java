package com.tuhin.javapreps.multiThreadings.producerConsumer;

import com.tuhin.javapreps.multiThreadings.synchronizatoin.*;

/**
 * Created by tuhinmandal on 19/07/16.
 * consumer thread gets value from cup object
 */
public class Consumer extends Thread {

    private Cup cup;
    private int number;

    public Consumer(Cup cup, int number) {
        this.cup = cup;
        this.number = number;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 5; i++) {
            try {
                sleep((long) (200 * Math.random()));
            } catch (InterruptedException e) {
            }
            value = cup.get();
            System.out.println("consumer #" + this.number + " got " + value);
        }
    }

}
