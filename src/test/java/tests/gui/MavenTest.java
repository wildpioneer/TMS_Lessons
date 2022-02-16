package tests.gui;

import org.testng.annotations.Test;

public class MavenTest {

    @Test
    public void parameterTest() {
        String val = System.getProperty("testProp");
        System.out.println(System.getProperty("testProp"));
    }
}
