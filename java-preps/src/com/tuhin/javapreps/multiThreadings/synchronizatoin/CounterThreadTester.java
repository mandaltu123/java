package com.tuhin.javapreps.multiThreadings.synchronizatoin;

/**
 * Created by tuhinmandal on 22/07/16.
 */
public class CounterThreadTester {

    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterIncrementer incrementer = new CounterIncrementer(counter);
        CounterDecrementer decrementer = new CounterDecrementer(counter);
        new Thread(incrementer).start();
        new Thread(decrementer).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.print(" Exiting main thread " + counter.value());
    }
}
