package com.tuhin.javapreps.multiThreadings.countdownlatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by tuhinmandal on 23/07/16.
 */

class Processor implements Runnable {

    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        // we will simulate some tasks here
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        //once the task is done, we are going to count down the latches counter
        latch.countDown();
    }

}

public class CountDownLatchTester {

    public static void main(String[] args) {
        /**
         * passing 3 means we have three tasks.so
         */


        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //submitting 3 processors

        for (int i = 0; i < 3; i++) {
            System.out.println("submitting task: " + i);
            executor.submit(new Processor(latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
        }
        executor.shutdown();
        System.out.println("all 3 tasks are completed... exiting main()");
    }
}
