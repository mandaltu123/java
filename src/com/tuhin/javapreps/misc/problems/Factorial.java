package com.tuhin.javapreps.misc.problems;

/**
 * Created by tuhinmandal on 29/07/16.
 */
public class Factorial {

    /**
     * the product of an integer and all the integers below it; e.g. factorial four ( 4! )
     * is equal to 4*3*2*1=24.
     *
     * @param number
     * @return factorial value of given number
     */
    public int factorial(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return number;
        }

        return number * factorial(number - 1);
    }


    public static void main(String[] args) {

        Factorial fact = new Factorial();
        int factorialValue = fact.factorial(6);
        System.out.println(factorialValue);
    }
}
