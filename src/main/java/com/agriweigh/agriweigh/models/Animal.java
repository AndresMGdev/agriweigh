package com.agriweigh.agriweigh.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Integer age;
    private BigDecimal estimatedWeight;

    public Animal() {}
    public Animal(Long id, String code, Integer age, BigDecimal estimatedWeight) {
        this.id = id;
        this.code = code;
        this.age = age;
        this.estimatedWeight = estimatedWeight;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public BigDecimal getEstimatedWeight() {
        return estimatedWeight;
    }
    public void setEstimatedWeight(BigDecimal estimatedWeight) {
        this.estimatedWeight = estimatedWeight;
    }
    
    public abstract BigDecimal calculateWeight();

}
