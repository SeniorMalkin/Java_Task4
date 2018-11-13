package com.netcracker.myLinkedList;

public class MyNode<E> {
    E value;
    MyNode<E> prev;
    MyNode<E> next;

    public MyNode(E value, MyNode<E> prev, MyNode<E> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

}
