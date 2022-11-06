package ATC;

public class Main {

  public static void main(String[] args) {

    ATC atc = new ATC();

    Thread thread1 = new Thread(() -> {
      atc.getMoney("Gasan", 40000);
    });

    Thread thread2 = new Thread(() -> {
//      try {
//        thread1.join();
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
      atc.getMoney("Gusein", 40000);
    });

    Thread thread3 = new Thread(() -> {
//      try {
//        thread2.join();
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
      atc.getMoney("Osman", 40000);
    });


    thread1.start();
    thread2.start();
    thread3.start();

    System.out.println(atc.getAmount());

  }

}
