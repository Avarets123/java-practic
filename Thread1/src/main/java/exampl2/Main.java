package exampl2;

public class Main {
  public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
      System.out.println("1");
    });
    Thread thread2 = new Thread(() -> {
      try {
        thread1.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("2");
    });
    Thread thread3 = new Thread(() -> {
      try {
        thread2.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("3");
    });


    thread1.start();
    thread2.start();
    thread3.start();

  }


}
