package com.netcracker.testCollections;

import java.util.*;

public class TestClass<E> {
    int count;
    long startTime;
    long estimatedTime;

    public TestClass(int count) {
        this.count = count;
    }

    public void compareList(List<E> linkedList, List<E> arrayList,E def,E elem){

        for(int i=0;i<=count;i++){
            linkedList.add(def);
            arrayList.add(def);
        }
        //Compare "add"
        System.out.println("Compare `add`: ");
        startTime = System.nanoTime();
        linkedList.add(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked List time: " + estimatedTime);
        startTime = System.nanoTime();
        arrayList.add(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array List time: " + estimatedTime);

        //Compare "add" with parameters
        System.out.println("Compare `insert`: ");
        startTime = System.nanoTime();
        linkedList.add(357777,elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked List time: " + estimatedTime);
        startTime = System.nanoTime();
        arrayList.add(357777,elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array List time: " + estimatedTime);


        //Compare "remove"
        System.out.println("Compare `remove`: ");
        startTime = System.nanoTime();
        arrayList.remove(355557);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array List time: " + estimatedTime);
        startTime = System.nanoTime();
        linkedList.remove(355557);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked List time: " + estimatedTime);

    }

    public void compareSet(Set<E> hashSet, Set<E> linkHashSet,Set<E> treeSet,E elem ){
        //Compare "add"
        System.out.println("Compare `add`: ");
        startTime = System.nanoTime();
        hashSet.add(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        linkHashSet.add(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        treeSet.add(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Set time: " + estimatedTime);



        //Compare "remove"
        System.out.println("Compare `remove`: ");
        startTime = System.nanoTime();
        hashSet.remove(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        linkHashSet.remove(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        treeSet.remove(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Set time: " + estimatedTime);


        //Compare "contains"
        System.out.println("Compare `contains`: ");
        startTime = System.nanoTime();
        hashSet.contains(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        linkHashSet.contains(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        treeSet.contains(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Set time: " + estimatedTime);


    }
}
