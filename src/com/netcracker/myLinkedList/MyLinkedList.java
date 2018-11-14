package com.netcracker.myLinkedList;

import java.lang.reflect.Array;
import java.util.*;

public class MyLinkedList<E> implements ILinkedList<E> {
    int size;
    Class classE;

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
    void rangeIndex(int index){
        if((index < 0) || (index >= size)){
            throw new IndexOutOfBoundsException("Incorrect index element in list:" + index );
        }
    }
    void positionIndex(int index){
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

    MyNode<E> getNode(int index){
        rangeIndex(index);
        MyNode<E> curr = first;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        return curr;
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
        return new MyListItr<E>(0);
    }

    public Iterator<E> iterator(int index)
    {
        return  new MyListItr<E>(index);
    }
    public MyListIterator<E> myIterator(int index){
        return  new MyListItr<E>(index);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof MyLinkedList))
            return false;
        MyLinkedList<E> list = (MyLinkedList<E>)obj;
        MyListIterator<E> it = list.myIterator(0);
        MyListIterator<E> it1 = myIterator(0);
        if(size!=list.size)
            return false;

        do {
            it.next();
            it1.next();
            if(!(it1.get()).equals(it.get())) {
                return false;
            }
        }while(it.hasNext());
        return true;
    }

    private class MyListItr<E> implements MyListIterator<E> {
         private int prevInd;
         private MyNode<E> next;
         private MyNode<E> returned;
         private int retInd;
         private int nextInd;
         int itSize;

        public MyListItr(int index) {
            rangeIndex(index);
            itSize = size;
            nextInd = index;
            prevInd = nextInd -1;
            next = (MyNode<E>) getNode(nextInd);
        }

        @Override
        public boolean hasNext() {
            if(nextInd < itSize)
                return true;
            return false;
        }

        @Override
        public boolean hasPrevious() {
            if(prevInd >= 0)
                return true;
            return false;
        }
        private void checkExternalChange(){
            if(itSize != size){
                throw new ConcurrentModificationException("Struct list has been changed outside of iterator");
            }
        }

        @Override
        public E next() {
            checkExternalChange();
            if(!hasNext()){
                throw new NoSuchElementException("The next element doesn't exist");
            }
            retInd = nextInd;
            nextInd++;
            prevInd++;
            returned = next;
            next = next.next;

           return returned.value;
        }

        @Override
        public int nextIndex() {
            if(!hasNext()){
                return -1;
            }
            return nextInd;
        }

        @Override
        public E previous() {
            checkExternalChange();
            if(!hasPrevious()){
                throw new NoSuchElementException("The previous element doesn't exist");
            }
            nextInd--;
            prevInd--;

            next = next.prev;
            retInd = nextInd;
            returned = next;

            return returned.value;
        }

        @Override
        public int previousIndex() {
            if(!hasPrevious()){
                return -1;
            }
            return prevInd;
        }

        @Override
        public void remove() {
            if(returned == null) {
                throw new NoSuchElementException("The element doesn't exist");
            }
            if(retInd == nextInd){
                nextInd++;
                next = next.next;
                itSize--;
            }
            MyLinkedList.this.remove(retInd);



        }

        @Override
        public void set(E e) {
            if(returned == null) {
                throw new NoSuchElementException("The element doesn't exist");
            }
           returned.value = e;

        }

        @Override
        public E get() {
            if(returned == null) {
                throw new NoSuchElementException("The element doesn't exist");
            }
            return returned.value;
        }

    }
    private static class MyNode<E> {
        E value;
        MyNode<E> prev;
        MyNode<E> next;

        public MyNode(E value, MyNode<E> prev, MyNode<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

    }
}

