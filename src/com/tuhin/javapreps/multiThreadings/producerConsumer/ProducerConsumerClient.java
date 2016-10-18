package com.tuhin.javapreps.multiThreadings.producerConsumer;

/**
 * Created by tuhinmandal on 19/07/16.
 */
public class ProducerConsumerClient {

    public static void main(String args[]) {

        Cup cup = new Cup();
        Producer producer = new Producer(cup, 1);
        Consumer consumer1 = new Consumer(cup, 1);
        Consumer consumer2 = new Consumer(cup, 2);

        producer.start();
        consumer1.start();
        consumer2.start();

        /**
         * here is the output for this program :
         *
         *
         producer #1 put 0
         consumer #1 got 0
         producer #1 put 1
         consumer #1 got 1
         producer #1 put 2
         consumer #2 got 2
         producer #1 put 3
         consumer #2 got 3
         producer #1 put 4
         consumer #1 got 4
         */
    }
}
