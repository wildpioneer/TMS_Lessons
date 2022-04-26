package pages;

import baseEntity.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    protected static By PAGE_OPENED_IDENTIFIER = By.id("activityChart");

    protected By addProjectButtonSelector = By.id("sidebar-projects-add");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return PAGE_OPENED_IDENTIFIER;
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonSelector);
    }

}
