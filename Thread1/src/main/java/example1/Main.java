package example1;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> list3 = new ArrayList<>();

    Thread thread1 = addDateInListInThread(list1);
    Thread thread2 = addDateInListInThread(list2);
    Thread thread3 = addDateInListInThread(list3);


    thread1.start();
    thread2.start();
    thread3.start();

    try {
      thread1.join();
      thread2.join();
      thread3.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println(list1.size());
    System.out.println(list2.size());
    System.out.println(list3.size());



  }

  public static  Thread addDateInListInThread (List<Integer> list) {
    return new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000000; i++) {
          list.add(i);
        }
      }
    });
  }
}
