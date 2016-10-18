package com.tuhin.javapreps.multiThreadings.synchronizatoin;

/**
 * Created by tuhinmandal on 18/07/16.
 * <p>
 * Waiter is the thread which will add data to cup object
 */
public class Waiter extends Thread {

    private Cup cup;

    public Waiter(Cup cup) {
        this.cup = cup;
    }

    public Cup getCup() {
        return cup;
    }

    public void setCup(Cup cup) {
        this.cup = cup;
    }

    /**
     * waiter thread will try to add coffee (add data) 10 times
     */
    public void run() {
        for (int i = 0; i < 10; i++) {
            cup.pour();
        }
    }
}
