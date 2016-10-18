package com.tuhin.javapreps.misc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author tuhinmandal on 08/09/16.
 */
public class BlockingQueTest {


    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue(10);


    private static void producer() throws InterruptedException {

        Random random = new Random();
        while (true) {
            Integer value = random.nextInt(100);
            System.out.println("put : " + value);
            queue.put(value);
        }
    }


    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100);//simulating taking out data from queue and that takes little time to process
            if(random.nextInt(10) == 0) {
                Integer value = queue.take();
                System.out.println("get : " + value);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                }
            }
        }));
        executorService.submit(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                }
            }
        }));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
