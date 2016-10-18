package com.tuhin.javapreps.multiThreadings.synchronizatoin;

/**
 * Created by tuhinmandal on 18/07/16.
 * <p>
 * Always remember whatever thread does, it does on object.
 * So in order to implement thread safety everything we have
 * to do on the object that is being accessed or shared by threads.
 * <p>
 * <p>
 * Here we are going to demonstrate a behaviour that two threads waiter and
 * customer are trying to access one object / resource that is cup (object);
 * <p>
 * waiter thread is trying to add coffee(adding data) to it, where customer thread
 * is trying to drink coffee (removing data) from the cup.
 * <p>
 * in order to prevent cup's (shared object) data (coffee) from getting corrupted
 * we have to implement thread safety on methods or variables of Cup class[because these
 * are the RESOURCES that are being accessed by multiple threads].
 */
public class Cup {

    private int coffee;

    public Cup(int coffee) {
        this.coffee = coffee;
    }


    synchronized public int getCoffee() {
        return coffee;
    }

    synchronized public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    /**
     * drink() is removing data from object cup
     * customer thread will do this
     */
    synchronized public void drink() {
        int localCoffee = coffee;
        localCoffee--; // removing data
        System.out.print(" sip ");
        // adding a sleep here to pause the execution for a while
        try {
            Thread.sleep((long) (100 * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coffee = localCoffee;

    }

    /**
     * pour() is adding data to the object cup
     * waiter thread will do this
     */
    synchronized public void pour() {
        int localCoffee = coffee;
        localCoffee++; //adding data
        System.out.print(" pour ");
        // adding sleep to provide some delay in the execution
        try {
            Thread.sleep((long) (100 * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coffee = localCoffee;
    }


}
