package org.example.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
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

    @BeforeMethod
    public static void init(){
// TODO #1 - Need to make it support for Safari, Firefox, Edge & IE
        if(getDriver()==null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            setDriver(new ChromeDriver(options));
        }
    }
    @AfterMethod
    public static void down(){
        if(getDriver()!=null){
            getDriver().quit();
        }
    }


}
