package com.example.bilabonnementcase.models;

public class RepairList {

    private int repairListId;
    private int damage;
    private String repairStart;
    private int carNumber;

    public RepairList(int repairListId, int damage, String repairStart, int carNumber) {
        this.repairListId = repairListId;
        this.damage = damage;
        this.repairStart = repairStart;
        this.carNumber = carNumber;
    }

    public int getRepairListId() {
        return repairListId;
    }

    public int getDamage() {
        return damage;
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
                ", damage=" + damage +
                ", repairStart='" + repairStart + '\'' +
                ", carNumber=" + carNumber +
                '}';
    }
}
