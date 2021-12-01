package com.tms.TMS_Lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomeWork {

    @Test
    public void test1() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        //1. Открыть сайт https://healthunify.com/bmicalculator/
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        //2. Ввести Weight > 10 kg
        WebElement weight = driver.findElement(By.name("wg"));
        weight.sendKeys("40");

        //3. Ввести Height > 33 cm
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys("158");

        //4. Нажать на кнопку ‘Calculate’
        WebElement calculate = driver.findElement(By.name("cc"));
        calculate.click();

        //5. Проверить, что значение в поле 'SI Units’ равно 16.02
        WebElement siUnits = driver.findElement(By.name("si"));
        String siValue = siUnits.getAttribute("value");
        if (!siValue.equals("16.02")) {
            System.out.println("The value in the field 'SI Units' is not equal to 16.02.");
        }

        //6. Проверить, что значение в поле 'US Units’ равно 16.29
        WebElement usUnits = driver.findElement(By.name("us"));
        String usValue = usUnits.getAttribute("value");
        if (!usValue.equals("16.29")) {
            System.out.println("The value in the field 'US Units' is " + usValue + " and not equal to 16.29.");
        }

        //7. Проверить, что значение в поле UK Units’ равно 101.73
        WebElement ukUnits = driver.findElement(By.name("uk"));
        String ukExpectedResult = "101.73";
        String ukActualResult = ukUnits.getAttribute("value");

        if (!ukActualResult.equals(ukExpectedResult)) {
            System.out.printf("The value in the field 'US Units' is %s and not equal to %s.",
                    ukActualResult, ukExpectedResult);
        }

        //8. Проверить, что статус равен ’Your category is Underweight’
        if (!driver.findElement(By.name("desc")).getAttribute("value").equals("Your category is Underweight")) {
            System.out.printf("The value in the status field is %s and not equal to %s.",
                    driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Underweight");
        }

        driver.quit();
    }
}
