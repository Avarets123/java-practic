import java.util.ArrayList;
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

}