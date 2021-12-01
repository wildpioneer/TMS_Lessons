package com.tms.TMS_Lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BeautifulSmokeTest {

    private String driverPath = "/Users/aleksandr.trostyanko/Documents/Work/TechMeSkills/practice/TestSelenium/src/driver/chromedriver";
    private String URL = "http://13gp.by/informatsiya/meditsinskie-kalkulyatory/994-raschet-indeksa-massy-tela";

    @Test
    public void test1() {
        String heightValue = "183";
        String weightValue = "58";
        String expectedResult = "17.32";
        String expectedStatus = "Пониженный вес";

        System.setProperty("webdriver.chrome.driver", driverPath);

        //1. Открыть сайт
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        //2. Ввести Рост
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys(heightValue);

        //3. Ввести Вес
        WebElement weight = driver.findElement(By.name("mass"));
        weight.sendKeys(weightValue);

        //4. Нажать на кнопку ‘Рассчитать’
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();

        //5. Проверить, что значение в поле 'ИМТ’ равно ожидаемому
        String actualResult = driver.findElement(By.name("result")).getAttribute("value");

        if (!actualResult.equals(expectedResult)) {
            System.out.printf("The value in the field 'ИМТ' is %s and not equal to %s.",
                    actualResult, expectedResult);
        }

        //6. Проверить, что статус равен одидаемому
        String actualStatus = driver.findElement(By.id("resline")).getText();
        if (!actualStatus.equals(expectedStatus)) {
            System.out.printf("The value in the status field is %s and not equal to %s.",
                    actualResult, expectedStatus);
        }

        driver.quit();
    }
}
