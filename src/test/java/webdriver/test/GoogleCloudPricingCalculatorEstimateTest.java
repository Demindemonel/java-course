package webdriver.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.service.BusinessGoogleCloudPricingCalculator;
import webdriver.page.GoogleCloudHomePage;
import webdriver.page.GoogleCloudPricingCalculatorEstimatePage;
import webdriver.service.ComputerEngineCreator;

public class GoogleCloudPricingCalculatorEstimateTest extends CommonConditions {
    private GoogleCloudPricingCalculatorEstimatePage googleCloudPricingCalculatorEstimatePage;

    @BeforeTest(description = "Filling out the order")
    public void testEnvironmentSetup() {
        googleCloudPricingCalculatorEstimatePage = new BusinessGoogleCloudPricingCalculator(new GoogleCloudHomePage(driver)
                .openPage()
                .searchForText("Google Cloud Pricing Calculator")
                .getSearchResultByText()
                .clickAcceptCookieButton())
                .fillForm(ComputerEngineCreator.withSettingByDefault());
    }

    @Test(description = "Estimate VM Class check.")
    public void checkEstimateVMClass() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateVMClass(),
                "VM class: regular",
                "Estimate VM Class field value is incorrect.");
    }

    @Test(description = "Estimate Instance Type check.")
    public void checkEstimateInstanceType() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateInstanceType(),
                "Instance type: n1-standard-8\nCommitted Use Discount applied",
                "Estimate Instance Type field value is incorrect.");
    }

    @Test(description = "Estimate Region check.")
    public void checkEstimateRegion() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateRegion(),
                "Region: Frankfurt",
                "Estimate Region field value is incorrect.");
    }

    @Test(description = "Estimate Local SSD check.")
    public void checkEstimateLocalSSD() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateLocalSSD(),
                "Local SSD: 2x375 GiB\nCommitted Use Discount applied",
                "Estimate Local SSD field value is incorrect.");
    }

    @Test(description = "Estimate Commitment Term check.")
    public void checkEstimateCommitmentTerm() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateCommitmentTerm(),
                "Commitment term: 1 Year",
                "Estimate Commitment Term field value is incorrect.");
    }

    @Test(description = "Estimate Total Cost check.")
    public void checkEstimateTotalCost() {
        Assert.assertEquals(
                googleCloudPricingCalculatorEstimatePage.getEstimateTotalCost(false),
                "Total Estimated Cost: USD 6,969.49 per 1 month",
                "Estimate Total Cost field value is incorrect.");
    }
}
