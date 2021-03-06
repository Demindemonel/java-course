package webdriver.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.driver.DriverSingleton;
import webdriver.page.PastebinHomePage;

public class PastebinCreateNewPasteWithTextAndPasteExpirationAndPasteNameAndSyntaxHighlightingTest {
    private WebDriver driver;
    private PastebinHomePage pastebinHomePage;
    private final String pasteText = "git config --global user.name \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";
    private final String pasteName = "how to gain dominance among developers";

    @BeforeTest(alwaysRun = true, description = "Setting up a test environment.")
    public void browserSetup() {
        driver = DriverSingleton.getDriver();

        pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage.openPage()
                .fillPasteTextArea(pasteText)
                .selectSyntaxHighlighting()
                .selectPasteExpiration()
                .fillPasteName(pasteName)
                .clickCreateNewPasteButton();

        new WebDriverWait(driver, pastebinHomePage.WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.source")));
    }

    @Test(description = "Pastebin title validation after creation")
    public void GetPastebinPageTitleAfterPasteCreation() {
        Assert.assertEquals(
                driver.getTitle(),
                pasteName + " - Pastebin.com",
                "Title after paste creation is wrong.");
    }

    @Test(description = "Check Pastebin highlighted code after creation.")
    public void GetHighlightedCodeAfterPasteCreation() {
        Assert.assertEquals(
                pastebinHomePage.getHighlightedCodeAfterPasteCreation(),
                "Bash",
                "Highlighted code after paste creation is wrong.");
    }

    @Test(description = "Pastebin paste text validation after creation.")
    public void GetPastebinPasteTextAfterPasteCreation() {
        Assert.assertEquals(
                pastebinHomePage.getPasteTextAfterPasteCreation(),
                pasteText,
                "Paste text after paste creation is wrong.");
    }

    @AfterTest(alwaysRun = true, description = "Shutting down the WebDriver instance.")
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
