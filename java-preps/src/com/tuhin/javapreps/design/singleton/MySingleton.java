package com.tuhin.javapreps.design.singleton;

/**
 * Created by tuhinmandal on 18/07/16.
 */
public final class MySingleton {

    //one and only instance of this class
    private static MySingleton firstInstance = null;

    private static boolean firstThread = true;

    //creating private constructor to restrict from calling new
    private MySingleton() {}

    public static MySingleton getInstance() {
        if (firstInstance == null) {
            if (firstThread) {
                firstThread = false;
                Thread.currentThread(); // we are just messing around with this.
                //stopping one thread to prove that in multi threaded environment also
                // this piece of code works just fine
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (MySingleton.class) {
                if (firstInstance == null) {
                    firstInstance = new MySingleton();
                }
            }
        }
        return firstInstance;
    }
}
