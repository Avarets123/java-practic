import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    private CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Brand new", 5);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedReturnFalse() {
        Car car = new Car("Brand new", 5);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBeZero() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void addCarToMiddleCollection() {
        Car car = new Car("Lada", 116);
        carList.add(car, 6);
        Car indexCar = carList.get(6);
        assertEquals("Lada", indexCar.getBrand());
    }

    @Test
    public void checkCarInCollections() {
        Car car = new Car("Priora", 512);
        carList.add(car);
        assertTrue(carList.contains(car));
        assertFalse(carList.contains(new Car("BMW", 116)));
    }
}