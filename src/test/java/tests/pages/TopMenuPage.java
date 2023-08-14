package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.baseEntities.BasePage;

public class TopMenuPage extends BasePage {
    private final By topPanelLocator = By.className("top-panel");

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return topPanelLocator;
    }

    public WebElement getTopPanel() {
        return driver.findElement(topPanelLocator);
    }
}
