package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.Car;
import com.example.bilabonnementcase.services.StatisticsServices;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;


public class StatisticsRepository {

    private Connection conn;

    public StatisticsRepository(){
        this.conn = DatabaseConnectionManager.getConnection();
    }


    public int carsRented(){
        ArrayList<Car> allcars = new ArrayList<Car>();
        int isCarRented = 1;

        int rentedCars = 0;
        int carNumber ;
        String chassisNumber;
        String brand;
        String model;
        String equipmentLevel;
        int steelPrice;
        int registrationCharge;
        int co2Discharge;
        boolean rented;

        String sqlString = "SELECT *  FROM owxws8zh8rp2amnk.cars " +
                "WHERE (`is_rented` = '" + isCarRented + "')";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sqlString);

            ResultSet carRS = pstmt.executeQuery();
            while(carRS.next()){
                carNumber = carRS.getInt(1);
                chassisNumber = carRS.getString(2);
                brand = carRS.getString(3);
                model = carRS.getString(4);
                equipmentLevel = carRS.getString(5);
                steelPrice = carRS.getInt(6);
                registrationCharge = carRS.getInt(7);
                co2Discharge = carRS.getInt(8);
                rented = carRS.getBoolean(9);

                Car tempCar = new Car(carNumber, chassisNumber, brand, model, equipmentLevel,
                        steelPrice , registrationCharge, co2Discharge, rented);

                allcars.add(tempCar);

                rentedCars = allcars.size();

            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return rentedCars;
    }


    public int valueOfRentedCars(){
        ArrayList<Integer> prices = new ArrayList<>();
        int getPrice;
        int totalPrice = 0;

        String sqlString = "SELECT `lease_price` FROM owxws8zh8rp2amnk.leasecontracts ";

        try{

            PreparedStatement pstmt = conn.prepareStatement(sqlString);

            ResultSet value = pstmt.executeQuery();
            while(value.next()){
                 getPrice = Integer.parseInt(value.getString(1));
                 prices.add(getPrice);
            }

            for(int i = 0; i < prices.size(); i++){
                totalPrice += prices.get(i);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return totalPrice;

    }
}
