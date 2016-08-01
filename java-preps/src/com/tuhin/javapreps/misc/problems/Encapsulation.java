package com.tuhin.javapreps.misc.problems;

/**
 * Created by tuhinmandal on 29/07/16.
 */
public class Encapsulation {

    public int size;


    public static void main(String[] args) {
        Encapsulation one = new Encapsulation();
        one.size = 15;
        Encapsulation two = new Encapsulation();
        System.out.println(one.size);
        System.out.println(two.size);
    }
}
