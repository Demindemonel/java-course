package webdriver.service;

import webdriver.model.ComputerEngine;

public class ComputerEngineCreator {
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.computeengine.numberofinstances";
    public static final String TESTDATA_OPERATION_SYSTEM_SOFTWARE = "testdata.computeengine.operationsystemsoftware";
    public static final String TESTDATA_MACHINE_CLASS = "testdata.computeengine.machineclass";
    public static final String TESTDATA_MACHINE_FAMILY = "testdata.computeengine.machinefamily";
    public static final String TESTDATA_SERIES = "testdata.computeengine.series";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.computeengine.machinetype";
    public static final String TESTDATA_GPU_TYPE = "testdata.computeengine.gputype";
    public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.computeengine.numberofgpus";
    public static final String TESTDATA_LOCAL_SSD = "testdata.computeengine.localssd";
    public static final String TESTDATA_DATACENTER_LOCATION = "testdata.computeengine.datacenterlocation";
    public static final String TESTDATA_COMMITTED_USAGE = "testdata.computeengine.committedusage";

    public static ComputerEngine withSettingFromProperty() {
        return new ComputerEngine(TESTDATA_NUMBER_OF_INSTANCES,
                TESTDATA_OPERATION_SYSTEM_SOFTWARE,
                TESTDATA_MACHINE_CLASS,
                TESTDATA_MACHINE_FAMILY,
                TESTDATA_SERIES,
                TESTDATA_MACHINE_TYPE,
                TESTDATA_GPU_TYPE,
                TESTDATA_NUMBER_OF_GPUS,
                TESTDATA_LOCAL_SSD,
                TESTDATA_DATACENTER_LOCATION,
                TESTDATA_COMMITTED_USAGE);
    }

    public static ComputerEngine withSettingByDefault() {
        return new ComputerEngine(
                "4",
                "Free",
                "Regular",
                "General purpose",
                "N1",
                "n1-standard-8",
                "NVIDIA Tesla P100",
                "2",
                "2x375 GB",
                "Frankfurt (europe-west3)",
                "1 Year");
    }
}
