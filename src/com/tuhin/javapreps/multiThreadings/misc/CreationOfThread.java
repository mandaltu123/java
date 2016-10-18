package com.tuhin.javapreps.multiThreadings.misc;

import java.util.Scanner;

/**
 * @author mandaltu
 *         <p>
 *         This class is to explain how thread works, thread life cycle.
 *         Though here we will discuss how thread dispatcher (scheduler) works [just overview]
 *         <p>
 *         when there are multiple threads in the ready state who gets the processor ?
 *         #Remember the as an application programmer we never has any control over this, its entirely up to CPU scheduler's job to do it
 *         #Round Robin/Time slicing :
 *         all threads are treated equally, each is given a slice of time on the processor. when that time
 *         slice expires, the next in order is given the processor.As developer we just throw in bunch of threads to the scheduler and
 *         it is scheduler's job to do the time slicing.
 *         <p>
 *         #Priority preemption:
 */
public class CreationOfThread {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /**
         * Before creating those two threads let us see why we need multi threading.
         * The bellow example shows that from this main method (which is main thread of execution , or where we start the main thread)
         * to do anything with our java program.
         *
         * In this example we create a scanner object which takes input from console.
         * Once we give input from the console it moves ahead.
         *
         * But if we do not enter anything from console, the program is stuck.
         * How do we solve or avoid this kind of issues.
         *
         */

        Scanner scanner = new Scanner(System.in);


        Fortune fortune = new Fortune();//thread is in borne state
        // fortune.setDaemon(true);//making it daemon thread to stop execution
        //as soon as main thread dies
        //this is how we spawn a thread
        //start method is inherited from thread class
        fortune.start();//thread is at READY state
       // fortune.suspend(); suspend is depricated as developers are never been able to use it proficiently
        //fortune.yield(); // yield() interrupts current thread's execution and let other threads
        //access resource.
        /**
         * we can see that once main thread's execution is over,
         * fortuneThread keeps running even though thread that has
         * spawned it has already died.
         *
         * In order to kill the fortune thread as soon as main thread
         * dies we can make fortuneThread as Daemon thread
         *
         *
         */




        System.out.println("Enter anything: ");

        scanner.next();//IO-blocked state
        //at this point main thread goes to IO-BLOCKED state till we key in some inputs from the console.
        //this is no longer a running thread

        System.out.println("input request in satisfied in main");
        //at this time the IO is released and main thread again goes to READY state

        try {

            Thread.sleep(3000);//at this point main goes into SLEEP state
        } catch (InterruptedException e) {
        }
        //once 3 seconds over, main thread goes into READY state
        System.out.println("I slept for 3 seconds");
    }
}