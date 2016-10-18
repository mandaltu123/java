package com.tuhin.javapreps.utils;

/**
 * Created by tuhinmandal on 22/07/16.
 */
public class PrintUtil {

    public static void print(String statement, Object passedParameter) {
        System.out.format(statement, passedParameter);
    }
}
