package webdriver.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.page.*;

import java.util.ArrayList;

public class GoogleCloudPricingCalculatorEstimateEmailTest {

    private WebDriver driver;
    private YopmailGeneratedEmailMailboxPage yopmailGeneratedEmailMailboxPage;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        GoogleCloudPricingCalculatorEstimatePage googleCloudPricingCalculatorEstimatePage = new GoogleCloudHomePage(driver).openPage()
                .searchForText("Google Cloud Platform Pricing Calculator")
                .getSearchResultByText()
                .fillForm()
                .openEmailEstimate();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        YopmailGeneratedEmailPage yopmailGeneratedEmailPage = new YopmailHomePage(driver).openPage().generateEmail();
        String generatedEmail = yopmailGeneratedEmailPage.getGeneratedEmail();

        driver.switchTo().window(tabs.get(0));
        googleCloudPricingCalculatorEstimatePage.fillEmailEstimateField(generatedEmail).sendEmail();

        driver.switchTo().window(tabs.get(1));
        yopmailGeneratedEmailMailboxPage = yopmailGeneratedEmailPage.openMailBox()
                .getTheLatestMailFromGoogleCloudPricingCalculator();
    }

    @Test
    public void checkTotalEstimateMonthlyCoast() {
        Assert.assertEquals(yopmailGeneratedEmailMailboxPage.getTotalEstimateMonthlyCoastField(), "USD 1,083.33");
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
