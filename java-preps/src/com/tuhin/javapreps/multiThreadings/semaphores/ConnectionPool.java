package com.tuhin.javapreps.multiThreadings.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by tuhinmandal on 23/07/16.
 * <p>
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html
 * public class Semaphore
 * extends Object
 * implements Serializable
 * A counting semaphore. Conceptually, a semaphore maintains a set of permits. Each acquire() blocks if necessary until a
 * permit is available, and then takes it. Each release() adds a permit, potentially releasing a blocking acquirer.
 * However, no actual permit objects are used; the Semaphore just keeps a count of the number available and acts
 * accordingly.
 * Semaphores are often used to restrict the number of threads than can access some (physical or logical) resource.
 * For example, here is a class that uses a semaphore to control access to a pool of items:
 * <p>
 * Before obtaining an item each thread must acquire a permit from the semaphore, guaranteeing that an item is available
 * for use. When the thread has finished with the item it is returned back to the pool and a permit is returned to the
 * semaphore, allowing another thread to acquire that item. Note that no synchronization lock is held when acquire()
 * is called as that would prevent an item from being returned to the pool. The semaphore encapsulates the synchronization
 * needed to restrict access to the pool, separately from any synchronization needed to maintain the consistency of the
 * pool itself.
 * <p>
 * A semaphore initialized to one, and which is used such that it only has at most one permit available, can serve as a
 * mutual exclusion lock. This is more commonly known as a binary semaphore, because it only has two states: one permit
 * available, or zero permits available. When used in this way, the binary semaphore has the property (unlike many Lock
 * implementations), that the "lock" can be released by a thread other than the owner (as semaphores have no notion of
 * ownership). This can be useful in some specialized contexts, such as deadlock recovery.
 */
public class ConnectionPool {

    private static ConnectionPool instance = new ConnectionPool();
    private Semaphore semaphore = new Semaphore(10);// we want to limit our number of connections to 10
    private int connections = 0;

    private ConnectionPool() {}

    /**
     * Creating a singleton way of providing an instance of connection pool class
     *
     * @return: instance of connection pool class.
     */
    public static ConnectionPool getConnection() {
        return instance;
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 500; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    ConnectionPool.getConnection().connect();
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }
    }

    /**
     * connect method will simulate that each time we call get connection.connect, it will increment connections
     */
    public void connect() {
        try {
            semaphore.acquire();
            doConnect();
        } catch (InterruptedException e) {
        } finally {
            semaphore.release();
        }
    }

    private void doConnect() {
        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }

        //simulating some work

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        // we are not actually returning number of connections .
        // we are just saying connect , do some work and then release connection
        synchronized (this) {
            connections--;
        }
    }
}
