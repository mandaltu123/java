package com.tuhin.javapreps.multiThreadings.deadlock;

/**
 * Created by tuhinmandal on 21/07/16.
 * <p>
 * Deadlock describes a situation where two or more threads are blocked forever, waiting for each other. Here's an example.
 * <p>
 * Alphonse and Gaston are friends, and great believers in courtesy. A strict rule of courtesy is that when you bow
 * to a friend, you must remain bowed until your friend has a chance to return the bow. Unfortunately, this rule does
 * not account for the possibility that two friends might bow to each other at the same time.
 * reference: https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html
 */
public class DeadLock {

    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + " has bowed to me! %n", this.name, bower.getName());
            bower.bowback(this);
        }

        public synchronized void bowback(Friend bower) {
            System.out.format("%s: %s" + " has bowed back to me! %n", this.name, bower.getName());
        }

    }

    public static void main(String[] args) {
        final Friend tom = new Friend("Tom");
        final Friend harry = new Friend("Harry");

        new Thread(new Runnable() {
            @Override
            public void run() {
                tom.bow(harry);
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                harry.bow(tom);
            }
        }).start();
    }

    /**
     * Here is the Thread dump analysis
     *
     * Found one Java-level deadlock:
     =============================
     "Thread-1":
     waiting to lock monitor 0x00007fdca38166a8 (object 0x0000000795797b00, a com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$Friend),
     which is held by "Thread-0"
     "Thread-0":
     waiting to lock monitor 0x00007fdca3813cb8 (object 0x0000000795797b40, a com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$Friend),
     which is held by "Thread-1"

     Java stack information for the threads listed above:
     ===================================================
     "Thread-1":
     at com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$Friend.bowback(DeadLock.java:32)
     - waiting to lock <0x0000000795797b00> (a com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$Friend)
     at com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$Friend.bow(DeadLock.java:28)
     - locked <0x0000000795797b40> (a com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$Friend)
     at com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$2.run(DeadLock.java:52)
     at java.lang.Thread.run(Thread.java:745)
     "Thread-0":
     at com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$Friend.bowback(DeadLock.java:32)
     - waiting to lock <0x0000000795797b40> (a com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$Friend)
     at com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$Friend.bow(DeadLock.java:28)
     - locked <0x0000000795797b00> (a com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$Friend)
     at com.tuhin.javapreps.multiThreadings.deadlock.DeadLock$1.run(DeadLock.java:44)
     at java.lang.Thread.run(Thread.java:745)

     Found 1 deadlock.


     */

}
