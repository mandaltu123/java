package com.tuhin.javapreps.multiThreadings.synchronizatoin;

/**
 * Created by tuhinmandal on 22/07/16.
 */
public class SnchronizedBlocks extends Thread {

    public void printMe(){
        synchronized (this) {
            for (int i = 0; i < 10; i ++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    public void run(){
        printMe();
    }

    public static void main(String[] args) {
        Thread one = new SnchronizedBlocks();
        Thread two = new SnchronizedBlocks();

        one.start();
        two.start();
    }


}
