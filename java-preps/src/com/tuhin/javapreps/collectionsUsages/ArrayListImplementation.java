package com.tuhin.javapreps.collectionsUsages;

import java.io.Serializable;
import java.util.*;

/**
 * Created by tuhinmandal on 15/07/16.
 * <p>
 * This is a practice[how to implement your own arraylist], how arraylist is implemented in java.
 * Reference @javadoc 1.8
 * <p>
 * Stream support is not added in this class.
 */
public class ArrayListImplementation<E> implements MyCollection<E>,

        Cloneable, RandomAccess, Serializable {

    /**
     * Default initial capacity.
     * java creators initialized this with 10, i have no fucking clue why
     */
    private static final int DEFAULT_CAPACITY = 10;

    int size;


    /**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer. Any
     * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     * will be expanded to DEFAULT_CAPACITY when the first element is added.
     */
    transient Object[] elementData; // non-private to simplify nested class access

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    public ArrayListImplementation(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }


    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrayListImplementation() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return elementData.length == 0;
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
        if(elementData.length - size <= 2) {
            incrementSize();
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean addAll(Collection<?> c) {
        return false;
    }

    @Override
    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Object obj = elementData[index];
            elementData[index] = null;
            int tmp = index;
            while(tmp < size){
                elementData[tmp] = elementData[tmp+1];
                elementData[tmp+1] = null;
                tmp++;
            }
            size--;
            return (E) obj;

        }
    }

    private void incrementSize() {
        elementData = Arrays.copyOf(elementData, elementData.length * 2);//incrementing size by 2
    }
}
