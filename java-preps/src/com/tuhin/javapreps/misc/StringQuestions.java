package com.tuhin.javapreps.misc;

/**
 * Created by tuhinmandal on 18/07/16.
 */
public class StringQuestions {


    /**
     * == -> is a reference comparison, i.e. both objects point to the same memory location
     * .equals() -> evaluates to the comparison of values in the objects
     * <p>
     * When we create a String using double quotes, JVM looks in the String pool to find if any other
     * String is stored with same value. If found, it just returns the reference to that String
     * object else it creates a new String object with given value and stores it in the String pool.
     * When we use new operator, JVM creates the String object but don’t store it into the String Pool.
     * We can use intern() method to store the String object into String pool or return the reference if
     * there is already a String with equal value present in the pool.
     *
     * @param args
     */
    public static void main(String args[]) {
        String one = new String("abc");
        String two = "abc";
        String three = "abc";
        System.out.println(one == two);//false :
        System.out.println(one.equals(two)); // true
        System.out.println(two == three); // true
    }
}
