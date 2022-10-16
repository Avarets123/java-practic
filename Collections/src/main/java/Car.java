public class Car {
    private String brand;
    private int number;

    public Car(String brand, int number) {
        this.brand = brand;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return car.brand.equals(this.brand) && car.number == this.number;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.brand.hashCode() + this.number;
    }

//    @Override
//    public int compareTo(Car car) {
//        return this.brand.compareTo(car.brand);
//    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", number=" + number +
                '}';
    }
}
