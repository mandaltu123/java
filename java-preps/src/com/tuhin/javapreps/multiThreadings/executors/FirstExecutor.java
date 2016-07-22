package com.tuhin.javapreps.multiThreadings.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by tuhinmandal on 22/07/16.
 * Here are some theory of executor service from dzone:https://dzone.com/articles/java-concurrency-%E2%80%93-part-7
 * <p>
 * Runnable runnable =newRunnable(){publicvoid run(){System.out.println("Run");}}
 * new Thread(runnable).start();
 * <p>
 * <p>
 * This is very simple and clean, but what if you’ve several long running tasks that you want to load in parallel and
 * then wait for the completion of all the tasks: it’s a little bit harder to code. And if you want to get the return
 * value of all the tasks it becomes really difficult to maintain good code. But as with almost any problem, Java has
 * a solution for you, the Executors. This simple class allows you to create thread pools and thread factories.
 * <p>
 * See executors.txt for details
 */


class Processor implements Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("starting : " + id);
        //simulating some work that takes time to process
        try {
            Thread.sleep(5000); // simulating eacth task takes 5 seconds to process
        } catch (InterruptedException e) {
        }
        System.out.println("completed : " + id);

    }
}

public class FirstExecutor {

    public static void main(String[] args) {

        //we are going to create 5 tasks and assign them to 2 threads from thread pool
        ExecutorService executors = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executors.submit(new Processor(i));
        }



        //once these tasks are finished, we want to shutdown
        /**
         * Initiates an orderly shutdown in which previously submitted
         * tasks are executed, but no new tasks will be accepted.
         * Invocation has no additional effect if already shut down.
         *
         * <p>This method does not wait for previously submitted tasks to
         * complete execution.  Use {@link #awaitTermination awaitTermination}
         * to do that.
         *
         * @throws SecurityException if a security manager exists and
         *         shutting down this ExecutorService may manipulate
         *         threads that the caller is not permitted to modify
         *         because it does not hold {@link
         *         java.lang.RuntimePermission}{@code ("modifyThread")},
         *         or the security manager's {@code checkAccess} method
         *         denies access.
         */
        executors.shutdown();
        System.out.println("All tasks submitted");
        try {
            executors.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }
        System.out.println("All tasks completed");
    }
}
