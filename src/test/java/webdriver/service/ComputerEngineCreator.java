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

    public static ComputerEngine withSettingByDefault() {
        return new ComputerEngine(
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATION_SYSTEM_SOFTWARE),
                TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),
                TestDataReader.getTestData(TESTDATA_MACHINE_FAMILY),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }
}
