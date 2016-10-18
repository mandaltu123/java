package com.tuhin.javapreps.multiThreadings.producerConsumer;

/**
 * Created by tuhinmandal on 19/07/16.
 *
 * producer puts data into cup object
 */
public class Producer extends Thread {

    private Cup cup;
    private int number;

    public Producer(Cup cup, int number) {
        this.cup = cup;
        this.number = number;
    }

    public void run(){
        for(int i = 0; i < 5; i++) {
            cup.put(i);
            System.out.println("producer #" + this.number + " put " + i);
            try {
                sleep((long) (200 * Math.random()));
            } catch (InterruptedException e) {
            }
        }
    }
}
