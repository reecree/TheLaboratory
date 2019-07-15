package com.rupert.thelaboratory.measurement;

public class Count extends MeasurementType {
    private String unit;

    public Count(String unit) {
        this.unit = unit;
    }

    public static String Name() {
        return "Count";
    }
}
