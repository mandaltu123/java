package com.tuhin.javapreps.collectionsUsages;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by tuhinmandal on 15/07/16.
 * <p/>
 * Created in reference of java 7 collection interface.
 * In java 8 StreamSupport has been added to this interface
 */
public interface MyList<E> extends Iterable<E> {

    /**
     * size of collection
     *
     * @return returns number of elements in the collection
     */
    int size();

    /**
     * boolean. returns true if no element added to the collection
     * else returns false
     *
     * @return returns true if no element , else returns false
     */
    boolean isEmpty();

    /**
     * searches the given element in the collection.
     * if exists, returns true else return false
     *
     * @param o element to be searched in the collection
     * @return true if an element found else false
     */
    boolean contains(Object o);

    /**
     * returns an iterator over the elements in this collection. however
     * there is no guarantee in the order in which the elements are returned.
     *
     * @return an <tt>Iterator</tt> over the elements in this collection
     */
    Iterator<E> iterator();

    /**
     * Returns all the elements in the collection in an array. it returns the
     * elements in order if implementation collection class maintains any
     * order.
     *
     * @return returns array of elements in the collection
     */
    Object[] toArray();

    /**
     * adds an element into the collection
     *
     * @param e element to be added to the collection
     * @return true if the element has been added else returns false
     */
    boolean add(E e);

    /**
     * @param c source collection whose
     * @return
     */
    boolean addAll(Collection<?> c);

    /**
     * Removes element from the list of a given index
     * @param index
     * @return object if that object exists at the index position else returns null
     */
    E remove(int index);

}
