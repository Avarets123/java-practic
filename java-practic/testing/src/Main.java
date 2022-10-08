import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number, lastDigit, digitSum;

        digitSum = 0;

        number = scanner.nextInt();

        while (number != 0) {

            lastDigit = number % 10;
            digitSum += lastDigit;
            number /= 10;
        }

        System.out.println("result " + digitSum);

    }
}

