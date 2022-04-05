package webdriver.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.page.*;
import webdriver.service.ComputerEngineCreator;

import java.util.ArrayList;

public class GoogleCloudPricingCalculatorEstimateEmailTest extends CommonConditions{
    private YopmailGeneratedEmailMailboxPage yopmailGeneratedEmailMailboxPage;
    private String totalEstimateCost;

    @BeforeTest(description = "Filling out the order and sending the invoice to the email.")
    public void testEnvironmentSetup() {
        GoogleCloudPricingCalculatorEstimatePage googleCloudPricingCalculatorEstimatePage = new GoogleCloudHomePage(driver).openPage()
                .searchForText("Google Cloud Pricing Calculator")
                .getSearchResultByText()
                .clickAcceptCookieButton()
                .fillForm(ComputerEngineCreator.withSettingByDefault())
                .openEmailEstimate();
        totalEstimateCost = googleCloudPricingCalculatorEstimatePage.getEstimateTotalCost(true);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        YopmailGeneratedEmailPage yopmailGeneratedEmailPage = new YopmailHomePage(driver).openPage().clickAcceptCookieButton().generateEmail();
        String generatedEmail = yopmailGeneratedEmailPage.getGeneratedEmail();

        driver.switchTo().window(tabs.get(0));
        googleCloudPricingCalculatorEstimatePage.fillEmailEstimateField(generatedEmail).sendEmail();

        driver.switchTo().window(tabs.get(1));
        yopmailGeneratedEmailMailboxPage = yopmailGeneratedEmailPage.openMailBox()
                .getTheLatestMailFromGoogleCloudPricingCalculator();
    }

    @Test(description = "Comparison of the total estimate monthly amount from the calculator and from the mail.")
    public void checkTotalEstimateMonthlyCoast() {
        Assert.assertEquals(
                yopmailGeneratedEmailMailboxPage.getTotalEstimateMonthlyCoastField(),
                totalEstimateCost,
                "The value of the \"Total estimate monthly amount\" field from Yopmail doesn't match the value of the \"Estimate total cost\" field from the Google Cloud Pricing Calculator Estimate page.");
    }
}
