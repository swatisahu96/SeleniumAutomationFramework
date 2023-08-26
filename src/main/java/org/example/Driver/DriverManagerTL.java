package org.example.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverManagerTL {

   public static WebDriver driver;

   public static final ThreadLocal<WebDriver> dr = new ThreadLocal();

    public static void setDriver(WebDriver driver) {
        dr.set(driver);
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void unload(){
        dr.remove();
    }

    @BeforeSuite
    public static void init(){
// TODO #1 - Need to make it support for Safari, Firefox, Edge & IE
        if(getDriver()==null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            setDriver(new ChromeDriver(options));
        }
    }

    @AfterSuite
    public static void down(){
        if(getDriver()!=null){
            getDriver().quit();
        }
    }


}
