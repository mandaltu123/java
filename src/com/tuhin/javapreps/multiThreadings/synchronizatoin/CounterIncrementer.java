package com.tuhin.javapreps.multiThreadings.synchronizatoin;

/**
 * Created by tuhinmandal on 22/07/16.
 */
public class CounterIncrementer implements Runnable {

    private Counter counter;

    public CounterIncrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i< 5; i++) {
            counter.increment();

            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
