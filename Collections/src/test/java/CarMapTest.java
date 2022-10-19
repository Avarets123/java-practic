import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CarMapTest {

    private CarMap map;

    @BeforeEach
    void setUp() {
        map = new CarHashMap();
    }

    @Test
    public void whenPut100ElementThenSizeBecome100() {
        for (int i = 0; i < 100; i++) {
            CarOwner owner = new CarOwner(i, "Name" + i, "Lastname" + i);
            Car car = new Car("Brand" + i, i);
            map.put(owner, car);
        }
        assertEquals(100, map.size());

    }

    @Test
    public void whenPut100ElementWith10DifferentKeysThenSizeBecome10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner owner = new CarOwner(index, "Name" + index, "Lastname" + index);
            Car car = new Car("Brand" + index, index);
            map.put(owner, car);
        }
        assertEquals(10, map.size());
    }


    @Test
    public void removeReturnTrueOnlyOnce() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner owner = new CarOwner(index, "Name" + index, "Lastname" + index);
            Car car = new Car("Brand" + index, index);
            map.put(owner, car);
        }
        assertEquals(10, map.size());

        CarOwner elementForDeleting = new CarOwner(5, "Name5", "Lastname5");
        assertTrue(map.remove(elementForDeleting));
        assertEquals(9, map.size());
        assertFalse(map.remove(elementForDeleting));
    }

    @Test
    public void countOfKeysMustBeEqualsCountOfValues() {
        for (int i = 0; i < 100; i++) {
            CarOwner owner = new CarOwner(i, "Name" + i, "Lastname" + i);
            Car car = new Car("Brand" + i, i);
            map.put(owner, car);
        }
        assertEquals(100, map.size());
        assertEquals(100, map.keySet().size());
        assertEquals(100, map.values().size());
    }

    @Test
    public void methodGetMustReturnRightValue() {
        for (int i = 0; i < 100; i++) {
            CarOwner owner = new CarOwner(i, "Name" + i, "Lastname" + i);
            Car car = new Car("Brand" + i, i);
            map.put(owner, car);
        }

        CarOwner owner = new CarOwner(50, "Name50", "Lastname50");
        Car value = map.get(owner);

        String expectedCarValue = "Brand50";
        assertEquals(expectedCarValue, value.getBrand());

    }


}
