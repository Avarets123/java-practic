package example3;

import java.util.Arrays;

public class Performance {

  public static int SIZE = 10_000_000;
  private static final int HALF = SIZE / 2;



  public static void withConcurrency() {

    long before = System.currentTimeMillis();

    float[] arrayFloats = new float[SIZE];
    Arrays.fill(arrayFloats, 1f);

    float[] firstHalf = new float[HALF];
    float[] secondHalf = new float[HALF];

    System.arraycopy(arrayFloats, 0, firstHalf, 0, HALF);
    System.arraycopy(arrayFloats, HALF, secondHalf, 0, HALF);

    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < firstHalf.length; i++) {
        firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
            Math.cos(0.4 + i / 2));
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < secondHalf.length; i++) {
        secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
            Math.cos(0.4 + i / 2));
      }
    });

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.arraycopy(firstHalf, 0, arrayFloats, 0, HALF);
    System.arraycopy(secondHalf, 0, arrayFloats, HALF, HALF);


    long after = System.currentTimeMillis();

    System.out.println("WithConcurrency: " + (after - before));


  }

  public static void withoutConcurrency() {

    long before = System.currentTimeMillis();

    float[] arrayFloats = new float[SIZE];
    Arrays.fill(arrayFloats, 1f);


    for (int i = 0; i < arrayFloats.length; i++) {
      arrayFloats[i] = (float) (arrayFloats[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
          Math.cos(0.4 + i / 2));
    }

    long after = System.currentTimeMillis();
    System.out.println("WithoutConcurrency: " + (after - before));

  }
}
