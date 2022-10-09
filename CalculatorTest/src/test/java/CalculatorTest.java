import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int expected = 10;
        int result = calculator.add(5, 5);
        assertEquals(expected, result);
        int result2 = calculator.add(22, 5);
        assertEquals(27, result2);
    }

    @Test
    public void multiple() {
        Calculator calculator = new Calculator();
        assertEquals(50, calculator.multiple(10.1, 5), 1);
    }

    @Test
    public void division() {
        Calculator calculator = new Calculator();
        assertEquals(50, calculator.division(100, 2));
    }

    @Test
    public void subtraction() {
        Calculator calculator = new Calculator();
        assertEquals(50, calculator.substraction(100, 50));
    }

}