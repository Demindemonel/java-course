package webdriver.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.driver.DriverSingleton;
import webdriver.page.PastebinHomePage;

public class PastebinCreateNewPasteWithTextAndPasteExpirationAndPasteNameTest {

    private WebDriver driver;

    @BeforeTest(alwaysRun = true, description = "Setting up a test environment.")
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
    }

    @Test(description = "Filling the new paste, its name and expiration date.")
    public void createNewPasteWithTextAndPasteExpirationAndPasteName() {
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage.openPage().fillPasteTextArea("Hello from WebDriver").selectPasteExpiration().fillPasteName("helloweb");
    }

    @AfterTest(alwaysRun = true, description = "Shutting down the WebDriver instance.")
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
