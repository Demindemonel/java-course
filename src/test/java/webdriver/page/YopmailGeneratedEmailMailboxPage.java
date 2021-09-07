package webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class YopmailGeneratedEmailMailboxPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='mctn']/div[@class='m']//span[text()='Google Cloud Sales']/../..")
    private WebElement emailBlock;

    @FindBy(xpath = "//*[@id='mail']//td[2]/h3")
    private WebElement totalEstimateMonthlyCoastField;

    @FindBy(xpath = "//*[@id='refresh']")
    private WebElement refreshMailboxButton;

    @FindBy(xpath = "//*[@id='nbmail']")
    private WebElement mailsNumber;

    protected YopmailGeneratedEmailMailboxPage(WebDriver driver) {
        super(driver);
    }

    public YopmailGeneratedEmailMailboxPage getTheLatestMailFromGoogleCloudPricingCalculator() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(mailsNumber));
        while (Objects.equals(mailsNumber.getText(), "0 mail")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(refreshMailboxButton));
            refreshMailboxButton.click();
        }
        driver.switchTo().frame("ifinbox");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(emailBlock));
        emailBlock.click();
        return this;
    }

    public String getTotalEstimateMonthlyCoastField() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("ifmail");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(totalEstimateMonthlyCoastField));
        return totalEstimateMonthlyCoastField.getText();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
