package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.repositories.StatisticsRepository;

public class StatisticsServices {

    StatisticsRepository sr = new StatisticsRepository();

    public int rentedCars(){
        return sr.carsRented();
    }

    public int valueOfRentedCars(){
        return sr.valueOfRentedCars();
    }


}
