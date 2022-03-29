package webdriver.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import webdriver.driver.DriverSingleton;
import webdriver.utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeTest(alwaysRun = true, description = "Setting up the WebDriver instance.")
    public void setupDriver() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest(alwaysRun = true, description = "Shutting down the WebDriver instance.")
    public void stopDriver() {
        DriverSingleton.closeDriver();
    }
}
