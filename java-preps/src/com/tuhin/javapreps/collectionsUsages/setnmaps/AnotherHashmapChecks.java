package com.tuhin.javapreps.collectionsUsages.setnmaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tuhinmandal on 30/07/16.
 */
public class AnotherHashmapChecks {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, "ola:" + i);
        }
        map.put(null, "tuhin"); // this is allowed one time

        /**
         * hashMap allows one null key
         *
         * {0=ola:0, null=tuhin, 1=ola:1, 2=ola:2, 3=ola:3, 4=ola:4, 5=ola:5, 6=ola:6, 7=ola:7, 8=ola:8, 9=ola:9}
         Exception in thread "main" java.lang.NullPointerException
         at com.tuhin.javapreps.collectionsUsages.setnmaps.AnotherHashmapChecks.main(AnotherHashmapChecks.java:28)
         at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
         at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
         at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         at java.lang.reflect.Method.invoke(Method.java:497)
         at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
         */


        System.out.println(map);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":::" + entry.getValue());
        }


        for (Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, String> entry = iterator.next();
            if (entry.getKey() == 3) {
                iterator.remove();
            }
        }
        System.out.println("Map after removing: " + map);

    }
}


