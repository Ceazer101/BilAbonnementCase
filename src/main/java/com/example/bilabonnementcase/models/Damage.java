package com.example.bilabonnementcase.models;

public class Damage {

    private int damageId;
    private String damageTitle;
    private String damageDescription;
    private int damagePrice;
    private int repairListId;

    public Damage(int damageId, String damageTitle, String damageDescription, int damagePrice, int repairListId) {
        this.damageId = damageId;
        this.damageTitle = damageTitle;
        this.damageDescription = damageDescription;
        this.damagePrice = damagePrice;
        this.repairListId = repairListId;
    }

    public int getDamageId() {
        return damageId;
    }

    public String getDamageTitle() {
        return damageTitle;
    }

    public void setDamageTitle(String damageTitle) {
        this.damageTitle = damageTitle;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public int getDamagePrice() {
        return damagePrice;
    }

    public void setDamagePrice(int damagePrice) {
        this.damagePrice = damagePrice;
    }

    public int getRepairListId() {
        return repairListId;
    }

    public void setRepairListId(int repairListId) {
        this.repairListId = repairListId;
    }

    @Override
    public String toString() {
        return "Damage{" +
                "damageId=" + damageId +
                ", damageTitle='" + damageTitle + '\'' +
                ", damageDescription='" + damageDescription + '\'' +
                ", damagePrice=" + damagePrice +
                ", repairListId=" + repairListId +
                '}';
    }
}
