package com.agriweigh.agriweigh.models;

import jakarta.persistence.Entity;

@Entity
public class Cow extends Animal {

    private double chestCircumference;
    private double bodyLength;

    @Override
    public double calculateWeight() {
        return (chestCircumference * chestCircumference * bodyLength) / 300;
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
