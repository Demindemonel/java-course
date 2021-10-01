package webdriver.service;

import webdriver.model.ComputerEngine;

public class ComputerEngineCreator {
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.user.name";
    public static final String TESTDATA_OPERATION_SYSTEM_SOFTWARE = "";
    public static final String TESTDATA_MACHINE_CLASS = "";
    public static final String TESTDATA_MACHINE_FAMILY = "";
    public static final String TESTDATA_SERIES = "";
    public static final String TESTDATA_MACHINE_TYPE = "";
    public static final String TESTDATA_NUMBER_OF_GPUS = "";
    public static final String TESTDATA_GPU_TYPE = "";
    public static final String TESTDATA_LOCAL_SSD = "";
    public static final String TESTDATA_DATACENTER_LOCATION = "";
    public static final String TESTDATA_COMMITTED_USAGE = "";

    public static ComputerEngine withSettingFromProperty() {
        return new ComputerEngine(TESTDATA_NUMBER_OF_INSTANCES,
                TESTDATA_OPERATION_SYSTEM_SOFTWARE,
                TESTDATA_MACHINE_CLASS,
                TESTDATA_MACHINE_FAMILY,
                TESTDATA_SERIES,
                TESTDATA_MACHINE_TYPE,
                TESTDATA_NUMBER_OF_GPUS,
                TESTDATA_GPU_TYPE,
                TESTDATA_LOCAL_SSD,
                TESTDATA_DATACENTER_LOCATION,
                TESTDATA_COMMITTED_USAGE);
    }
}
