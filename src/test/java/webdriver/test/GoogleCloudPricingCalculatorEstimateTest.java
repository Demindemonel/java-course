package webdriver.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.driver.DriverSingleton;
import webdriver.page.GoogleCloudHomePage;
import webdriver.page.GoogleCloudPricingCalculatorEstimatePage;
import webdriver.service.ComputerEngineCreator;

public class GoogleCloudPricingCalculatorEstimateTest {
    private WebDriver driver;
    private GoogleCloudPricingCalculatorEstimatePage googleCloudPricingCalculatorEstimatePage;

    @BeforeTest(alwaysRun = true, description = "asdas")
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
        googleCloudPricingCalculatorEstimatePage = new GoogleCloudHomePage(driver).openPage()
                .searchForText("Google Cloud Pricing Calculator")
                .getSearchResultByText()
                .fillForm(ComputerEngineCreator.withSettingByDefault());
    }

    @Test(description = "")
    public void checkEstimateVMClass() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateVMClass(),
                "VM class: regular", "");
    }

    @Test
    public void checkEstimateInstanceType() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateInstanceType(),
                "Instance type: n1-standard-8\nCommitted Use Discount applied");
    }

    @Test
    public void checkEstimateRegion() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateRegion(),
                "Region: Frankfurt");
    }

    @Test
    public void checkEstimateLocalSSD() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateLocalSSD(),
                "Local SSD: 2x375 GiB\nCommitted Use Discount applied");
    }

    @Test
    public void checkEstimateCommitmentTerm() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateCommitmentTerm(),
                "Commitment term: 1 Year");
    }

    @Test
    public void checkEstimateTotalCost() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateTotalCost(false),
                "Total Estimated Cost: USD 6,969.49 per 1 month");
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
