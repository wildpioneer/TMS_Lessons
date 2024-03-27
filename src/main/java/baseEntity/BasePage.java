package baseEntity;

import core.ReadProperties;
import core.WaitsService;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.time.Duration;

public abstract class BasePage extends LoadableComponent<BasePage> {
    protected static final int WAIT_FOR_PAGE_LOADED_IN_SECONDS = 60;

    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitsService = new WaitsService(driver);

        get();
    }

    protected void load() {
        driver.get(ReadProperties.getUrl() + getPagePath());
    }

    protected void isLoaded() throws Error {
        if (!isPageOpened()) throw new Error();
    }

    protected abstract By getPageIdentifier();
    protected abstract String getPagePath();

    public boolean isPageOpened() {
        try {
            return new WaitsService(driver, Duration.ofSeconds(ReadProperties.pageLoadTimeout()))
                    .waitForVisibilityLocatedBy(getPageIdentifier()).isDisplayed();
        } catch (TimeoutException ex) {
            return false;
        }
    }
}
