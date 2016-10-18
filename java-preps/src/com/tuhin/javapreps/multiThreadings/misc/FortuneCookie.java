package com.tuhin.javapreps.multiThreadings.misc;

/**
 * Created by tuhinmandal on 18/07/16.
 */
public class FortuneCookie implements Runnable {

    private String first;
    private String last;
    private int sleepyTime;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getSleepyTime() {
        return sleepyTime;
    }

    public void setSleepyTime(int sleepyTime) {
        this.sleepyTime = sleepyTime;
    }

    public FortuneCookie(String first, String last, int sleepyTime){

        this.first = first;
        this.last = last;
        this.sleepyTime = sleepyTime;
    }

    public void run() {
        while (true) {
            System.out.print(first);
            try {
                Thread.sleep(sleepyTime);
            } catch (InterruptedException e) {
            }
            System.out.println(last);
        }
    }
}
