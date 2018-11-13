import com.netcracker.myLinkedList.MyLinkedList;

public class Main {
    public static void main(String[] args) {
      MyLinkedList<String> list = new MyLinkedList<>(String.class);
      list.add("ab");
      list.add("cc");
      list.add("dc");
      list.add("aa");
      System.out.println(list.indexOf("dc"));
      //System.out.println(list.remove(6));
      list.set(2,"zugaza");
      list.add(0,"pufsi");
      list.add(5,"end");
      list.add(3,"pufsi");
      String[] arr = list.toArray();
      //list.remove(7);
      list.remove(6);
      list.remove(3);
      list.remove(0);
      arr = list.toArray();


    }
}
