package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsOverviewPage extends BasePage {
    public SideMenuPage sideMenuPage;

    private final By chartTableLocator = By.id("chart-line-fc");
    private final String tabLocator = "//li/a[. = 'Replace']";

    public ProjectsOverviewPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return chartTableLocator;
    }

    public WebElement getTabByName(String tabName) {
        return driver.findElement(By.xpath(tabLocator.replace("Replace", tabName)));
    }
}
