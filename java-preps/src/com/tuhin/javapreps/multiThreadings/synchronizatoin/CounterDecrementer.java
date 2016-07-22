package com.tuhin.javapreps.multiThreadings.synchronizatoin;

/**
 * Created by tuhinmandal on 22/07/16.
 */
public class CounterDecrementer implements Runnable {

    private Counter counter;

    public CounterDecrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        for (int i =0; i < 5; i++) {
            counter.decrement();
        }

    }

}
