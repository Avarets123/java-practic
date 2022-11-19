package example4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    CountDownLatch downLatch = new CountDownLatch(10);

    for (int i = 0; i < 10; i++) {
      final  int index = i;
      executorService.execute(() -> {
        System.out.println("Start " + index);

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        System.out.println("Finish " + index);
        downLatch.countDown();

      });

    }

    try {
      downLatch.await();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("All thread are terminated");

  }





}
