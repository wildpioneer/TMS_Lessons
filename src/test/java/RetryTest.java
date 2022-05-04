import org.junit.jupiter.api.RepeatedTest;

public class RetryTest extends BaseTest {
    private int attempt = 1;

    @RepeatedTest(10)
    public void flakyTest() {
            System.out.println("Attempt is: " + attempt);
            attempt++;
    }
}
