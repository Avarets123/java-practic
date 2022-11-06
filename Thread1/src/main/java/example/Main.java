package example;

public class Main {

  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 50; i++) {
          System.out.println("Have a nice day");
        }
      }
    });



    thread.start();
    System.out.println("Start");
    System.out.println("Finish");
  }
}
