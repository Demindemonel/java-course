package webdriver.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.driver.DriverSingleton;
import webdriver.page.PastebinHomePage;

public class PastebinCreateNewPasteWithTextAndPasteExpirationAndPasteNameTest {

    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteWithTextAndPasteExpirationAndPasteName() {
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage.openPage().fillPasteTextArea("Hello from WebDriver").selectPasteExpiration().fillPasteName("helloweb");
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
