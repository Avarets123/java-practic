package threadExercize;

import java.util.Random;

public class Main {

    private static int globRandom;
    private static boolean success = false;

    public static void main(String[] args) {
        int random = new Random().nextInt(1000000);
        globRandom = random;
        System.out.println(random);



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    while (!success) {
                        System.out.println(i);
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!success) {
                        int random = new Random().nextInt(1000000);
                        System.out.println(random);
                        if (globRandom == random) {
                            success = true;
                        }
                    }
                } catch (Exception e) {

                }
            }
        });


        thread1.start();
        thread2.start();

    }


}
