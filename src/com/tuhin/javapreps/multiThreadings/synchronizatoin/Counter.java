package com.tuhin.javapreps.multiThreadings.synchronizatoin;

/**
 * Created by tuhinmandal on 22/07/16.
 */
public class Counter {

    private int counter;

    synchronized public void increment() {
        counter++;
        System.out.print(" adding ");
    }

    synchronized  public void decrement() {
        counter--;
        System.out.print(" removing ");
    }

    synchronized public int value() {
        return counter;
    }

}
