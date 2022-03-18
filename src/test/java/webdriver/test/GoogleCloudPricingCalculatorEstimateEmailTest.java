package webdriver.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.driver.DriverSingleton;
import webdriver.page.*;
import webdriver.service.ComputerEngineCreator;

import java.util.ArrayList;

public class GoogleCloudPricingCalculatorEstimateEmailTest {

    private WebDriver driver;
    private YopmailGeneratedEmailMailboxPage yopmailGeneratedEmailMailboxPage;
    private String totalEstimateCost;

    @BeforeTest(alwaysRun = true)
    public void testEnvironmentSetup() {
        driver = DriverSingleton.getDriver();
        GoogleCloudPricingCalculatorEstimatePage googleCloudPricingCalculatorEstimatePage = new GoogleCloudHomePage(driver).openPage()
                .searchForText("Google Cloud Pricing Calculator")
                .getSearchResultByText()
                .fillForm(ComputerEngineCreator.withSettingByDefault())
                .openEmailEstimate();
        totalEstimateCost = googleCloudPricingCalculatorEstimatePage.getEstimateTotalCost(true);
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
        Assert.assertEquals(
                yopmailGeneratedEmailMailboxPage.getTotalEstimateMonthlyCoastField(),
                totalEstimateCost);
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
