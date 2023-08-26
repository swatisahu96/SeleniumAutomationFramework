package basetest;

import org.example.Driver.DriverManagerTL;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        DriverManagerTL.init();
    }

    @AfterSuite
    public void tearDown(){
        DriverManagerTL.down();
    }

}
