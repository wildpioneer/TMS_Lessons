import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected Calculator calculator = new Calculator();

    @BeforeAll
    public void beforeAll() { System.out.println("BeforeAll: ...");}

    @BeforeEach
    public void beforeEach() { System.out.println("BeforeMethod: ...");}

    @AfterAll
    public void afterAll() { System.out.println("AfterAll: ...");}

    @AfterEach
    public void afterEach() { System.out.println("AfterEach: ...");}
}
