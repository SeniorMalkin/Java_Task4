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
        System.out.println(" ");

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
        System.out.println(" ");


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
        System.out.println(" ");
        System.out.println("/////////////////////////////////////////////////////////");

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
        System.out.println(" ");



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
        System.out.println(" ");


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
        System.out.println(" ");
        System.out.println("///////////////////////////////////////////////////////");

    }

    public void compareMap(Map<String,E> hashMap, Map<String,E> linkHashMap,Map<String,E> treeMap,String key, E elem){

        //Compare "put"
        System.out.println("Compare `put`: ");
        startTime = System.nanoTime();
        hashMap.put(key,elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        linkHashMap.put(key,elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        treeMap.put(key,elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Set time: " + estimatedTime);
        System.out.println(" ");



        //Compare "get"
        System.out.println("Compare `get`: ");
        startTime = System.nanoTime();
        hashMap.get(key);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        linkHashMap.get(key);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        treeMap.get(key);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Map time: " + estimatedTime);
        System.out.println(" ");


        //Compare "remove"
        System.out.println("Compare `remove`: ");
        startTime = System.nanoTime();
        hashMap.remove(key);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        linkHashMap.remove(key);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        treeMap.remove(key);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Map time: " + estimatedTime);
        System.out.println(" ");
        System.out.println("///////////////////////////////////////////////////////////////////// ");

    }
}
