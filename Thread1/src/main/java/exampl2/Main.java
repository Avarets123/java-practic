package exampl2;

public class Main {

  public static void main(String[] args) {
    long beforeMain = System.currentTimeMillis();

    Thread thread1 = new Thread(() -> {
      long before = System.currentTimeMillis();
      System.out.println("first");
      long after = System.currentTimeMillis();
      System.out.println(after - before);
    });
    Thread thread2 = new Thread(() -> {
      try {
        thread1.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      long before = System.currentTimeMillis();
      System.out.println("second");
      long after = System.currentTimeMillis();
      System.out.println(after - before);
    });
    Thread thread3 = new Thread(() -> {
      try {
        thread2.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      long before = System.currentTimeMillis();
      System.out.println("three");
      long after = System.currentTimeMillis();
      System.out.println(after - before);
    });

    thread1.start();
    thread2.start();
    thread3.start();

    long afterMain = System.currentTimeMillis();

    System.out.println("TimeProcess: " + (afterMain - beforeMain));

  }

}
