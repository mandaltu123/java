package com.tuhin.javapreps.multiThreadings.concurrentutils;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by tuhinmandal on 23/07/16.
 */
public class ProducerBlockingQueue implements Runnable {

    private BlockingQueue<Integer> queue;

    public ProducerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                int value = random.nextInt(1000);
                System.out.println("Producer# put: "+ value);
                queue.put(value);
            } catch (InterruptedException e) {
            }
        }
    }
}
