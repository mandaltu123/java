package com.tuhin.javapreps.design.singleton;

/**
 * Created by tuhinmandal on 18/07/16.
 */
public class SigletonTester {

    public static void main(String args[]) {

        Runnable instance1 = new ThreadAccessor();
        Runnable instance2 = new ThreadAccessor();
        new Thread(instance1).start();
        new Thread(instance2).start();

        MySingleton obj1 = MySingleton.getInstance();
        System.out.println(System.identityHashCode(obj1));
    }
}
