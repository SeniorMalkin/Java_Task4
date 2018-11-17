import com.netcracker.myLinkedList.MyLinkedList;
import com.netcracker.myLinkedList.MyListIterator;
import com.netcracker.testCollections.TestClass;

import java.util.*;

public class MainClass {
    public static void compareList(){
      MyLinkedList<String> list = new MyLinkedList<>(String.class);
      LinkedList<String> list1 = new LinkedList<>();

      long startTime ;
      long estimatedTime;

      for(int i=0; i< 10001;i++){
        list.add("Queen");
        list1.add("Queen");
      }

      //Compare "add"
      System.out.println("Compare `add`: ");
      startTime = System.nanoTime();
      list.add("tea");
      estimatedTime = System.nanoTime() - startTime;
      System.out.println("My time: " + estimatedTime);
      startTime = System.nanoTime();
      list1.add("tea");
      estimatedTime = System.nanoTime() - startTime;
      System.out.println("Standart time: " + estimatedTime);
      System.out.println(" ");

      list.add("juice");
      list.add("water");
      list.add("whiskey");
      list1.add("juice");
      list1.add("water");
      list1.add("whiskey");

      //Compare "add" with parameters
      System.out.println("Compare `add` with parameters: ");
      startTime = System.nanoTime();
      list.add(7777,"beer");
      estimatedTime = System.nanoTime() - startTime;
      System.out.println("My time: " + estimatedTime);
      startTime = System.nanoTime();
      list1.add(7777,"beer");
      estimatedTime = System.nanoTime() - startTime;
      System.out.println("Standart time: " + estimatedTime);
      System.out.println(" ");

      //Compare "indexOf"
      System.out.println("Compare `indexOf`: ");
      startTime = System.nanoTime();
      int index = list.indexOf("water");
      estimatedTime = System.nanoTime() - startTime;
      System.out.println("My time: " + estimatedTime + "   index:" + index);
      startTime = System.nanoTime();
      index = list1.indexOf("water");
      estimatedTime = System.nanoTime() - startTime;
      System.out.println("Standart time: " + estimatedTime + "   index:" + index);
      System.out.println(" ");

      //Compare "remove"
      System.out.println("Compare `remove`: ");
      startTime = System.nanoTime();
      list.remove(5557);
      estimatedTime = System.nanoTime() - startTime;
      System.out.println("My time: " + estimatedTime);
      startTime = System.nanoTime();
      list1.remove(5557);
      estimatedTime = System.nanoTime() - startTime;
      System.out.println("Standart time: " + estimatedTime);
      System.out.println(" ");
      System.out.println("/////////////////////////////////////////////////////////");

    }

    public static void main(String[] args) {

      compareList();
      int count = 200000;
      TestClass<String> test = new TestClass<>(1200000);
      LinkedList<String> linkedList = new LinkedList<>();
      ArrayList<String> arrayList = new ArrayList<>();
      test.compareList(linkedList,arrayList,"default","origg");

      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      HashSet<String> hashSet = new HashSet<>();
      LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
      TreeSet<String> treeSet = new TreeSet<>();
      String charcters = "0qwe1mnb2rty3vcx4uio5zlk6pas7jhg8df9";
      char[] str = new char[10];
      Random random = new Random();
      for(int i=0;i<=count;i++){
          for(int j=0;j<10;j++){
              str[j] = charcters.charAt(random.nextInt(charcters.length()));
          }
          hashSet.add( new String(str));
          linkedHashSet.add( new String(str));
          treeSet.add( new String(str));
      }
      test.compareSet(hashSet,linkedHashSet,treeSet,"queen");

      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      HashMap<String,String> hashMap =  new HashMap<>();
      LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
      TreeMap<String,String> treeMap = new TreeMap<>();
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

      test.compareMap(hashMap,linkedHashMap,treeMap,"asasfew","qwerty");

    }
}
