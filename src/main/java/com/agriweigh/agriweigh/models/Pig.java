package com.agriweigh.agriweigh.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jakarta.persistence.Entity;

@Entity
public class Pig extends Animal {

    private double chestCircumference;
    private double bodyLength;

    public Pig(){}

    public Pig(double estimatedWeight, double chestCircumference,
            double bodyLength) {
        super();
        this.chestCircumference = chestCircumference;
        this.bodyLength = bodyLength;
    }

    @Override
    public BigDecimal calculateWeight() {
        BigDecimal weight = BigDecimal.valueOf(chestCircumference * chestCircumference * bodyLength * 69.3)
            .divide(BigDecimal.valueOf(1), 2, RoundingMode.HALF_UP);
        return weight;
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
