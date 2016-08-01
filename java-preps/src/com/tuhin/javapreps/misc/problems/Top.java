package com.tuhin.javapreps.misc.problems;

/**
 * Created by tuhinmandal on 29/07/16.
 */
public class Top {

    //public Top(){}
    public Top(String s) {
        System.out.print("B");
    }
}

class Bottom2 extends Top {

    //in class top if you do not specify a default constructor, there will be a compilation
    // error on Bottom2 if you create a parameterized constructor public Bottom2(String s)

     public Bottom2() {
        super("whatever");
     }
}
