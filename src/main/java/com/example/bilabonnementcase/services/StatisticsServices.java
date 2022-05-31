package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.repositories.StatisticsRepository;

//Author: Kenneth
public class StatisticsServices {

    StatisticsRepository sr = new StatisticsRepository();

    public int rentedCars(){
        return sr.carsRented();
    }

    public int valueOfRentedCars(){
        return sr.valueOfRentedCars();
    }

}
