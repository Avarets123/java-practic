package example;

public class Main {

  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 50; i++) {
          if (Thread.currentThread().isInterrupted()) {
            break;
          }
          System.out.println("Have a nice day");
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    });

    thread.start();
    System.out.println("Start");
    for (int i = 0; i < 50; i++) {
      System.out.println("M");
    }
    System.out.println("Finish");
//    thread.stop();
    thread.interrupt();
  }

}
