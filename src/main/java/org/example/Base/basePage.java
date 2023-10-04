package org.example.Base;

import org.example.Driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basePage {

    public basePage() {
    }

    protected void enterInput(By by, String key) {

        DriverManagerTL.getDriver().findElement(by).sendKeys(key);

    }

    protected void clickElement(By by) {
        DriverManagerTL.getDriver().findElement(by).click();
    }

    protected void implicitWait() {
        DriverManagerTL.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    protected WebElement presenceOfElement(By by) {

        return new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(by));

    }

    protected WebElement visibilityOfElement(By by) {

        return new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public WebElement getElement(By by) {
        return DriverManagerTL.getDriver().findElement(by);
    }


}
