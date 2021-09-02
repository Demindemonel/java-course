package webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPricingCalculatorEstimatePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(),'Region')]")
    private WebElement estimateRegion;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(),'Commitment term')]")
    private WebElement estimateCommitmentTerm;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(),'VM Class')]")
    private WebElement estimateVMClass;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(),'InstanceType')]")
    private WebElement estimateInstanceType;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(),'Local SSD')]")
    private WebElement estimateLocalSSD;

    @FindBy(xpath = "//*[@id='resultBlock']//h2[@class='md-title']/b")
    private WebElement estimateTotalCost;

    public GoogleCloudPricingCalculatorEstimatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getEstimateRegion() {
        return estimateRegion.getText();
    }

    public String getEstimateCommitmentTerm() {
        return estimateCommitmentTerm.getText();
    }

    public String getEstimateVMClass() {
        return estimateVMClass.getText();
    }

    public String getEstimateInstanceType() {
        return estimateInstanceType.getText();
    }

    public String getEstimateLocalSSD() {
        return estimateLocalSSD.getText();
    }

    public String getEstimateTotalCost() {
        return estimateTotalCost.getText();
    }
}
