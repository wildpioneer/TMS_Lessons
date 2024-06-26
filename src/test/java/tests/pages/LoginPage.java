package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.baseEntities.BasePage;

public class LoginPage extends BasePage {
    private final static String pagePath = "";

    // Блок описания локаторов для элементов
    private static final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("button_primary");
    private final By errorTextLabelLocator = By.className("error-text");

    // Блок иницализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Блок атомарных методов
    public WebElement getEmailInput() {
        return waitsService.waitForVisibilityLocatedBy(emailInputLocator);
    }

    public LoginPage setEmail(String value) {
        getEmailInput().sendKeys(value);
        return this;
    }

    public WebElement getPasswordInput() {
        return waitsService.waitForVisibilityLocatedBy(passwordInputLocator);
    }

    public LoginPage setPassword(String value) {
        getPasswordInput().sendKeys(value);
        return this;
    }

    public WebElement getLoginButton() {
        return waitsService.waitForVisibilityLocatedBy(loginButtonLocator);
    }

    public WebElement getErrorTextLabel() {
        return waitsService.waitForVisibilityLocatedBy(errorTextLabelLocator);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public String getErrorText() {
        return getErrorTextLabel().getText();
    }


    private void login(String username, String password) {
        this
                .setEmail(username)
                .setPassword(password)
                .clickLoginButton();
    }

    public DashboardPage successfulLogin(String username, String password) {
        login(username, password);
        return new DashboardPage(driver);
    }

    public LoginPage incorrectLogin(String username, String password) {
        login(username, password);
        return this;
    }
}
