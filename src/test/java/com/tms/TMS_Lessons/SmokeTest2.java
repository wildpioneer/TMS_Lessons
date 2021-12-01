package com.tms.TMS_Lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SmokeTest2 {

    private String driverPath = "/Users/aleksandr.trostyanko/Documents/Work/TechMeSkills/practice/TestSelenium/src/driver/chromedriver";
    //private String URL = "https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-скф";
    private String URL = "http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf";

    @Test
    public void test1() {
        String creatinineValue = "80";
        String ageValue = "38";
        String weightValue = "55";
        String heightValue = "163";

        String expectedMDRD = "MDRD: 74 (мл/мин/1,73кв.м)";
        String expectedMDRD1 = "ХБП: 2 стадия (при наличии почечного повреждения)";
        String expectedCG = "Cockroft-Gault: 70 (мл/мин)";
        String expectedBSA = "Поверхность тела:1.58 (кв.м)";

        //System.setProperty("webdriver.chrome.driver", driverPath);

        //1. Открыть сайт
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        //2. Выбрать пол из выпадающего списка
        Select sex = new Select(driver.findElement(By.id("oSex")));
        sex.selectByIndex(1);

        //3. Ввести Креатенин
        WebElement creatinine = driver.findElement(By.id("oCr"));
        creatinine.sendKeys(creatinineValue);

        //4. Ввести Возраст
        WebElement age = driver.findElement(By.id("oAge"));
        age.sendKeys(ageValue);

        //5. Ввести Вес
        WebElement weight = driver.findElement(By.id("oWeight"));
        weight.sendKeys(weightValue);

        //6. Ввести Рост
        WebElement height = driver.findElement(By.id("oHeight"));
        height.sendKeys(heightValue);

        //7. Нажать на кнопку ‘Рассчитать’
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();

        //8. Проверить результаты
        String actualMDRD = driver.findElement(By.id("txtMDRD")).getText();
        String actualMDRD1 = driver.findElement(By.id("txtMDRD1")).getText();
        String actualCG = driver.findElement(By.id("txtCG")).getText();
        String actualBSA = driver.findElement(By.id("txtBSA")).getText();

        if (!actualMDRD.equals(expectedMDRD)) {
            System.out.printf("The value in the field 'MDRD' is %s and not equal to %s.",
                    actualMDRD, expectedMDRD);
        }
        if (!actualMDRD1.equals(expectedMDRD1)) {
            System.out.printf("The value in the field 'ХБП' is %s and not equal to %s.",
                    actualMDRD1, expectedMDRD1);
        }
        if (!actualCG.equals(expectedCG)) {
            System.out.printf("The value in the field 'Cockroft-Gault' is %s and not equal to %s.",
                    actualCG, expectedCG);
        }
        if (!actualBSA.equals(expectedBSA)) {
            System.out.printf("The value in the field 'Поверхность тела' is %s and not equal to %s.",
                    actualBSA, expectedBSA);
        }

        //9. Закрыть браузер
        driver.quit();
    }
}
