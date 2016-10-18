package com.tuhin.javapreps.misc;

/**
 * Created by tuhinmandal on 29/07/16.
 */
public class TestIncrement {

    public static void main ( String args[]) {
        int b = 10;
        int a = 5;

        b += a++ + ++a;
        System.out.print(b);

        String c = a > b ? "hello" : "none";
        System.out.println(c);
    }
}
