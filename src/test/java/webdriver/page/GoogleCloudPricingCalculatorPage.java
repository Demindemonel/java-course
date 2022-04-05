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

    @FindBy(css = ".devsite-snackbar-action")
    private WebElement acceptCookieButton;

    protected GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public GoogleCloudPricingCalculatorPage switchToCalculatorFrame(){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectComputerEngineOption(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(computeEngineOption));
        computeEngineOption.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillNumberOfInstancesField(String numberOfInstances){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfInstancesField));
        numberOfInstancesField.click();
        numberOfInstancesField.sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectOperationSystemSoftwareDropdownOption(String operationSystemSoftware){
        selectDropdownOption(operationSystemSoftwareDropdown, operationSystemSoftware);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineClassDropdownOption(String machineClass){
        selectDropdownOption(machineClassDropdown, machineClass);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineFamilyDropdownOption(String machineFamily){
        selectDropdownOption(machineFamilyDropdown, machineFamily);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectSeriesDropdownOption(String series){
        selectDropdownOption(seriesDropdown, series);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineTypeDropdownOption(String machineType){
        selectDropdownOption(machineTypeDropdown, machineType);
        return this;
    }

    public GoogleCloudPricingCalculatorPage checkAddGPUsCheckbox(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addGPUsCheckbox));
        addGPUsCheckbox.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectGPUTypeDropdownOption(String GPUType){
        selectDropdownOption(GPUTypeDropdown, GPUType);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectNumberOfGPUsDropdownOption(String numberOfGPUs){
        selectDropdownOption(numberOfGPUsDropdown, numberOfGPUs);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSDDropdownOption(String localSSD){
        selectDropdownOption(localSSDDropdown, localSSD);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDatacenterLocationDropdownOption(String datacenterLocation){
        selectDropdownOption(datacenterLocationDropdown, datacenterLocation);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommittedUsageDropdownOption(String committedUsage){
        selectDropdownOption(committedUsageDropdown, committedUsage);
        return this;
    }

    public GoogleCloudPricingCalculatorEstimatePage clickAddToEstimateButton() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addToEstimateButton));
        addToEstimateButton.click();
        return new GoogleCloudPricingCalculatorEstimatePage(driver);
    }

    public GoogleCloudPricingCalculatorEstimatePage fillForm(ComputerEngine computerEngine){
        return switchToCalculatorFrame()
                .selectComputerEngineOption()
                .fillNumberOfInstancesField(computerEngine.getNumberOfInstances())
                .selectComputerEngineOption()
                .selectOperationSystemSoftwareDropdownOption(computerEngine.getOperationSystemSoftware())
                .selectMachineClassDropdownOption(computerEngine.getMachineClass())
                .selectMachineFamilyDropdownOption(computerEngine.getMachineFamily())
                .selectSeriesDropdownOption(computerEngine.getSeries())
                .selectMachineTypeDropdownOption(computerEngine.getMachineType())
                .checkAddGPUsCheckbox()
                .selectGPUTypeDropdownOption(computerEngine.getGPUType())
                .selectNumberOfGPUsDropdownOption(computerEngine.getNumberOfGPUs())
                .selectLocalSSDDropdownOption(computerEngine.getLocalSSD())
                .selectDatacenterLocationDropdownOption(computerEngine.getDatacenterLocation())
                .selectCommittedUsageDropdownOption(computerEngine.getCommittedUsage())
                .clickAddToEstimateButton();
    }

    private void selectDropdownOption(WebElement dropdownSelector, String dropdownOptionText) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(dropdownSelector));
        dropdownSelector.click();
        WebElement dropdownOption = driver.findElement(
                By.xpath("//*[@id='" + dropdownSelector.getAttribute("aria-owns") + "']" +
                        "//md-option[contains(.,'" + dropdownOptionText + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(dropdownOption));
        dropdownOption.click();
    }

    public GoogleCloudPricingCalculatorPage clickAcceptCookieButton(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
        acceptCookieButton.click();
        return this;
    }
}
