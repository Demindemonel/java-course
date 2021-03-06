package webdriver.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@role='searchbox']")
    private WebElement searchBox;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleCloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public GoogleCloudSearchResultPage searchForText(String searchText) {
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.ENTER);
        return new GoogleCloudSearchResultPage(driver, searchText);
    }
}
