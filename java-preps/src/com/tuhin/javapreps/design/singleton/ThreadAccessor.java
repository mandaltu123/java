package com.tuhin.javapreps.design.singleton;

/**
 * Created by tuhinmandal on 18/07/16.
 */
public class ThreadAccessor implements Runnable {
    @Override
    public void run() {
        MySingleton obj1 = MySingleton.getInstance();
        System.out.println(System.identityHashCode(obj1));
    }
}
