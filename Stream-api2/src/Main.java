import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            randomNumbers.add(new Random().nextInt(100) + 100);
        }


        List<String> strings = randomNumbers.stream()
                .filter(num -> num % 5 == 0)
                .map(num -> Math.sqrt(num))
                .map(num -> "Корень: " + num)
                .toList();

        System.out.println(strings);

    }
}