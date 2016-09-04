package com.tuhin.javapreps.design.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author tuhinmandal on 05/09/16.
 */
public class MySingletonWithEnum {

    enum Single {
        INSTANCE;
        MySingletonWithEnum s = new MySingletonWithEnum();
        public MySingletonWithEnum getInstance() {
            if(s == null) {
                return new MySingletonWithEnum();
            } else {
                return s;
            }
        }
    }


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    //access this singleton instance
                    MySingletonWithEnum singleton1 = Single.INSTANCE.getInstance();
                    MySingletonWithEnum singleton2 = Single.INSTANCE.getInstance();
                    System.out.println(singleton1.hashCode() + " " + singleton2.hashCode()); // check hashcodes of
                    // instances
                    /**
                     * output of hashcodes of all objects
                     *
                     *   1222126748 1222126748
                         1222126748 1222126748
                         1222126748 1222126748
                         1222126748 1222126748
                         1222126748 1222126748
                         1222126748 1222126748
                         1222126748 1222126748
                         1222126748 1222126748
                         1222126748 1222126748
                         1222126748 1222126748
                     */
                }
            }));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }
    }
}
