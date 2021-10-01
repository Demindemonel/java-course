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

    @FindBy(id = "input_68")
    private WebElement numberOfInstancesField;

    @FindBy(id = "select_81")
    private WebElement operationSystemSoftwareDropdown;

    @FindBy(id = "select_option_70")
    private WebElement operationSystemSoftwareFreeOption;

    @FindBy(id = "select_85")
    private WebElement machineClassDropdown;

    @FindBy(id = "select_option_83")
    private WebElement machineClassOption;

    @FindBy(id = "select_91")
    private WebElement machineFamilyDropdown;

    @FindBy(id = "select_option_87")
    private WebElement machineFamilyOption;

    @FindBy(id = "select_93")
    private WebElement seriesDropdown;

    @FindBy(id = "select_option_202")
    private WebElement seriesOption;

    @FindBy(id = "select_95")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(id = "select_432")
    private WebElement numberOfGPUsDropdown;

    @FindBy(id = "select_option_437")
    private WebElement numberOfGPUsOption;

    @FindBy(id = "select_434")
    private WebElement GPUTypeDropdown;

    @FindBy(id = "select_option_444")
    private WebElement GPUTypeOption;

    @FindBy(id = "select_393")
    private WebElement localSSDDropdown;

    @FindBy(id = "select_option_419")
    private WebElement localSSDOption;

    @FindBy(id = "select_97")
    private WebElement datacenterLocationDropdown;

    @FindBy(id = "select_option_219")
    private WebElement datacenterLocationOption;

    @FindBy(id = "select_104")
    private WebElement committedUsageDropdown;

    @FindBy(id = "select_option_102")
    private WebElement committedUsageOption;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    protected GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public GoogleCloudPricingCalculatorEstimatePage fillForm() {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(computeEngineOption));
        computeEngineOption.click();


        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfInstancesField));
        numberOfInstancesField.click();
        numberOfInstancesField.sendKeys("4");

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(operationSystemSoftwareDropdown));
        operationSystemSoftwareDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(operationSystemSoftwareFreeOption));
        operationSystemSoftwareFreeOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineClassDropdown));
        machineClassDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineClassOption));
        machineClassOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineFamilyDropdown));
        machineFamilyDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineFamilyOption));
        machineFamilyOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(seriesDropdown));
        seriesDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(seriesOption));
        seriesOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineTypeDropdown));
        machineTypeDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineTypeOption));
        machineTypeOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addGPUsCheckbox));
        addGPUsCheckbox.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfGPUsDropdown));
        numberOfGPUsDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfGPUsOption));
        numberOfGPUsOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(GPUTypeDropdown));
        GPUTypeDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(GPUTypeOption));
        GPUTypeOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(localSSDDropdown));
        localSSDDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(localSSDOption));
        localSSDOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(datacenterLocationDropdown));
        datacenterLocationDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(datacenterLocationOption));
        datacenterLocationOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(committedUsageDropdown));
        committedUsageDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(committedUsageOption));
        committedUsageOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addToEstimateButton));
        addToEstimateButton.click();

        return new GoogleCloudPricingCalculatorEstimatePage(driver);
    }

    public GoogleCloudPricingCalculatorEstimatePage fillForm(ComputerEngine computerEngine) {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(computeEngineOption));
        computeEngineOption.click();


        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfInstancesField));
        numberOfInstancesField.click();
        numberOfInstancesField.sendKeys("4");

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(operationSystemSoftwareDropdown));
        operationSystemSoftwareDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(operationSystemSoftwareFreeOption));
        operationSystemSoftwareFreeOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineClassDropdown));
        machineClassDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineClassOption));
        machineClassOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineFamilyDropdown));
        machineFamilyDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineFamilyOption));
        machineFamilyOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(seriesDropdown));
        seriesDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(seriesOption));
        seriesOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineTypeDropdown));
        machineTypeDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(machineTypeOption));
        machineTypeOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addGPUsCheckbox));
        addGPUsCheckbox.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfGPUsDropdown));
        numberOfGPUsDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfGPUsOption));
        numberOfGPUsOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(GPUTypeDropdown));
        GPUTypeDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(GPUTypeOption));
        GPUTypeOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(localSSDDropdown));
        localSSDDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(localSSDOption));
        localSSDOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(datacenterLocationDropdown));
        datacenterLocationDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(datacenterLocationOption));
        datacenterLocationOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(committedUsageDropdown));
        committedUsageDropdown.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(committedUsageOption));
        committedUsageOption.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addToEstimateButton));
        addToEstimateButton.click();

        return new GoogleCloudPricingCalculatorEstimatePage(driver);
    }
}
