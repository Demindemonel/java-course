package webdriver.model;

import java.util.Objects;

public class ComputerEngine {
    private String numberOfInstances;
    private String operationSystemSoftware;
    private String machineClass;
    private String machineFamily;
    private String series;
    private String machineType;
    private String GPUType;
    private String numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public ComputerEngine(String numberOfInstances, String operationSystemSoftware, String machineClass, String machineFamily, String series, String machineType, String GPUType, String numberOfGPUs, String localSSD, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operationSystemSoftware = operationSystemSoftware;
        this.machineClass = machineClass;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.GPUType = GPUType;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperationSystemSoftware() {
        return operationSystemSoftware;
    }

    public void setOperationSystemSoftware(String operationSystemSoftware) {
        this.operationSystemSoftware = operationSystemSoftware;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "ComputerEngine{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operationSystemSoftware='" + operationSystemSoftware + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineFamily='" + machineFamily + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", GPUType='" + GPUType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerEngine that = (ComputerEngine) o;
        return numberOfInstances.equals(that.numberOfInstances) && operationSystemSoftware.equals(that.operationSystemSoftware) && machineClass.equals(that.machineClass) && machineFamily.equals(that.machineFamily) && series.equals(that.series) && machineType.equals(that.machineType) && numberOfGPUs.equals(that.numberOfGPUs) && GPUType.equals(that.GPUType) && localSSD.equals(that.localSSD) && datacenterLocation.equals(that.datacenterLocation) && committedUsage.equals(that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operationSystemSoftware, machineClass, machineFamily, series, machineType, numberOfGPUs, GPUType, localSSD, datacenterLocation, committedUsage);
    }
}
