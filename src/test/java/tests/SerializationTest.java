package tests;

import com.google.gson.Gson;
import models.Project;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializationTest {

    @Test
    public void objectToJSonTest() throws IOException {
        Project project = new Project("Test Project", "Big announcement text", true, 1);
        Gson gson = new Gson();

        String simpleJson = gson.toJson(123.45);
        System.out.println(simpleJson);

        String objectJson = gson.toJson(project);
        System.out.println(objectJson);

        FileWriter file = new FileWriter("project.json");
        gson.toJson(project, file);
        file.close();
    }

    @Test
    public void jsonToObjectTest() throws IOException, URISyntaxException {
        Project projectFromString;
        Project projectFromFile;

        Gson gson = new Gson();

        String json = "{\n" +
                "  \"name\": \"Test Project\",\n" +
                "  \"announcement\": \"Big announcement text\",\n" +
                "  \"show_announcement\": true,\n" +
                "  \"type\": 1\n" +
                "}";

        projectFromString = gson.fromJson(json, Project.class);
        System.out.println(projectFromString.toString());



        Reader reader = Files.newBufferedReader(Paths.get("project.json"));
        projectFromFile = gson.fromJson(reader, Project.class);
        System.out.println(projectFromFile.toString());
    }
}
