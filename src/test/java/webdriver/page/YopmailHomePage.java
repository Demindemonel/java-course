package webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopmailHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://yopmail.com/";

    @FindBy(xpath = "//*[@id='listeliens']/a[@href='email-generator']")
    private WebElement randomEmailButton;

    public YopmailHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YopmailHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public YopmailGeneratedEmailPage generateEmail() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(randomEmailButton));
        randomEmailButton.click();
        return new YopmailGeneratedEmailPage(driver);
    }
}
