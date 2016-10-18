package com.tuhin.javapreps.misc.problems;

/**
 * Created by tuhinmandal on 29/07/16.
 */
public class ParentWithFinalMethod {

    private final void doSomething() {
        System.out.println("in parent");
    }
}

class Child extends ParentWithFinalMethod {
    public final void doSomething() {
        System.out.println("in child");
    }

    public static void main(String[] args) {
        new Child().doSomething();
    }
}
