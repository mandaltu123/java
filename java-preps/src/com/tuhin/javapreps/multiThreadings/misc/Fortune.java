package com.tuhin.javapreps.multiThreadings.misc;

/**
 * @author tuhin
 */
public class Fortune extends Thread {

    public void run() {
        while (true) {
            System.out.println("Good things will come your way");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}

