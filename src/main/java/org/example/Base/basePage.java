package org.example.Base;

import org.example.Driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class basePage {

    public basePage() {
    }

    public static void enterInput(By by, String key) {

        DriverManagerTL.getDriver().findElement(by).sendKeys(key);

    }

    public static void clickElement(By by) {
        DriverManagerTL.getDriver().findElement(by).click();
    }

    public static void implicitWait() {
        DriverManagerTL.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebElement getElement(By by) {
       return DriverManagerTL.getDriver().findElement(by);
    }


}
