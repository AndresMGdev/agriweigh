package com.agriweigh.agriweigh.models;

public class Horse extends Animal {

    private double chestCircumference;
    private double bodyLength;

    @Override
    public double calculateWeight() {
        return (bodyLength * chestCircumference) / 250;
    }

    public double getChestCircumference() {
        return chestCircumference;
    }
    public void setChestCircumference(double chestCircumference) {
        this.chestCircumference = chestCircumference;
    }
    public double getBodyLength() {
        return bodyLength;
    }
    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    
}
