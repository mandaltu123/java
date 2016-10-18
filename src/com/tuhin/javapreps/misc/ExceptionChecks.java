package com.tuhin.javapreps.misc;

import java.io.FileNotFoundException;

/**
 * Created by tuhinmandal on 17/09/16.
 */
public class ExceptionChecks {


    protected void test(int x) {

        if(x == 0) {
            throw new CustomException("x can not be 0");
        } else if( x > 5 && x < 10) {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
            }
        }
        throw new UnsupportedOperationException();
        //throw new NullPointerException();
    }

    public static void main(String[] args) {
        new ExceptionChecks().test(9);
    }
}


class CustomException extends RuntimeException {

    //Parameterless Constructor
    public CustomException() {}

    //Constructor that accepts a message
    public CustomException(String message)
    {
        super(message);
    }

}
