import java.util.Scanner;

public class Seconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        int minutes = seconds / 60;
        int hours = minutes / 60;
        int days = hours / 24;
        int months = days / 30;

        System.out.println("Seconds:" + seconds);
        System.out.println("Minutes:" + minutes);
        System.out.println("Hours:" + hours);
        System.out.println("Days:" + days);
        System.out.println("Months:" + months);

    }
}
