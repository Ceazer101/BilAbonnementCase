package com.example.bilabonnementcase.models;

public class RepairList {

    private int repairListId;
    private String damageTitle;
    private String damageDescription;
    private double damagePrice;
    private Car carNumber;

    public RepairList(int repairListId, String damageTitle, String damageDescription, double damagePrice, Car carNumber) {
        this.repairListId = repairListId;
        this.damageTitle = damageTitle;
        this.damageDescription = damageDescription;
        this.damagePrice = damagePrice;
        this.carNumber = carNumber;
    }

    public int getRepairListId() {
        return repairListId;
    }

    public String getDamageTitle() {
        return damageTitle;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public double getDamagePrice() {
        return damagePrice;
    }

    public Car getCarNumber() {
        return carNumber;
    }

    @Override
    public String toString() {
        return "RepairList{" +
                "repairListId=" + repairListId +
                ", damageTitle='" + damageTitle + '\'' +
                ", damageDescription='" + damageDescription + '\'' +
                ", damagePrice=" + damagePrice +
                ", carNumber=" + carNumber +
                '}';
    }
}
