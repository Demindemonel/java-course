package webdriver.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.page.PastebinHomePage;

public class PastebinCreateNewPasteWithTextAndPasteExpirationAndPasteNameAndSyntaxHighlightingTest {
    private WebDriver driver;
    private PastebinHomePage pastebinHomePage;
    private final String pasteText = "git config --global user.name \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";
    private final String pasteName = "how to gain dominance among developers";

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage.openPage()
                .fillPasteTextArea(pasteText)
                .selectSyntaxHighlighting()
                .selectPasteExpiration()
                .fillPasteName(pasteName)
                .clickCreateNewPasteButton();

        new WebDriverWait(driver, pastebinHomePage.WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.source")));
    }

    @Test
    public void GetPastebinPageTitleAfterPasteCreation() {
        Assert.assertEquals(driver.getTitle(), pasteName + " - Pastebin.com", "Title after paste creation is wrong.");
    }

    @Test
    public void GetHighlightedCodeAfterPasteCreation() {
        Assert.assertEquals(pastebinHomePage.getHighlightedCodeAfterPasteCreation(), "Bash", "Highlighted code after paste creation is wrong.");
    }

    @Test
    public void GetPastebinPasteTextAfterPasteCreation() {
        Assert.assertEquals(pastebinHomePage.getPasteTextAfterPasteCreation(), pasteText, "Paste text after paste creation is wrong.");
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
