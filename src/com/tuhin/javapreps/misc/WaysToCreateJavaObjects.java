package com.tuhin.javapreps.misc;

import java.io.ObjectInputStream;

import static java.lang.Class.forName;

/**
 * Created by tuhinmandal on 16/07/16.
 *
 * There are 4 different ways to create objects in java, they are as follows :
 *
 * 1. Using new keyword
 * 2. Using class.forName()
 * 3. Using clone
 * 4. using object de serialization
 */
public class WaysToCreateJavaObjects extends ClassLoaderBunny {

    public static void main(String args[])  {

        // New keyword
        ClassLoaderBunny bunnyOne = new ClassLoaderBunny();
        ClassLoaderBunny fuckerBunny = new ClassLoaderBunny();
        bunnyOne.doSomething("creating using new");

        System.out.print("bunny one and fuckerbunny are same ? " + (bunnyOne == fuckerBunny) + bunnyOne.equals(fuckerBunny));

        //class.forName()
        try {
            ClassLoaderBunny bunnyTwo = (ClassLoaderBunny) forName("com.tuhin.javapreps.misc.ClassLoaderBunny").newInstance();
            bunnyTwo.doSomething("created by Class.forName");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            ex.getLocalizedMessage();
        }
        //Using clone
        try {
            ClassLoaderBunny bunnyThree = (ClassLoaderBunny) bunnyOne.clone();
            bunnyOne.doSomething("by clone");
            //System.out.print("does clonieg creates equal objects ? " + bunnyOne.equals(bunnyThree));
            System.out.print("does clonieg creates == objects ? " + (bunnyOne == bunnyThree));
        } catch (CloneNotSupportedException cnse) {
            cnse.getLocalizedMessage();
        }

        //using serialization
       // ObjectInputStream inputStream = new ObjectInputStream()




    }
}
