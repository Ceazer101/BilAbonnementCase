package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.Car;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;
import java.sql.*;
import java.util.ArrayList;

//Author: Kenn
public class StatisticsRepository implements IStatRepository <Car> {

    private Connection conn;


    public StatisticsRepository(){
        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public int carsRented(){
        ArrayList<Car> allcars = new ArrayList<Car>();
        int isCarRented = 1;

        int rentedCars = 0;
        int carNumber, steelPrice, registrationCharge, co2Discharge;
        String chassisNumber, brand, model, equipmentLevel;
        boolean rented;


        String sqlString = "SELECT *  FROM owxws8zh8rp2amnk.cars " +
                "WHERE (`is_rented` = ? )";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sqlString);

            pstmt.setInt(1, isCarRented);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                carNumber = rs.getInt(1);
                chassisNumber = rs.getString(2);
                brand = rs.getString(3);
                model = rs.getString(4);
                equipmentLevel = rs.getString(5);
                steelPrice = rs.getInt(6);
                registrationCharge = rs.getInt(7);
                co2Discharge = rs.getInt(8);
                rented = rs.getBoolean(9);

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


    @Override
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
