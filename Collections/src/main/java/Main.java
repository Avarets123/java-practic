import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Car> cars = new TreeSet<>(Comparator.comparing(Car::getBrand));

        Set<Integer> numbers = new TreeSet<>((int1, int2) -> -int1.compareTo(int2));

        for (int i = 0; i < 100; i++) {
            cars.add(new Car("Brand" + i, i));
            numbers.add((int) (Math.random() * 10));

        }

        for (int car : numbers) {
            System.out.println(car);
        }

    }
}
