package tests;

import com.codeborne.selenide.Condition;
import core.ReadProperties;
import models.User;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class SmokeTest {

    @Test
    public void loginTest() {
        User admin = new User(ReadProperties.getUsername(), ReadProperties.getPassword());

        LoginPage loginPage = open(ReadProperties.getUrl(), LoginPage.class);
        DashboardPage dashboardPage = loginPage.successfulLogin(admin);
        dashboardPage.getAddProjectButton().shouldBe(visible);
    }
}
