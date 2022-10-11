public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("BMW", 116);
        Car car2 = new Car("BMW", 116);
        Car car3 = new Car("KALINA", 116);
        Car car4 = new Car("GRANTA", 116);

        System.out.println(car1.equals(car2));
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());
        System.out.println(car4.hashCode());

    }
}
