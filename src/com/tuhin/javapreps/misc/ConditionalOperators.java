package com.tuhin.javapreps.misc;

/**
 * Created by tuhinmandal on 29/07/16.
 */
public class ConditionalOperators {


    public static void main(String[] args) {
        int a = 5, b = 4, c = 3, d = 2;

        System.out.println((a < b && c > b));

        System.out.println((a >= c || d >= 5));

        System.out.println(!(a > b));

        System.out.println((b >= a && !(d < b)));

        System.out.println((a > b || c > b && c < d));
        /**
         * Here are the out puts
         *
         false
         true
         false
         false
         true
         */
    }
}
