package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.baseEntities.BasePage;

public class SideMenuPage extends BasePage {
    private final By sidebarLocator = By.id("sidebar");

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return sidebarLocator;
    }
}
