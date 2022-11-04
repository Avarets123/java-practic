package example2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrimesNumberGenerator {

    public void generateNumbers(String filename, int from, int to) {

        Thread newThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ". Началась запись файла: " + filename);
            for (int i = from; i < to; i++) {
                if (isPrimes(i)) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                        writer.write(i + "\n");
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            }

            System.out.println(Thread.currentThread().getName() + ". Закончилась запись файла: " + filename);
        });

        newThread.start();


    }

    private boolean isPrimes(int number) {

        if (number == 0 || number == 1) {
            throw new IllegalArgumentException("Numbers is incorrect");
        }

        if (number == 2 || number == 3) {
            return true;
        }


        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;


    }
}
