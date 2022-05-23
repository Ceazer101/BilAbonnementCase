package com.example.bilabonnementcase.models;


//Author: Güler
public class RepairList {

    private int repairListId;
    private String repairStart;
    private int carNumber;

    public RepairList(int repairListId, String repairStart, int carNumber) {
        this.repairListId = repairListId;
        this.repairStart = repairStart;
        this.carNumber = carNumber;
    }

    public RepairList(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getRepairListId() {
        return repairListId;
    }

    public String getRepairStart() {
        return repairStart;
    }

    public int getCarNumber() {
        return carNumber;
    }

    @Override
    public String toString() {
        return "RepairList{" +
                "repairListId=" + repairListId +
                ", repairStart='" + repairStart + '\'' +
                ", carNumber=" + carNumber +
                '}';
    }
}
