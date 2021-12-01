package com.tms.TMS_Lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SmokeTest1 {

    @Test
    public void Test1() {
        //1. Открыть сайт https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-имт
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/994-raschet-indeksa-massy-tela");

        //2. Ввести Рост = 183 см
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys("183");

        //3. Ввести Вес = 58 кг
        WebElement weight = driver.findElement(By.name("mass"));
        weight.sendKeys("58");

        //4. Нажать на кнопку ‘Рассчитать’
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();

        //5. Проверить, что значение в поле 'ИМТ’ равно 17.32
        //Вариант проверки 1
        WebElement result = driver.findElement(By.name("result"));
        String resultValue = result.getAttribute("value");
        if (!resultValue.equals("17.32")) {
            System.out.println("The value in the field 'ИМТ' is not equal to 17.32.");
        }

        //Вариант проверки 2
        WebElement result1 = driver.findElement(By.name("result"));
        String result1Value = result1.getAttribute("value");
        if (!result1Value.equals("17.32")) {
            System.out.println("The value in the field 'ИМТ' is " + result1Value + " and not equal to 17.32.");
        }

        //Вариант проверки 3
        WebElement result2 = driver.findElement(By.name("result"));
        String expectedResult = "17.32";
        String actualResult = result2.getAttribute("value");

        if (!actualResult.equals(expectedResult)) {
            System.out.printf("The value in the field 'ИМТ' is %s and not equal to %s.",
                    actualResult, expectedResult);
        }

        //6. Проверить, что статус равен ’Пониженный вес’
        if (!driver.findElement(By.id("resline")).getText().equals("Пониженный вес")) {
            System.out.printf("The value in the status field is %s and not equal to %s.",
                    driver.findElement(By.id("resline")).getText(), "Пониженный вес");
        }

        //7. Закрыть окно браузера
        driver.quit();
    }
}
