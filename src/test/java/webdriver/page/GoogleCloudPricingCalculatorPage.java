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

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(operationSystemSoftwareDropdown));
        operationSystemSoftwareDropdown.click();
        WebElement operationSystemSoftwareFreeOption = driver.findElement(By.xpath("//*[@id='" + operationSystemSoftwareDropdown.getAttribute("aria-owns") + "']//md-option[contains(.,'" + computerEngine.getOperationSystemSoftware() + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(operationSystemSoftwareFreeOption));
        operationSystemSoftwareFreeOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineClassDropdown));
        machineClassDropdown.click();
        WebElement machineClassOption = driver.findElement(By.xpath("//*[@id='" + machineClassDropdown.getAttribute("aria-owns") + "']//md-option[contains(.,'" + computerEngine.getMachineClass() + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineClassOption));
        machineClassOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineFamilyDropdown));
        machineFamilyDropdown.click();
        WebElement machineFamilyOption = driver.findElement(By.xpath("//*[@id='" + machineFamilyDropdown.getAttribute("aria-owns") + "']//md-option[contains(.,'" + computerEngine.getMachineFamily() + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineFamilyOption));
        machineFamilyOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(seriesDropdown));
        seriesDropdown.click();
        WebElement seriesOption = driver.findElement(By.xpath("//*[@id='" + seriesDropdown.getAttribute("aria-owns") + "']//md-option[contains(.,'" + computerEngine.getSeries() + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(seriesOption));
        seriesOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineTypeDropdown));
        machineTypeDropdown.click();
        WebElement machineTypeOption = driver.findElement(By.xpath("//*[@id='" + machineTypeDropdown.getAttribute("aria-owns") + "']//md-option[contains(.,'" + computerEngine.getMachineType() + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineTypeOption));
        machineTypeOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addGPUsCheckbox));
        addGPUsCheckbox.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(GPUTypeDropdown));
        GPUTypeDropdown.click();
        WebElement GPUTypeOption = driver.findElement(By.xpath("//*[@id='" + GPUTypeDropdown.getAttribute("aria-owns") + "']//md-option[contains(.,'" + computerEngine.getGPUType() + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(GPUTypeOption));
        GPUTypeOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfGPUsDropdown));
        numberOfGPUsDropdown.click();
        WebElement numberOfGPUsOption = driver.findElement(By.xpath("//*[@id='" + numberOfGPUsDropdown.getAttribute("aria-owns") + "']//md-option[contains(.,'" + computerEngine.getNumberOfGPUs() + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfGPUsOption));
        numberOfGPUsOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(localSSDDropdown));
        localSSDDropdown.click();
        WebElement localSSDOption = driver.findElement(By.xpath("//*[@id='" + localSSDDropdown.getAttribute("aria-owns") + "']//md-option[contains(.,'" + computerEngine.getLocalSSD() + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(localSSDOption));
        localSSDOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(datacenterLocationDropdown));
        datacenterLocationDropdown.click();
        WebElement datacenterLocationOption = driver.findElement(By.xpath("//*[@id='" + datacenterLocationDropdown.getAttribute("aria-owns") + "']//md-option[contains(.,'" + computerEngine.getDatacenterLocation() + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(datacenterLocationOption));
        datacenterLocationOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(committedUsageDropdown));
        committedUsageDropdown.click();
        WebElement committedUsageOption = driver.findElement(By.xpath("//*[@id='" + committedUsageDropdown.getAttribute("aria-owns") + "']//md-option[contains(.,'" + computerEngine.getCommittedUsage() + "')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(committedUsageOption));
        committedUsageOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addToEstimateButton));
        addToEstimateButton.click();

        return new GoogleCloudPricingCalculatorEstimatePage(driver);
    }
}
