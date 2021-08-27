package webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.waits.CustomConditions;

public class PastebinHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement pasteTextArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "[type=''submit']")
    private WebElement createNewPasteButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().window().fullscreen();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jQueryAJAXCompleted());
        return this;
    }

    public PastebinHomePage fillPasteTextArea(String pasteText) {
        pasteTextArea.sendKeys(pasteText);
        return this;
    }

    public PastebinHomePage selectPasteExpiration() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(pasteExpiration));
        pasteExpiration.click();

        WebElement pasteExpirationOption = driver.findElement(By.xpath("//li[text()='10 Minutes']"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(pasteExpirationOption));
        pasteExpirationOption.click();
        
        return this;
    }

    public PastebinHomePage fillPasteName(String name) {
        pasteName.sendKeys(name);
        return this;
    }
}
