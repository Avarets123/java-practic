import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarSetTest {

    private CarSet carSet;

    @BeforeEach
    void setUp() {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }


    @Test
    public void testingAddElementsInList() {
        Car car = new Car("Lada", 512);
        assertTrue(carSet.add(car));
        assertEquals(101, carSet.size());
        Car car2 = new Car("Lada", 512);
        assertFalse(carSet.add(car2));
        assertEquals(101, carSet.size());
    }

    @Test
    public void removeElementsFromList() {
        Car car = new Car("Priora", 324);
        assertTrue(carSet.add(car));
        assertEquals(101, carSet.size());
        assertTrue(carSet.remove(car));
        assertEquals(100, carSet.size());
        Car car1 = new Car("Toyota corova", 342);
        assertFalse(carSet.remove(car1));
        assertEquals(100, carSet.size());
    }

    @Test
    public void clearList() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void checkItemInCollection() {
        Car car = new Car("Check", 123);
        carSet.add(car);
        assertTrue(carSet.contains(car));
        carSet.remove(car);
        assertFalse(carSet.contains(car));
    }

    @Test
    public void testForEach() {
        int index = 0;
        for (Car car : carSet) {
            index++;
        }
        assertEquals(100, index);
    }
}
