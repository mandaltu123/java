package com.tuhin.javapreps.multiThreadings.concurrentutils;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by tuhinmandal on 23/07/16.
 * <p>
 * Reference: https://www.youtube.com/watch?v=Vrt5LqpH2D0&list=PLBB24CFB073F1048E&index=6#t=613.607115
 * <p>
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html
 * public interface BlockingQueue<E>
 * extends Queue<E>
 * A Queue that additionally supports operations that wait for the queue to become non-empty when retrieving an element,
 * and wait for space to become available in the queue when storing an element.
 * BlockingQueue methods come in four forms, with different ways of handling operations that cannot be satisfied
 * immediately, but may be satisfied at some point in the future: one throws an exception, the second returns a
 * special value (either null or false, depending on the operation), the third blocks the current thread indefinitely
 * until the operation can succeed, and the fourth blocks for only a given maximum time limit before giving up.
 * These methods are summarized in the following table:
 * <p>
 * Throws exception	Special value	Blocks	Times out
 * Insert	add(e)	offer(e)	put(e)	offer(e, time, unit)
 * Remove	remove()	poll()	take()	poll(time, unit)
 * Examine	element()	peek()	not applicable	not applicable
 */
public class ProducerConsumerConcUtils {



    public static void main(String args[]) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new ProducerBlockingQueue(queue));
        executor.submit(new ConsumerBlockingQueue(queue));

        /*try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }
        executor.shutdown();*/

        System.out.println("we do not need to run main method, hence exiting!!");
    }
}
