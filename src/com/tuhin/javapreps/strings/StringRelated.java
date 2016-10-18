package com.tuhin.javapreps.strings;

/**
 * Created by tuhinmandal on 18/07/16.
 */
public class StringRelated {

    public void foo(String s) {
        System.out.print("foo string");
    }

    public void foo(StringBuilder sb) {
        System.out.print("foo stringbuilder");
    }

    public void foo(Object obj) {
        System.out.print("foo Object");
    }

    public static void main(String args[]) {
        //new StringRelated().foo(null); //: compilation problem, ambiguous method call
        //new StringRelated().foo(null);
       // new StringRelated().foo(null);
    }
}
