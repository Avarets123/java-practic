import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CarList cars = new CarArrayList();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car("GRANTA" + i, i));
        }

        for (Car car : cars) {

            System.out.println(car.getBrand() + " " + car.getNumber());
        }

    }
}
