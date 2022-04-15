package webdriver.service;

import webdriver.model.ComputerEngine;
import webdriver.page.GoogleCloudPricingCalculatorEstimatePage;
import webdriver.page.GoogleCloudPricingCalculatorPage;

public class BusinessGoogleCloudPricingCalculator {
    private GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;

    public BusinessGoogleCloudPricingCalculator(GoogleCloudPricingCalculatorPage page) {
        this.googleCloudPricingCalculatorPage = page;
    }

    public GoogleCloudPricingCalculatorEstimatePage fillForm(ComputerEngine computerEngine) {
        return this.googleCloudPricingCalculatorPage
                .switchToCalculatorFrame()
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
}
