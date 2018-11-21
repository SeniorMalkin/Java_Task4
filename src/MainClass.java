import com.netcracker.myLinkedList.ILinkedList;
import com.netcracker.myLinkedList.MyLinkedList;
import com.netcracker.myLinkedList.MyListIterator;
import com.netcracker.testCollections.TestClass;

import java.util.*;

public class MainClass {
    private static void compareList(){
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

      compareAdd(list,list1);
      compareIndOf(list,list1);
      compareRemove(list,list1);
    }

    private static void compareAdd(ILinkedList<String> list,List<String> list1){
      long startTime ;
      long estimatedTime;
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
    }

    private static void compareIndOf(ILinkedList<String> list,List<String> list1){
      //Compare "indexOf"
      long startTime ;
      long estimatedTime;
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
    }

    private static void compareRemove(ILinkedList<String> list,List<String> list1){
      //Compare "remove"
      long startTime ;
      long estimatedTime;
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
      int count = 1200000;
      TestClass test = new TestClass(count);
      test.compareAddList("origg");
      test.compareAddParList("origg");
      test.compareRemoveList();
      test.compareAddSet("queen");
      test.compareRemoveSet("queen");
      test.compareContainsSet("queen");
      test.comparePutMap("asasfew","qwerty");
      test.compareGetMap("asasfew");
      test.compareRemoveMap("asasfew");

    }
}
