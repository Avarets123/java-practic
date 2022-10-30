import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private CarQueue queue;

    @BeforeEach
    public void setUp() throws Exception {
        queue = new CarLinkedList();
        for (int i = 0; i < 10; i++) {
            queue.add(new Car("Brand" + i, i));
        }

    }

    @Test
    void add() {
        assertEquals(10, queue.size());
    }

    @Test
    void peek() {
        Car car = queue.peek();
        assertEquals(car.getBrand(), "Brand0");
        assertEquals(10, queue.size());
    }

    @Test
    void poll() {
        Car car = queue.poll();
        assertEquals(car.getBrand(), "Brand0");
        assertEquals(9, queue.size());
    }
}