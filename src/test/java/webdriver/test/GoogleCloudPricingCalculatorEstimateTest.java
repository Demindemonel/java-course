package webdriver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.page.GoogleCloudHomePage;
import webdriver.page.GoogleCloudPricingCalculatorEstimatePage;

public class GoogleCloudPricingCalculatorEstimateTest {
    private WebDriver driver;
    private GoogleCloudPricingCalculatorEstimatePage googleCloudPricingCalculatorEstimatePage;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudPricingCalculatorEstimatePage = googleCloudHomePage.openPage()
                .searchForText("Google Cloud Platform Pricing Calculator")
                .getSearchResultByText()
                .fillForm();
    }

    @Test
    public void checkEstimateVMClass() {
        Assert.assertTrue(googleCloudPricingCalculatorEstimatePage.getEstimateVMClass().contains("regular"), "Estimate VM Class is wrong.");
    }

    @Test
    public void checkEstimateInstanceType() {
        Assert.assertTrue(googleCloudPricingCalculatorEstimatePage.getEstimateInstanceType().contains("n1-standard-8"), "Estimate Instance Type is wrong.");
    }

    @Test
    public void checkEstimateRegion() {
        Assert.assertTrue(googleCloudPricingCalculatorEstimatePage.getEstimateRegion().contains("Frankfurt"), "Estimate Region is wrong.");
    }

    @Test
    public void checkEstimateLocalSSD() {
        Assert.assertTrue(googleCloudPricingCalculatorEstimatePage.getEstimateLocalSSD().contains("2x375"), "Estimate Local SSD is wrong.");
    }

    @Test
    public void checkEstimateCommitmentTerm() {
        Assert.assertTrue(googleCloudPricingCalculatorEstimatePage.getEstimateCommitmentTerm().contains("1 Year"), "Estimate Commitment Term is wrong.");
    }

    @Test
    public void checkEstimateTotalCost() {
        Assert.assertTrue(googleCloudPricingCalculatorEstimatePage.getEstimateTotalCost().contains("270.83"), "Estimate Total Cost is wrong.");
    }

//    @AfterTest(alwaysRun = true)
//    public void browserTearDown() {
//        driver.quit();
//        driver = null;
//    }
}
