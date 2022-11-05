import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {


    @Test
    public void  run() {

        Box<Integer> box = new Box<>(5, 10, 15);
        Box<Float> box1 = new Box<>(5f, 10f, 15f);
        assertEquals(box.avg(), box1.avg());
        Box.method(new ArrayList<Integer>());
    }

    @Test
    public void testMethodTransfer() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        List<Integer> numbers2 = new ArrayList<>();
        Box.transfer(numbers, numbers2);
        assertEquals(0, numbers.size());
        assertEquals(10, numbers2.size());
    }

}