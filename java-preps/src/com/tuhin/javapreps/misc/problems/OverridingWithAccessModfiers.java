package com.tuhin.javapreps.misc.problems;

/**
 * Created by tuhinmandal on 30/07/16.
 */
public class OverridingWithAccessModfiers {

     void display() {
        System.out.println("parent");
    }
}

class ChildTest  extends OverridingWithAccessModfiers {
    protected void display() {
        System.out.println("parent");
    }

    public static void main(String[] args) {
        new ChildTest().display();
    }
}
