import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DependencyTest {

    @Test
    public void stepb() {System.out.println("stepb...");}

    @Test
    public void stepa() {
        System.out.println("stepa...");
        assertTrue(false);
    }

    @Test
    public void stepd() {System.out.println("stepd...");}

    @Test
    public void stepc() {System.out.println("stepc...");}
}
