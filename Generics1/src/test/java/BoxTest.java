import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {


    @Test
    public void  run() {

        Box<String, Integer, Float> box1 = new Box<>("first", 10, 3.5f);
        Box<String, Integer, Float> box2 = new Box<>("second", 7, 5.1f);

        int sum = (int) (box1.getFirst() + box1.getSecond() + box2.getFirst() + box2.getSecond());

        assertEquals(25, sum);

    }

}