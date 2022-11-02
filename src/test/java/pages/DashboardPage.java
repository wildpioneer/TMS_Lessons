package pages;

import com.codeborne.selenide.SelenideElement;
import core.ReadProperties;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private static final By PAGE_OPENED_IDENTIFIER = By.id("activityChart");
    private static String ENDPOINT = "/index.php?/dashboard";
    protected By addProjectButtonSelector = By.id("sidebar-projects-add");
    protected By USERNAME = By.className("navigation-username");


    public String getPageURL() {
        return ReadProperties.getUrl() + ENDPOINT;
    }

    public SelenideElement getAddProjectButton() {
        return $(addProjectButtonSelector);
    }

    public SelenideElement getUsernameLink() {
        return $(USERNAME);
    }

}
