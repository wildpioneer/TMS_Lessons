package tests;

import core.ReadProperties;
import lombok.Cleanup;
import lombok.val;
import lombok.var;
import models.Milestone;
import models.Person;
import models.User;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;

//public class LombokTest extends BaseTest {
public class LombokTest {

    @Test
    public void valTest() {
        val list = new ArrayList<String>(); // Transfer to final variable
        list.add("Test Value");
    }

    @Test
    public void varTest() {
        var list = new ArrayList<String>(); // Transfer to not final variable
        list.add("Test Value");
    }

    @Test
    public void notNullTest() {
        Milestone milestone = new Milestone("Nut Null Value");
    }

    @Test
    public void сleanUpTest() throws IOException {
        @Cleanup InputStream in = new FileInputStream("src/test/resources/text.txt");
        @Cleanup OutputStream out = new FileOutputStream("src/test/resources/text1.txt");
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
    }

    @Test
    public void getterAndSetterTest() {
        Person person = new Person();
        person.setAge(23);
        var age = person.getAge();
    }


    @Test
    public void loginTest() {
        User user = User.builder()
                .email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .build();

        User user1 = User.builder()
                .email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .build();

        System.out.println(user.toString());
        System.out.println(user.equals(user1));
    }
}
