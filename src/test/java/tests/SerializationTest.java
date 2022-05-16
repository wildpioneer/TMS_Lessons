package tests;

import models.Project;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationTest {

    @Test
    public void objectToJSonTest() throws IOException {
        Project project = new Project("Test Project", "Big announcment text", true, 1);
    }
}
