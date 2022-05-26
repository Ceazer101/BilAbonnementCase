package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.Car;
import com.example.bilabonnementcase.models.LeaseContract;
import java.util.ArrayList;
import java.util.Arrays;

public class DummyStatisticsRepo {

    ArrayList<Car> carList = new ArrayList<Car>(
            Arrays.asList(
                    new Car(1, "LotR", "Mercedes", "Benz", "6", 1000, 100, 200, true),
                    new Car(2, "GoT", "Toyota", "Corolla", "3", 500, 100, 200, false),
                    new Car(3, "GoT", "Toyota", "Corolla", "3", 500, 100, 200, true)
            )
    );

    ArrayList<LeaseContract> leaseList = new ArrayList<LeaseContract>(
            Arrays.asList(
                    new LeaseContract(1, "Andre", "2022-02-22", "2022-06-01", 1000, "doc.pdf", 1),
                    new LeaseContract(2, "Andre", "2022-02-22", "2022-06-01", 1000, "doc.pdf", 2),
                    new LeaseContract(3, "Andre", "2022-02-22", "2022-06-01", 1000, "doc.pdf", 3)
            )
    );

    public int carsRented(){
        int count = 0;
        for(Car c: carList){
            if (c.isRented() == true){
                count ++;
            }
        }
        return count;
    }

    public int valueOfRentedCars(){
        int totalPrice = 0;
        for(LeaseContract l: leaseList){
            totalPrice += l.getLeasePrice();
        }
        return totalPrice;
    }
}
