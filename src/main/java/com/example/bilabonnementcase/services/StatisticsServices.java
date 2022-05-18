package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.models.Car;
import com.example.bilabonnementcase.repositories.StatisticsRepository;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.*;
import java.util.ArrayList;

public class StatisticsServices {

    StatisticsRepository sr = new StatisticsRepository();

    public int rentedCars(){
        return sr.carsRented();
    }

    public int valueOfRentedCars(){
        return sr.rentedCarsValue();
    }


}
