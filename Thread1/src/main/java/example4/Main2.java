package example4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(3);
    CountDownLatch downLatch = new CountDownLatch(3);
    long start = System.currentTimeMillis();

    executorService.execute(() -> {
      int allSum = 0;
      for (int i = 0; i < 1_000_000; i++) {
        if (i % 2 == 0) {
          allSum += i;
        }
      }
      downLatch.countDown();
      System.out.println("All sum events " + allSum);
    });

    executorService.execute(() -> {
      int allSum = 0;
      for (int i = 0; i < 1_000_000; i++) {
        if (i % 7 == 0) {
          allSum += i;

        }
      }
      downLatch.countDown();
      System.out.println("All sum numbers division seven" + allSum);
    });

    executorService.execute(() -> {
      List<Integer> numbers = new ArrayList<>();
      for (int i = 0; i < 1000; i++) {
        int random = new Random().nextInt(1000);
        numbers.add(random);
      }


      int countEvent = 0;
      for (int count : numbers) {
        if (count % 2 == 0) {
          ++countEvent;
        }
      }

      downLatch.countDown();
      System.out.println("Events count: " + countEvent);
    });

    executorService.shutdown();
    try {
      downLatch.await();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    long finish = System.currentTimeMillis();

    System.out.println("Finish on milliseconds: " + (finish - start));


  }
}
