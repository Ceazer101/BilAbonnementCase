package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.Car;
import com.example.bilabonnementcase.services.StatisticsServices;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StatisticsRepository {

    private Connection conn;
    private Statement stmt;


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
                "WHERE (`rented` = '" + isCarRented + "')";

        try{

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet carRS = stmt.executeQuery(sqlString);
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


    public int rentedCarsValue(){
        Connection con = DatabaseConnectionManager.getConnection();
        ArrayList<Integer> prices = new ArrayList<>();
        int getPrice;
        int totalPrice = 0;

        String sqlString = "SELECT `Price` FROM owxws8zh8rp2amnk.leasecontracts ";

        try{

            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet value = stmt.executeQuery(sqlString);
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
