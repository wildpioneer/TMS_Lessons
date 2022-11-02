package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.ReadProperties;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private static String ENDPOINT = "/index.php?/auth/login";
    protected By emailSelector = By.id("name");
    protected By passwordSelector = By.id("password");
    protected By loginSelector = By.id("button_primary");

    public String getPageURL() {
        return ReadProperties.getUrl() + ENDPOINT;
    }

    public SelenideElement getEmailField() {
        return $(emailSelector);
    }

    public SelenideElement getPasswordField() {
        return $(passwordSelector);
    }

    public SelenideElement getLoginButton() {
        return $(loginSelector);
    }

    @Step
    public DashboardPage successfulLogin(User user) {
        login(user);
        return page(DashboardPage.class);
    }

    @Step
    public LoginPage unsuccessfulLogin(User user) {
        login(user);
        return page(this);
    }

    private void login(User user) {
        getEmailField().shouldBe(Condition.visible).setValue(user.getEmail());
        getPasswordField().shouldBe(Condition.visible).setValue(user.getPassword());
        getLoginButton().shouldBe(Condition.enabled).click();
    }
}
