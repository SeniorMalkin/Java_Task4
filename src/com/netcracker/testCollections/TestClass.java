package com.netcracker.testCollections;

import java.util.*;

public class TestClass{
    private int count;
    private long startTime;
    private long estimatedTime;
    private LinkedList<String> linkedList;
    private ArrayList<String> arrayList;
    private HashSet<String> hashSet;
    private LinkedHashSet<String> linkedHashSet;
    private TreeSet<String> treeSet;
    private HashMap<String,String> hashMap;
    private LinkedHashMap<String,String> linkedHashMap;
    private TreeMap<String,String> treeMap;

    public TestClass(int count) {
        this.count = count;
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();

        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();
        String charcters = "0qwe1mnb2rty3vcx4uio5zlk6pas7jhg8df9";
        char[] str = new char[10];
        Random random = new Random();
        for(int i=0;i<=count;i++){
            for(int j=0;j<10;j++){
                str[j] = charcters.charAt(random.nextInt(charcters.length()));
            }
            String def = new String(str);
            linkedList.add(def);
            arrayList.add(def);

            hashSet.add(def);
            linkedHashSet.add(def);
            treeSet.add(def);
        }

        hashMap =  new HashMap<>();
        linkedHashMap = new LinkedHashMap<>();
         treeMap = new TreeMap<>();
        char[] str1 = new char[10];
        for(int i=0;i<=count;i++){
            for(int j=0;j<10;j++){
                str[j] = charcters.charAt(random.nextInt(charcters.length()));
            }
            for(int k=0;k<10;k++){
                str1[k] = charcters.charAt(random.nextInt(charcters.length()));
            }
            hashMap.put(new String(str),new String(str1));
            linkedHashMap.put(new String(str),new String(str1));
            treeMap.put(new String(str),new String(str1));
        }
    }

    public void compareAddList(String elem){

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

    }

    public void compareAddParList(String elem){
        Random random = new Random();
        //Compare "add" with parameters
        System.out.println("Compare `insert`: ");
        startTime = System.nanoTime();
        linkedList.add(random.nextInt(this.count),elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked List time: " + estimatedTime);
        startTime = System.nanoTime();
        arrayList.add(random.nextInt(this.count),elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array List time: " + estimatedTime);
        System.out.println(" ");
    }
    public void compareRemoveList(){
        Random random = new Random();
        //Compare "remove"
        System.out.println("Compare `remove`: ");
        startTime = System.nanoTime();
        arrayList.remove(random.nextInt(this.count));
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array List time: " + estimatedTime);
        startTime = System.nanoTime();
        linkedList.remove(random.nextInt(this.count));
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked List time: " + estimatedTime);
        System.out.println(" ");
        System.out.println("/////////////////////////////////////////////////////////");

    }

    public void compareAddSet(String elem ){
        //Compare "add"
        System.out.println("Compare `add`: ");
        startTime = System.nanoTime();
        hashSet.add(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        linkedHashSet.add(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        treeSet.add(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Set time: " + estimatedTime);
        System.out.println(" ");
    }

    public void compareRemoveSet(String elem ) {
        //Compare "remove"
        System.out.println("Compare `remove`: ");
        startTime = System.nanoTime();
        hashSet.remove(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        linkedHashSet.remove(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        treeSet.remove(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Set time: " + estimatedTime);
        System.out.println(" ");
    }

    public void compareContainsSet(String elem ){
        //Compare "contains"
        System.out.println("Compare `contains`: ");
        startTime = System.nanoTime();
        hashSet.contains(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        linkedHashSet.contains(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Set time: " + estimatedTime);
        startTime = System.nanoTime();
        treeSet.contains(elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Set time: " + estimatedTime);
        System.out.println(" ");
        System.out.println("///////////////////////////////////////////////////////");
    }

    public void comparePutMap(String key, String elem){
        //Compare "put"
        System.out.println("Compare `put`: ");
        startTime = System.nanoTime();
        hashMap.put(key,elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        linkedHashMap.put(key,elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        treeMap.put(key,elem);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Set time: " + estimatedTime);
        System.out.println(" ");
    }

    public void compareGetMap(String key){
        //Compare "get"
        System.out.println("Compare `get`: ");
        startTime = System.nanoTime();
        hashMap.get(key);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        linkedHashMap.get(key);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Linked Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        treeMap.get(key);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tree Map time: " + estimatedTime);
        System.out.println(" ");
    }

    public void compareRemoveMap(String key){
        //Compare "remove"
        System.out.println("Compare `remove`: ");
        startTime = System.nanoTime();
        hashMap.remove(key);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Hash Map time: " + estimatedTime);
        startTime = System.nanoTime();
        linkedHashMap.remove(key);
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
