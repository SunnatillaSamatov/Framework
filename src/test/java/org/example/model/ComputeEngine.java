package org.example.model;


public class ComputeEngine {
    private String instances;
    private String series ;
    private String machineType ;
    private String gpuModel ;
    private String gpuNumber ;
    private String localSSD ;
    private String dataCenterLocation ;
    private String committedUsage ;

    public String getInstances() {
        return instances;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public String getGpuNumber() {
        return gpuNumber;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public ComputeEngine(String instances, String series, String machineType, String gpuModel, String gpuNumber, String localSSD, String dataCenterLocation, String committedUsage) {
        this.instances = instances;
        this.series = series;
        this.machineType = machineType;
        this.gpuModel = gpuModel;
        this.gpuNumber = gpuNumber;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.committedUsage = committedUsage;

    }
}
