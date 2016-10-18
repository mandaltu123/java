package com.tuhin.javapreps.misc;

/**
 * Created by tuhinmandal on 16/07/16.
 */
public class MyClassLoader {
    public static void main(String args[]) {
        try {
            /**
             * This is not the way class to be loaded.
             * When we say ClassLoaderBunny bunny = new ClassLoaderBunny();
             * this causes a call as following to load the class . The following
             * thing actually happens.
             */
            MyClassLoader.class.getClassLoader().loadClass("ClassLoaderBunny");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
