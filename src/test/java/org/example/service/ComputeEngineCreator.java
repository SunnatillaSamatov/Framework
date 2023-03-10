package org.example.service;

import org.example.model.ComputeEngine;

public class ComputeEngineCreator {

    private final static String INSTANCES = "test.data.instances";
    private final static String SERIES = "test.data.series";
    private final static String MACHINE_TYPE = "test.data.machine.type";
    private final static String GPU_MODEL = "test.data.gpu.model";
    private final static String GPU_NUMBER = "test.data.gpu.number";
    private final static String LOCAL_SSD = "test.data.local.ssd";
    private final static String DATA_CENTER_LOCATION = "test.data.data.center.location";
    private final static String COMMITTED_USAGE = "test.data.committed.usage";

    public static ComputeEngine withInputsFromProperty(){
        return new ComputeEngine(
                TestDataReader.getTestData(INSTANCES),
                TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(GPU_MODEL),
                TestDataReader.getTestData(GPU_NUMBER),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATA_CENTER_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE));
    }


}
