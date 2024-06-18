import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DataProviderTest extends BaseTest {

    @Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDataProvider1(int a, int b, int expectedResult) {
        System.out.println(Thread.currentThread().getId());
        Assert.assertEquals(calculator.sum(a, b), expectedResult, "Неверная сумма...");
    }

    @Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDataProvider2(int a, int b, int expectedResult) {
        System.out.println(Thread.currentThread().getId());
        Assert.assertEquals(calculator.sum(a, b), expectedResult, "Неверная сумма...");
    }
}
