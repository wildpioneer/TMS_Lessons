import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest extends BaseTest {

    @Test
    public void testSum() {
        assertEquals(calculator.sum(2, 3), 5, "Неверная сумма...");
    }

    @Test
    public void testSum1() {
        assertEquals(calculator.sum(2, 3), 5, "Неверная сумма...");
    }

    @Test
    public void testSum2() {
        assertEquals(calculator.sum(2, 3), 5, "Неверная сумма...");
    }

    @Test
    public void testSum3() {
        assertEquals(calculator.sum(2, 3), 5, "Неверная сумма...");
    }

    @Test
    public void waitLongTimeTest() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    public void invocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        assertEquals(calculator.sum(2, 3), 5, "Неверная сумма...");
    }

    @Test
    public void testDataProvider(int a, int b, int expectedResult) {
        assertEquals(calculator.sum(a, b), expectedResult, "Неверная сумма...");
    }

    @Test
    public void testExceptions() {
        List list = null;
        int size = list.size();
    }

}
