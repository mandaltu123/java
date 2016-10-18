package com.tuhin.javapreps.multiThreadings.producerConsumer;

/**
 * Created by tuhinmandal on 19/07/16.
 * Cup is the object shared by producer and cosumer threads.
 * <p>
 * Once producer puts some data into it, it releases lock on cup
 * object and notifies all the consumer threads to access the data.
 * <p>
 * once consumer gets notified, it gets lock on cup and starts consuming.
 * <p>
 * here we are going to simulate scenario where producer puts one data
 * into cup and the moment cup has a data it releases lock and notifies consumer
 * to access the added data.consumer wakes up from wait state and gets the lock,
 * once data is consumed, it goes to releases the lock, goes to wait state
 * and then notifies other threads.
 *
 * Reference : https://www.youtube.com/watch?v=VuahrRY0TgU&list=PLExJ0mIfzKFxYLIBI-WL_oM36pbkee0d8&index=8
 */
public class Cup {

    private int content;
    private boolean isAvailable = false;

    /**
     * as long as cup is empty, it waits.
     * the moments it receives notification from consumer it sets the value of
     * is data available to false , because by then producer has made it true.
     * it notifies all the threads that it has done it's job and returns the data.
     *
     * @return
     */
    synchronized public int get() {
        while (!isAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        isAvailable = false;
        notifyAll();
        return content;
    }

    /**
     * producer goes to waiting state as long as any data available in the cup.
     * moment it gets notification by consumer it goes makes is data available flag
     * to true because by now consumer has made it false.it wakes up and aquires lock,
     * puts data into the cup object and notifies all consumer threads start consuming
     * the data.
     *
     * @param data
     */
    synchronized public void put(int data) {
        while (isAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        isAvailable = true;
        content = data;
        notifyAll();
    }
}
