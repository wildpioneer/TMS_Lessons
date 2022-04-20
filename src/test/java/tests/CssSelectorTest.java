package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class CssSelectorTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cssSelectorTest() {
        driver.get(ReadProperties.getUrl());

        // Find webElement by ID
        driver.findElement(By.cssSelector("#name")).sendKeys(ReadProperties.username());
    }

    @Test
    public void cssSelectorTest1() throws InterruptedException {
        //driver.get(ReadProperties.getUrl());
        driver.get("file:/Users/aleksandr/Documents/Work/TechMeSkills/code/TMS_Lessons/src/test/resources/index.html");

        // Find webElement by class name
        Assert.assertEquals(driver.findElement(By.cssSelector(".intro")).getTagName(), "div");
        Assert.assertEquals(driver.findElement(By.cssSelector("#Lastname")).getTagName(), "span");
    }
}
