package com.example.bilabonnementcase.models;

//Author: Güler, Maja
public class Car {

    private int carNumber;
    private String chassisNumber;
    private String brand;
    private String model;
    private String equipmentLevel;
    private int steelPrice;
    private int registrationCharge;
    private int co2Discharge;
    private boolean rented;

    public Car(int carNumber, String chassisNumber, String brand, String model,
               String equipmentLevel, int steelPrice, int registrationCharge, int co2Discharge, boolean rented) {
        this.carNumber = carNumber;
        this.chassisNumber = chassisNumber;
        this.brand = brand;
        this.model = model;
        this.equipmentLevel = equipmentLevel;
        this.steelPrice = steelPrice;
        this.registrationCharge = registrationCharge;
        this.co2Discharge = co2Discharge;
        this.rented = rented;
    }

    public int getCarNumber() {
        return carNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber=" + carNumber +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", equipmentLevel='" + equipmentLevel + '\'' +
                ", steelPrice=" + steelPrice +
                ", registrationCharge=" + registrationCharge +
                ", co2Discharge=" + co2Discharge +
                ", rented=" + rented +
                '}';
    }
}
