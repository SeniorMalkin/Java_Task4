package com.netcracker.myLinkedList;

import java.util.Iterator;

public interface MyListIterator<E> extends Iterator<E> {

    /**
     *
     * @return true if exists next element
     */
    boolean hasNext();

    /**
     *
     * @return true if exists previous element
     */
    boolean hasPrevious();

    /**
     *
     *@return the next element in the iteration.
     */
    E next();

    /**
     *
     * @return the next index of the element in the iteration
     */
    int nextIndex();

    /**
     *
     * @return the previous element in the iteration.
     */
    E previous();

    /**
     *
     * @return the previous index of the element in the iteration
     */
    int previousIndex();

    /**
     * Removes from the current collection the last element returned
     * by this iterator.
     */
    void remove();

    /**
     *
     * Set value for element returned
     * by this iterator.
     */
    void set(E e);

    /**
     *
     * @return value for element returned
     * by this iterator.
     */
    E get();

}
