package com.tuhin.javapreps.innerClasses;

/**
 * Created by tuhinmandal on 22/07/16.
 */
public class OuterClass {

    public int data = 10;
    private int otherData = 20;
    final int time = 10000;
    static final int timeStaticFinal = 900;

    public static class StaticInner {

        public void printFromStaticInner() {
            System.out.println(timeStaticFinal);
        }
    }

    public class NonStaticInner {

        public void printFromNonStaticInner() {
            System.out.println(data);
            System.out.println(otherData);
            System.out.println(time + timeStaticFinal);
        }
    }
}
