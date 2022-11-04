package example2;

import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        PrimesNumberGenerator generator = new PrimesNumberGenerator();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            generator.generateNumbers("generated//" + UUID.randomUUID().toString(), from, to);
        }

    }
}
