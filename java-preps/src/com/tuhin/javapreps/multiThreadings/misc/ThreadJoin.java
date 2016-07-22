package com.tuhin.javapreps.multiThreadings.misc;

/**
 * Created by tuhinmandal on 20/07/16.
 */
public class ThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep((long) (100 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName());
        }
    }


    public static void main(String args[]) {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread one = new Thread(threadJoin);
        Thread two = new Thread(threadJoin);
        Thread three = new Thread(threadJoin);

        one.start();
        try {
            /**
             * adding join on thread one is making sure that only when one is dead state, other threads can be executed
             */
            one.join();
        } catch (InterruptedException e) {
        }
        two.start();
        try {
            two.join();
        } catch (InterruptedException e) {
        }
        three.start();
        try {
            three.join();
        } catch (InterruptedException e) {
        }
    }
}
