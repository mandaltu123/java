package com.tuhin.javapreps.multiThreadings.onemoreset.basicsynchronization;

import java.util.Scanner;

/**
 * Created by tuhinmandal on 22/07/16.
 * <p>
 * Reference : https://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html
 * In programming, an atomic action is one that effectively happens all at once. An atomic action cannot stop in the
 * middle: it either happens completely, or it doesn't happen at all. No side effects of an atomic action are visible
 * until the action is complete.
 * <p>
 * We have already seen that an increment expression, such as c++, does not describe an atomic action. Even very simple
 * expressions can define complex actions that can decompose into other actions. However, there are actions you can
 * specify that are atomic:
 * <p>
 * Reads and writes are atomic for reference variables and for most primitive variables (all types except long and
 * double).
 * Reads and writes are atomic for all variables declared volatile (including long and double variables).
 * Atomic actions cannot be interleaved, so they can be used without fear of thread interference. However, this does not
 * eliminate all need to synchronize atomic actions, because memory consistency errors are still possible. Using volatile
 * variables reduces the risk of memory consistency errors, because any write to a volatile variable establishes a
 * happens-before relationship with subsequent reads of that same variable. This means that changes to a volatile
 * variable are always visible to other threads. What's more, it also means that when a thread reads a volatile variable,
 * it sees not just the latest change to the volatile, but also the side effects of the code that led up the change.
 * <p>
 * Using simple atomic variable access is more efficient than accessing these variables through synchronized code, but
 * requires more care by the programmer to avoid memory consistency errors. Whether the extra effort is worthwhile
 * depends on the size and complexity of the application.
 */
public class VolatileUsage extends Thread {

    private int counter = 0;
    private volatile boolean running = true;

    /**
     * overridden run method. this method keeps on running till the
     * running boolean is set to true.
     * when shutdown is called, it modifies the value of the variable to false
     * and that causes termination of the while loop running in run()
     */
    public void run() {
        while (running) {

            counter++;
            System.out.println(counter);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public void shutDown() {
        running = false;
    }


}

class App {
    /**
     * We are starting a VolatileUsage thread from the main thread.
     * we created a scanner object that reads data entered in command line.
     * till the time user enters anything to the console and hits enter button
     * main thread's execution pauses
     * on entering enter button, we call shutdown to make running value false that
     * intern terminates VolatileUsage thread.
     * <p>
     *
     * using volatile we are making sure that the change made to the boolean variable
     * is being visible by all subsequent thread
     *
     * @param args
     */
    public static void main(String[] args) {
        VolatileUsage thread1 = new VolatileUsage();
        thread1.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        thread1.shutDown();
    }
}
