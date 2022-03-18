package webdriver.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.waits.CustomConditions;

public class PastebinHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
            + "var elementTop = arguments[0].getBoundingClientRect().top;"
            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

    @FindBy(id = "postform-text")
    private WebElement pasteTextArea;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlighting;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createNewPasteButton;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement syntaxHighlightingOption;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationOption;

    @FindBy(css = "div.source > ol")
    private WebElement pasteTextAfterPasteCreation;

    @FindBy(css = ".highlighted-code a")
    private WebElement highlightedCodeAfterPasteCreation;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jQueryAJAXCompleted());
        return this;
    }

    public PastebinHomePage fillPasteTextArea(String pasteText) {
        pasteTextArea.sendKeys(pasteText);
        return this;
    }

    public PastebinHomePage selectSyntaxHighlighting() {
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, syntaxHighlighting);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(syntaxHighlighting));
        syntaxHighlighting.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(syntaxHighlightingOption));
        syntaxHighlightingOption.click();

        return this;
    }

    public PastebinHomePage selectPasteExpiration() {
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, pasteExpiration);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(pasteExpiration));
        pasteExpiration.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(pasteExpirationOption));
        pasteExpirationOption.click();

        return this;
    }

    public PastebinHomePage fillPasteName(String name) {
        pasteName.sendKeys(name);
        return this;
    }

    public PastebinHomePage clickCreateNewPasteButton() {
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, createNewPasteButton);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(createNewPasteButton));
        createNewPasteButton.click();
        return this;
    }

    public String getPasteTextAfterPasteCreation() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(pasteTextAfterPasteCreation));
        return pasteTextAfterPasteCreation.getText();
    }

    public String getHighlightedCodeAfterPasteCreation() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(highlightedCodeAfterPasteCreation));
        return highlightedCodeAfterPasteCreation.getText();
    }
}
