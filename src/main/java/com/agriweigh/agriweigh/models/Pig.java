package com.agriweigh.agriweigh.models;

public class Pig extends Animal {

    private double chestCircumference;
    private double bodyLength;

    @Override
    public double calculateWeight() {
        return (bodyLength * chestCircumference) / 200;
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
