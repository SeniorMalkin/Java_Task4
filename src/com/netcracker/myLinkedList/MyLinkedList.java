package com.netcracker.myLinkedList;

import com.netcracker.myLinkedList.ILinkedList;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.function.Consumer;

public class MyLinkedList<E> implements ILinkedList<E> {
    private int size;
    private Class classE;

    private MyNode<E> first;

    private MyNode<E> last;

    public MyLinkedList(Class myclass) {
        classE = myclass;
    }

    @Override
    public void add(E elem) {
        MyNode<E> node;
        if(size!=0){
            node = new MyNode<>(elem,last,null);
            last.next = node;

        }
        else{
            node = new MyNode<>(elem,null,null);
            first = node;
        }
        size++;
        last = node;
    }

    @Override
    public void add(int index, E elem) {
        positionIndex(index);
        MyNode<E> curr = first;
        int i =index;
        while(i!=0){
            curr = curr.next;
            i--;
        }

        MyNode<E> node;
        if(index == 0) {
            node = new MyNode<>(elem, null, first);
            first.prev = node;
            first = node;
        }
        else{
            if(index == size) {
                node = new MyNode<>(elem, last, null);
                last.next = node;
                last = node;
            }
            else{
                MyNode<E> prev = curr.prev;
                curr.prev = new MyNode<>(elem,prev,curr);
                prev.next = curr.prev;
            }

        }
        size++;
    }
    private void rangeIndex(int index){
        if((index < 0) || (index >= size)){
            throw new IndexOutOfBoundsException("Incorrect index element in list:" + index );
        }
    }
    private void positionIndex(int index){
        if((index < 0) || (index > size)){
            throw new IndexOutOfBoundsException("Incorrect position index element in list:" + index );
        }
    }

    @Override
    public void clear() {
        for(MyNode<E> node = first; node!=null;){
            MyNode<E> next = node.next;
            node.next = null;
            node.value = null;
            node.prev = null;
            node = next;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        rangeIndex(index);
        MyNode<E> curr = first;
        while(index !=0) {
            curr = curr.next;
            index--;
        }
        return curr.value;
    }

    @Override
    public int indexOf(E elem) {

        int index = 0;
        MyNode<E> curr = first;
        while(index !=size) {
            if(curr.value == elem){
                return index;
            }
            else {
                curr = curr.next;
                index++;
            }
        }

        return -1;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public E remove(int index) {
        rangeIndex(index);
        MyNode<E> curr = first;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        MyNode<E> prev;
        MyNode<E> next;


        if(index == 0){
            first = curr.next;
        }
        else{
            if(index == size-1){
                last = curr.prev;
            }
            else{
                prev = curr.prev;
                next = curr.next;
                prev.next = next;
                next.prev = prev;
            }
        }

        E result = curr.value;
        curr.value = null;
        curr.prev = null;
        curr.next = null;

        size--;
        return result;
    }

    @Override
    public E set(int index, E elem) {
        rangeIndex(index);
        MyNode<E> curr = first;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        curr.value = elem;
        return curr.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        E[] arr = (E[]) Array.newInstance(classE,size);
        MyNode<E> curr = first;
        for(int i=0;i<size;i++){
            arr[i] = curr.value;
            curr=curr.next;
        }
        return arr;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListItr<E>(0,this);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

