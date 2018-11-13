package com.netcracker.myLinkedList;

public interface ILinkedList<E> extends Iterable<E>{
    /**
     * Insert element into the end of list.
     *
     * @param elem the element to insert
     *
     */
     void add(E elem);

    /**
     * Inserts the specified element into specified location.
     *
     * @param index the index of element to be inserted into the list
     * @param elem the element to insert
     *
     */
     void add(int index,E elem);

    /**
     * Removes all listed elements.
     */
    void clear();

    /**
     * Returns the value of the element at the specified index.
     *
     * @param index element number in list
     * @return value of element number (@param index)
     */
     E get(int index);

    /**
     * Searches element by value.
     *
     * @param elem the value of the element
     * @return index first element that has the specified value
     */
     int indexOf(E elem);

    /**
     * Removes element by specified index.
     *
     * @param index element number in list
     * @return the value of deleted element
     */
     E remove(int index);

    /**
     * Set value by specified element.
     *
     * @param index element number in list
     * @param elem the new value of element
     * @return (elem)
     */
     E set(int index, E elem);

    /**
     * Size of list
     *
     * @return the current list size
     */
     int size();

    /**
     * Convert to array.
     *
     * @return list of elements as an array
     */
     E[] toArray();
     String toString();

}
