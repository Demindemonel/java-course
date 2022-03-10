package webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingCalculatorEstimatePage extends AbstractPage {
    @FindBy(xpath = "//*[@id='compute']//div[contains(text(),'Region')]")
    private WebElement estimateRegion;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(),'Commitment term')]")
    private WebElement estimateCommitmentTerm;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(),'VM class')]")
    private WebElement estimateVMClass;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(),'Instance type')]")
    private WebElement estimateInstanceType;

    @FindBy(xpath = "//*[@id='compute']//div[contains(text(),'Local SSD')]")
    private WebElement estimateLocalSSD;

    @FindBy(xpath = "//*[@id='resultBlock']//h2[@class='md-title']/b")
    private WebElement estimateTotalCost;

    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//*[@name='description'][@type='email']")
    private WebElement emailEstimateField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public GoogleCloudPricingCalculatorEstimatePage(WebDriver driver) {
        super(driver);
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

    public String getEstimateTotalCost(boolean isGetShort) {
        if (isGetShort) {
            String tempEstimateTotalCost = estimateTotalCost.getText();
            tempEstimateTotalCost = tempEstimateTotalCost.substring(tempEstimateTotalCost.indexOf("USD "), tempEstimateTotalCost.indexOf(" per"));
            return tempEstimateTotalCost;
        } else {
            return estimateTotalCost.getText();
        }
    }

    public GoogleCloudPricingCalculatorEstimatePage openEmailEstimate() {
        emailEstimateButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorEstimatePage fillEmailEstimateField(String email) {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(emailEstimateField));
        emailEstimateField.sendKeys(email);
        return this;
    }

    public GoogleCloudPricingCalculatorEstimatePage sendEmail() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(sendEmailButton));
        sendEmailButton.click();
        return this;
    }
}
