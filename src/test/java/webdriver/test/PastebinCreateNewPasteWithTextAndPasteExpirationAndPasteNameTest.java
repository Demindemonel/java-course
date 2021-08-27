package webdriver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webdriver.page.PastebinHomePage;

public class PastebinCreateNewPasteWithTextAndPasteExpirationAndPasteNameTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPasteWithTextAndPasteExpirationAndPasteName() {
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage.openPage().fillPasteTextArea("Hello from WebDriver").selectPasteExpiration().fillPasteName("helloweb");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
