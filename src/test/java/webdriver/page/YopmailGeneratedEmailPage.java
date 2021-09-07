package webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopmailGeneratedEmailPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='egen']")
    private WebElement generatedEmail;

    @FindBy(xpath = "//div[@class='nw']//button[2]")
    private WebElement openMailboxButton;

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public YopmailGeneratedEmailPage(WebDriver driver) {
        super(driver);
    }

    public String getGeneratedEmail() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(generatedEmail));
        return generatedEmail.getText();
    }

    public YopmailGeneratedEmailMailboxPage openMailBox() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(openMailboxButton));
        openMailboxButton.click();
        return new YopmailGeneratedEmailMailboxPage(driver);
    }
}
