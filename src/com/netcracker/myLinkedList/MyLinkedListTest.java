package com.netcracker.myLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    private MyLinkedList<String> actual;
    private MyLinkedList<String> expected;
    private MyListIterator<String> listIterator;

    @Before
    public void setUp() throws Exception {
        expected = new MyLinkedList<>(String.class);
        actual = new MyLinkedList<>(String.class);
        actual.add("water");
        actual.add("tea");
        actual.add("coffee");
        actual.add("whiskey");
        actual.add("beer");
        actual.add("milk");
    }


    @Test
    public void addToMiddle() {
        expected.add("water");
        expected.add("tea");
        expected.add("coffee");
        expected.add("juice"); ///new element with index 3
        expected.add("whiskey");
        expected.add("beer");
        expected.add("milk");
        actual.add(3,"juice");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addToTop() {
        expected.add("juice"); ///new element with index 0
        expected.add("water");
        expected.add("tea");
        expected.add("coffee");
        expected.add("whiskey");
        expected.add("beer");
        expected.add("milk");
        actual.add(0,"juice");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addToEnd() {
        expected.add("water");
        expected.add("tea");
        expected.add("coffee");
        expected.add("whiskey");
        expected.add("beer");
        expected.add("milk");
        expected.add("juice"); ///new element with index 6
        actual.add(actual.size(),"juice");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void clear() {
        actual.clear();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void get() {
        Assert.assertEquals("tea",actual.get(1));
        Assert.assertEquals("whiskey",actual.get(3));
        Assert.assertEquals("milk",actual.get(5));
    }

    @Test
    public void indexOf() {
        actual.add("whiskey");
        actual.add("beer");
        actual.add("milk");
        Assert.assertEquals(2,actual.indexOf("coffee"));
        Assert.assertEquals(5,actual.indexOf("milk"));
    }

    @Test
    public void remove() {
        expected.add("water");
        expected.add("coffee");
        expected.add("whiskey");
        expected.add("beer");
        actual.remove(5);
        actual.remove(1);
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void set() {
        for(int i=0;i<6;i++) {
            expected.add("aaa");
        }

        MyListIterator<String> it = actual.myIterator(0);

        do {
            it.next();
            it.set("aaa");
        } while(it.hasNext());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void size() {
        for(int i=0;i<6;i++) {
            expected.add("aaa");
        }
        Assert.assertEquals(expected.size(),actual.size());
    }

    @Test
    public void toArray() {
        String[] arr = {"water" ,"tea" ,"coffee" ,"whiskey" ,"beer" ,"milk"};
        String[] arr1 = actual.toArray();
        Assert.assertArrayEquals(arr,arr1);
    }

    @Test
    public void hasNextIt() {
        listIterator = expected.myIterator(0);
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextIt() {
        listIterator = expected.myIterator(0);
        listIterator.next();
    }

    @Test
    public void hasNextIt1() {
        expected.add("tea");
        listIterator = expected.myIterator(0);
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void nextIt1() {
        expected.add("tea");
        listIterator = expected.myIterator(0);
        listIterator.next();
        Assert.assertEquals("tea",listIterator.get());
    }

    @Test
    public void hasPrevIt(){
        listIterator = expected.myIterator(0);
        Assert.assertFalse(listIterator.hasPrevious());
    }

    @Test(expected = NoSuchElementException.class)
    public void prevIt() {
        listIterator = expected.myIterator(0);
        listIterator.previous();
    }

    @Test
    public void hasPrevIt1(){
        expected.add("tea");
        listIterator = expected.myIterator(0);
        listIterator.next();
        Assert.assertTrue(listIterator.hasPrevious());
    }

    @Test
    public void prevIt1() {
        expected.add("tea");
        listIterator = expected.myIterator(0);
        listIterator.next();
        listIterator.previous();
        Assert.assertEquals("tea",listIterator.get());
    }

    @Test
    public void removeIt(){
        expected.add("tea");
        listIterator = expected.myIterator(0);
        listIterator.next();
        listIterator.remove();
        Assert.assertEquals(0,expected.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void removeIt1(){
        expected.add("tea");
        listIterator = expected.myIterator(0);
        listIterator.next();
        listIterator.remove();
        listIterator.remove();
    }

    @Test
    public void passList(){
        expected.add("water");
        expected.add("tea");
        expected.add("coffee");
        expected.add("whiskey");
        expected.add("beer");
        expected.add("milk");
        String[] arr = {"water" ,"tea" ,"coffee" ,"whiskey" ,"beer" ,"milk"};
        LinkedList<String> alist = new LinkedList<>();
        for(String elem : arr){
            alist.add(elem);
        }

        LinkedList<String> list = new LinkedList<>();
        for(String elem : expected){
            list.add(elem);
        }
        Assert.assertEquals(list,alist);
    }

}