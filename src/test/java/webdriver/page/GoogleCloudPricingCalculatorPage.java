package webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='mainForm']/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]")
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

    @FindBy(id = "select_option_398")
    private WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@aria-label = 'Add GPUs']")
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
        computeEngineOption.click();

        numberOfGPUsDropdown.click();
        numberOfGPUsOption.click();

        operationSystemSoftwareDropdown.click();
        operationSystemSoftwareFreeOption.click();

        machineClassDropdown.click();
        machineClassOption.click();

        machineFamilyDropdown.click();
        machineFamilyOption.click();

        seriesDropdown.click();
        seriesOption.click();

        machineTypeDropdown.click();
        machineTypeOption.click();

        addGPUsCheckbox.click();

        numberOfGPUsDropdown.click();
        numberOfGPUsOption.click();

        GPUTypeDropdown.click();
        GPUTypeOption.click();

        localSSDDropdown.click();
        localSSDOption.click();

        datacenterLocationDropdown.click();
        datacenterLocationOption.click();

        committedUsageDropdown.click();
        committedUsageOption.click();

        addToEstimateButton.click();

        return new GoogleCloudPricingCalculatorEstimatePage(driver);
    }
}
