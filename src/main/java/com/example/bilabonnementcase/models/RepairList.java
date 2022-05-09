package com.example.bilabonnementcase.models;

public class RepairList {

    private int repairListId;
    private String damageTitle;
    private String missingCarPieceTitle;
    private String damageDescription;
    private String missingCarPieceDescription;
    private double damagePrice;
    private Car carNumber;

    public RepairList(int repairListId, String damageTitle, String missingCarPieceTitle, String damageDescription,
                      String missingCarPieceDescription, double damagePrice, Car carNumber) {
        this.repairListId = repairListId;
        this.damageTitle = damageTitle;
        this.missingCarPieceTitle = missingCarPieceTitle;
        this.damageDescription = damageDescription;
        this.missingCarPieceDescription = missingCarPieceDescription;
        this.damagePrice = damagePrice;
        this.carNumber = carNumber;
    }

    public int getRepairListId() {
        return repairListId;
    }

    public String getDamageTitle() {
        return damageTitle;
    }

    public String getMissingCarPieceTitle() {
        return missingCarPieceTitle;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public String getMissingCarPieceDescription() {
        return missingCarPieceDescription;
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
                ", missingCarPieceTitle='" + missingCarPieceTitle + '\'' +
                ", damageDescription='" + damageDescription + '\'' +
                ", missingCarPieceDescription='" + missingCarPieceDescription + '\'' +
                ", damagePrice=" + damagePrice +
                ", carNumber=" + carNumber +
                '}';
    }
}
