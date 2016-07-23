package com.tuhin.javapreps.multiThreadings.callableAndFuture;

import java.util.concurrent.*;

/**
 * Created by tuhinmandal on 24/07/16.
 * <p>
 * this class is an example of returning value from thread executions or
 * throwing exceptions.
 * callable statements are similar to runnable exeprt instead of void it returns
 * something.
 * future can hold those returned values and can be used for further use.
 */
public class CallableFutureTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int duration = (int) (Math.random() * 1000);
                System.out.println("Starting....");
                Thread.sleep(duration);
                System.out.println("Finished....");
                return duration;
            }
        });

        executor.shutdown();
        try {
            System.out.println("future value : " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
