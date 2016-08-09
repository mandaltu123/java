package com.tuhin.javapreps.misc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tuhinmandal on 30/07/16.
 */
public class HashMapTest {


    /**
     * bellow program is to demonstrate how concurrent modification exception occurs.
     *
     *
     *
     * Exception in thread "main" java.util.ConcurrentModificationException
     at java.util.HashMap$HashIterator.nextNode(HashMap.java:1429)
     at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
     at com.tuhin.javapreps.misc.HashMapTest.main(HashMapTest.java:21)
     at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     at java.lang.reflect.Method.invoke(Method.java:497)
     at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)

     * @param args
     */
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "angus");
        map.put(2, "anna");
        map.entrySet();
        Iterator<Integer> it = map.keySet().iterator();
        int counter = 100;
        while (it.hasNext() && counter < 110) {
            Integer value = it.next();
            map.put(counter, "test:"+counter);
            counter++;
        }

    System.out.println(map);
    }
}
