import java.util.Scanner;

public class FromTo {
    public static void main(String[] args) {
        int from, to;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter from count");
        from = scanner.nextInt();

        System.out.println("Enter to count");
        to = scanner.nextInt();

        for (int i = from; i < to; i++) {
            System.out.println(from);
            from++;
        }


    }
}
