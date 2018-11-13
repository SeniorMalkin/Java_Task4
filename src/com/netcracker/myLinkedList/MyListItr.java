package com.netcracker.myLinkedList;

import com.netcracker.myLinkedList.MyLinkedList;
import com.netcracker.myLinkedList.MyListIterator;

public class MyListItr<E> implements MyListIterator<E> {
    int prevInd;
    MyNode<E> curr;
    int nextInd;

    public MyListItr(int index, MyLinkedList<E> list) {

    }

    @Override
    public boolean hasNext() {

        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public E previous() {
        return null;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(E e) {

    }

    @Override
    public E get() {
        return null;
    }

}