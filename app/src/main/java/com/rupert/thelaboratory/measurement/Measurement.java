package com.rupert.thelaboratory.measurement;

public class Measurement {
    private String name;
    private MeasurementType type;

    public Measurement(String name, MeasurementType type){
        this.name = name;
        this.type = type;
    }

    public String GetName() {
        return this.name;
    }
}
