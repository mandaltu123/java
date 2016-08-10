package com.tuhin.javapreps.collectionsUsages.setnmaps;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tuhinmandal on 31/07/16.
 * <p>
 * This is very basic hash map implementation with entry and hashFunction() both are very basic.
 * For actual implementation refer java hashmap
 * This is in reference : http://stackoverflow.com/questions/4072127/custom-hashmap-implementation
 * 
 * Collision rsolution is not been ahndled here. I will improve this implementation some time later
 * 
 */
public class MyHashMap<K, V> {

    /**
     * Saying if the underneath bucket is full of its 3/4th we will resize the bucket
     */
    private float loadFactor = 0.75f;

    /**
     * Starting with initial bucket size of 100
     */
    private int capacity = 100;

    private int size = 0;

    /**
     * Creating bucket with initial capacity which is 100
     */
    private MyEntry<K, V>[] bucket = new MyEntry[capacity];


    /**
     * very basic hash function that returns location of an element in the bucket
     *
     * @param hashCode passed hashCode of a key for which we are looking for the
     *                 location in the bucket
     * @return returns location
     */
    private int hashFunction(int hashCode) {
        int location = hashCode % capacity;
        return location;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    public V get(K key) {
        // since hash map lets entering one null key
        if (key == null) {
            MyEntry<K, V> entry = null;
            try {
                entry = bucket[0];
                if (entry != null) {
                    return entry.getValue();
                }
            } catch (NullPointerException e) {
            }
        } else {
            // other keys
            MyEntry<K, V> entry = null;
            int location = hashFunction(key.hashCode());
            entry = bucket[location];
            if (entry != null && entry.getKey() == key) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V put(K key, V value) {

        // hashMap allows one null key insertion, we need to accommodate that
        if (null == key) {
            return isertNullKey(key, value);
        } else {
            // inserting other keys
            int location = hashFunction(key.hashCode());
            if (location / capacity >= loadFactor) {
                resize();
            }
            MyEntry<K, V> entry = null;
            entry = bucket[location];
            //if a value exists with same key, we are not overriding that value, just returning the same,
            //in hashMap they actually override the new value
            if (entry != null && key == entry.getKey()) {
                return entry.getValue();
            } else {
                MyEntry ent = new MyEntry();
                ent.setKey(key);
                ent.setValue(value);
                bucket[location] = ent;
                return value;
            }

        }
    }

    private void resize() {
        //well I am not doing it now. refer hashMap implementation
    }

    private V isertNullKey(K key, V value) {
        // this is simple, reserve 0th position for null.
        //check already a value exists against null key, if not insert one
        return value;
    }

    /**
     * map.keySet() returns set of keys
     *
     * @return set of keys
     */
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        if (bucket.length != 0) {
            for (int i = 0; i < bucket.length; i++) {
                keys.add(bucket[i].getKey());
            }
        }
        return keys;
    }
}
