package com.tuhin.javapreps.collectionsUsages.setnmaps;

import java.util.Map;

/**
 * Created by tuhinmandal on 31/07/16.
 */
public class MyEntry<K, V> {

    K key;
    V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int multiplicationFactor = 11;
        if (key != null) {
            return prime * multiplicationFactor + key.hashCode();
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || this.getClass().getName() != o.getClass().getName()) {
            return false;
        }

        MyEntry e = (MyEntry) o;
        if (this.key == e.key) {
            return true;
        }
        return false;
    }

}
