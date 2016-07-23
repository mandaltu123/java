package com.tuhin.javapreps.multiThreadings.concurrentutils;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by tuhinmandal on 23/07/16.
 */
public class ConsumerBlockingQueue implements Runnable {

    private BlockingQueue<Integer> queue;

    public ConsumerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                // simulating real time scenario where we are saying that consumer will do some processing
                //which takes time
                Thread.sleep(1000);
                if (random.nextInt(10) == 0) {
                    int value = queue.take();
                    System.out.println("Consumer# take : " + value + "; Queue size is: " + queue.size());
                }

            } catch (InterruptedException e) {
            }
        }
    }
}
