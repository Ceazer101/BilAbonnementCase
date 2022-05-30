package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.Car;
import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.models.RepairList;
import java.util.ArrayList;
import java.util.Arrays;

//Author: Chris
public class DummyRepairlistRepo {

    ArrayList<RepairList> repairList = new ArrayList<>(
            Arrays.asList(
                    new RepairList(1, "2022-02-22", 2),
                    new RepairList(2, "2022-02-22", 4),
                    new RepairList(3, "2022-02-22", 6)
            )
    );

    ArrayList<LeaseContract> leaseList = new ArrayList<>(
            Arrays.asList(
                    new LeaseContract(1, "Andre", "2022-02-22", "2022-06-01", 1000, "doc.pdf", 1),
                    new LeaseContract(2, "Andre", "2022-02-22", "2022-06-01", 1000, "doc.pdf", 2),
                    new LeaseContract(3, "Andre", "2022-02-22", "2022-06-01", 1000, "doc.pdf", 3)
            )
    );

    ArrayList<Car> carList = new ArrayList<>(
            Arrays.asList(
                    new Car(1, "LotR", "Mercedes", "Benz", "6", 1000, 100, 200, true),
                    new Car(2, "GoT", "Toyota", "Corolla", "3", 500, 100, 200, false),
                    new Car(3, "GoT", "Toyota", "Corolla", "3", 500, 100, 200, true)
            )
    );

    public int getRepairListIdFromCarNumber(int carNumber){
        int repairListId = -1;
        for (RepairList r: repairList){
            if (carNumber == r.getCarNumber()){
                repairListId = r.getRepairListId();
            }
        }
        return repairListId;
    }


}
