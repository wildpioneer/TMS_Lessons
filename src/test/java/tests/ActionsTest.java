package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        List<WebElement> targetElements = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));
        actions
                .moveToElement(targetElements.get(0), 10, 10)
                .click(wait.waitForExists(By.cssSelector("[href='/users/1']")))
                .build()
                .perform();

        Assert.assertTrue(wait.waitForElementInvisible(targetElements.get(0)));
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile = getAbsolutePath("download.jpeg");
        System.out.println(pathToFile);
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();

        Thread.sleep(5000);
    }

    private String getAbsolutePath(String filename) {
        String filePath = null;

        // Получение классового загрузчика
        ClassLoader classLoader = BaseTest.class.getClassLoader();

        // Получение URL ресурса
        URL resourceURL = classLoader.getResource(filename);

        if (resourceURL != null) {
            // Получение пути к файлу
            filePath = new File(resourceURL.getFile()).getAbsolutePath();
            System.out.println("Полный путь к файлу: " + filePath);
        } else {
            System.out.println("Ресурс не найден");
        }

        return filePath;
    }
}
