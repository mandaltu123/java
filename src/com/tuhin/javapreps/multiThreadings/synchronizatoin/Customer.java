package com.tuhin.javapreps.multiThreadings.synchronizatoin;

/**
 * Created by tuhinmandal on 18/07/16.
 * <p>
 * Customer is the thread which will remove coffee (data) from cup (object)
 */
public class Customer extends Thread {

    private Cup cup;

    public Customer(Cup cup) {
        this.cup = cup;
    }

    public Cup getCup() {
        return cup;
    }

    public void setCup(Cup cup) {
        this.cup = cup;
    }

    /**
     * Customer thread will try to remove coffee (data) 10 times from cup (object)
     */
    public void run() {
        for (int i = 0; i < 10; i++) {
            cup.drink();
        }
    }
}
