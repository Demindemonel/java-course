package webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchResultPage extends AbstractPage {

    private String searchText;

    protected GoogleCloudSearchResultPage(WebDriver driver, String searchText) {
        super(driver);
        this.searchText = searchText;
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public GoogleCloudPricingCalculatorPage getSearchResultByText() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'gsc-webResult')]")));
        WebElement result = driver.findElement(By.xpath("//a[text()='" + searchText + "']|//b[text()='" + searchText + "']"));
        result.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
