package webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.model.ComputerEngine;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='mainForm']//md-tab-item[1]")
    private WebElement computeEngineOption;

    @FindBy(xpath = "//md-input-container[label[contains(.,'Number of instances')]]/input")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-input-container[label[contains(.,'System / Software')]]/md-select")
    private WebElement operationSystemSoftwareDropdown;

    @FindBy(xpath = "//md-input-container[label[contains(.,'Machine Class')]]/md-select")
    private WebElement machineClassDropdown;

    @FindBy(xpath = "//md-input-container[label[contains(.,'Machine Family')]]/md-select")
    private WebElement machineFamilyDropdown;

    @FindBy(xpath = "//md-input-container[label[contains(.,'Series')]]/md-select")
    private WebElement seriesDropdown;

    @FindBy(xpath = "//md-input-container[label[contains(.,'Machine type')]]/md-select")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-input-container[label[contains(.,'GPU type')]]/md-select")
    private WebElement GPUTypeDropdown;

    @FindBy(xpath = "//md-input-container[label[contains(.,'Number of GPUs')]]/md-select")
    private WebElement numberOfGPUsDropdown;

    @FindBy(xpath = "//md-input-container[label[contains(.,'Local SSD')]]/md-select")
    private WebElement localSSDDropdown;

    @FindBy(xpath = "//md-input-container[label[contains(.,'Datacenter location')]]/md-select")
    private WebElement datacenterLocationDropdown;

    @FindBy(xpath = "//md-input-container[label[contains(.,'Committed usage')]]/md-select")
    private WebElement committedUsageDropdown;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    protected GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public GoogleCloudPricingCalculatorEstimatePage fillForm(ComputerEngine computerEngine) {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(computeEngineOption));
        computeEngineOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfInstancesField));
        numberOfInstancesField.click();
        numberOfInstancesField.sendKeys(computerEngine.getNumberOfInstances());

        selectDropdownOption(operationSystemSoftwareDropdown, computerEngine.getOperationSystemSoftware());
        selectDropdownOption(machineClassDropdown, computerEngine.getMachineClass());
        selectDropdownOption(machineFamilyDropdown, computerEngine.getMachineFamily());
        selectDropdownOption(seriesDropdown, computerEngine.getSeries());
        selectDropdownOption(machineTypeDropdown, computerEngine.getMachineType());

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addGPUsCheckbox));
        addGPUsCheckbox.click();

        selectDropdownOption(GPUTypeDropdown, computerEngine.getGPUType());
        selectDropdownOption(numberOfGPUsDropdown, computerEngine.getNumberOfGPUs());
        selectDropdownOption(localSSDDropdown, computerEngine.getLocalSSD());
        selectDropdownOption(datacenterLocationDropdown, computerEngine.getDatacenterLocation());
        selectDropdownOption(committedUsageDropdown, computerEngine.getCommittedUsage());

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addToEstimateButton));
        addToEstimateButton.click();

        return new GoogleCloudPricingCalculatorEstimatePage(driver);
    }

    private void selectDropdownOption(WebElement dropdownSelector, String dropdownOptionText){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(dropdownSelector));
        dropdownSelector.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='" + dropdownSelector.getAttribute("aria-owns") + "']//md-option[contains(.,'" + dropdownOptionText + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(dropdownOption));
        dropdownOption.click();
    }
}
