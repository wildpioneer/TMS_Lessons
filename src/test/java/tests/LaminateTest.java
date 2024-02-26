package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import services.BrowsersService;

public class LaminateTest  {

    @Test
    public void test() throws InterruptedException {
        BrowsersService browsersService = new BrowsersService();
        WebDriver driver = browsersService.getDriver();

        driver.get("https://calc.by/building-calculators/laminate.html");
        driver.findElement(By.cssSelector(".calc-btn-div .calc-btn")).click();

        Thread.sleep(2000);

        String value1 = driver.findElement(By.cssSelector(".calc-result div:first-child span")).getText();
        String value2 = driver.findElement(By.cssSelector(".calc-result div:nth-child(2) span")).getText();
        Assert.assertEquals(value1, "57");
        Assert.assertEquals(value2, "8");

        driver.quit();
    }

    @Test
    public void CalcLaminateTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        BrowsersService browsersService = new BrowsersService();
        WebDriver driver = browsersService.getDriver();

        driver.get("https://home-ex.ru/calculation/");

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.click();
        roomLength.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "100");
        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.click();
        roomWidth.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "200");

        driver.findElement(By.id("btn_calculate")).click();

        Thread.sleep(2000);

        softAssert.assertEquals(driver.findElement(By.cssSelector(".calc-result")).getText().trim().replace("\r", ""),
                "Требуемое количество плашек ламината: 10\n" +
                        "Количество упаковок ламината: 1\n" +
                        "Стоимость ламината: NaN руб\n" +
                        "Вес ламината: 0 кг");

        softAssert.assertAll();

        driver.quit();
    }
}
