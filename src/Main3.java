import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        int[] numbers = {1, 3, 6, 8, 11, 13, 15, 22, 26};
        int findNumber = new Scanner(System.in).nextInt();

        int left, right, middle;
        boolean exists = false;

        left = 0;
        right = numbers.length - 1;
        middle = left + (right - left) / 2;

        while (left <= right) {
            if (findNumber < numbers[middle]) {
                right = middle - 1;
            } else if (findNumber > numbers[middle]) {
                left = middle + 1;
            } else {
                exists = true;
                break;
            }

            middle = left + (right - left) / 2;
        }

        if (exists) {
            System.out.print("Число массиве есть");
        }

        if (!exists) {
            System.out.print("Число в массиве нет");
        }
    }
}
