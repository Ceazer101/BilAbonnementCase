package com.example.bilabonnementcase.models;

//Author: Chris
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

    public Damage(int damageId, String damageTitle, String damageDescription, int damagePrice) {
        this.damageId = damageId;
        this.damageTitle = damageTitle;
        this.damageDescription = damageDescription;
        this.damagePrice = damagePrice;
    }

    public String getDamageTitle() {
        return damageTitle;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public int getDamagePrice() {
        return damagePrice;
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
