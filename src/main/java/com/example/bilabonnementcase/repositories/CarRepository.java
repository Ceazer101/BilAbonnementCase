package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.Car;

public class CarRepository {

    //Skal ikke bruges, men kan genbruges til andet.
/*
    public boolean validateLicensePlate(Car car){
        boolean isValid = true;
        String plateNumber = car.getLicensePlate().toUpperCase();

        int numberLength = plateNumber.length();
        if (numberLength != 7){
            isValid = false;
        }

        for(int i = 0; i < 2; i++){
            if (plateNumber.charAt(i) < 'A' || plateNumber.charAt(i) > 'Z'){
                isValid = false;
            }
        }

        for(int i = 2; i < 7; i++){
            if (plateNumber.charAt(i) < '0' || plateNumber.charAt(i) > '9'){
                isValid = false;
            }
        }

        return isValid;
    }*/



}
