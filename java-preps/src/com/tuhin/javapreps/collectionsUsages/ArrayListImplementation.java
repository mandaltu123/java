package com.tuhin.javapreps.collectionsUsages;

import java.io.Serializable;
import java.util.*;

/**
 * Created by tuhinmandal on 15/07/16.
 */
public class ArrayListImplementation<E> implements MyCollection<E>,

Cloneable, RandomAccess, Serializable {

    /**
     * Default initial capacity.
     * java creators initialized this with 10, i have no fucking clue why
     */
    private static final int DEFAULT_CAPACITY = 10;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean addAll(Collection<?> c) {
        return false;
    }
}
