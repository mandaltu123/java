package com.tuhin.javapreps.misc.problems;

/**
 * Created by tuhinmandal on 29/07/16.
 */
public class Clidders {

    public Clidders() {
        System.out.println("I am in super class's constructor");
    }

    //if you make this method final, you will get a compilation error at line 23 since final methods
    // cannot be overridden
    public void flipper() {
        System.out.println("Clidders");
    }
}

class Clidlets extends Clidders {

    public Clidlets() {
        super();
    }
    public void flipper() {
        super.flipper();
    }

    public static void main(String[] args) {
        new Clidlets().flipper();
    }
}
