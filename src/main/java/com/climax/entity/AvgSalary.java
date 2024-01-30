/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.climax.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Kadsuke
 */
public class AvgSalary {
    
    private final SimpleStringProperty profession;
    private final SimpleDoubleProperty averageSalary;

    public AvgSalary(String profession, double averageSalary) {
        this.profession = new SimpleStringProperty(profession);
        this.averageSalary = new SimpleDoubleProperty(averageSalary);
    }

    public String getProfession() {
        return profession.get();
    }

    public SimpleStringProperty getProfessionProperty() {
        return profession;
    }

    public double getAverageSalary() {
        return averageSalary.get();
    }

    public SimpleDoubleProperty getAverageSalaryProperty() {
        return averageSalary;
    }
}
