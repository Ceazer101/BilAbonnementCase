package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.LeaseContract;

import java.util.ArrayList;
import java.util.Arrays;

public class DummyLeaseRepo implements IRepository<LeaseContract>{

    ArrayList<LeaseContract> leases = new ArrayList<LeaseContract>(
            Arrays.asList(
                    new LeaseContract(-1, "Chris", 666, 2, "djdf")
            )
    );

    @Override
    public boolean create(LeaseContract entity) {
        for(LeaseContract l: leases){
            if(entity.getCarNumber() == l.getCarNumber()){
                return false;
            }
        }
        return true;
    }

    @Override
    public LeaseContract getEntityById(int id) {
        return null;
    }

    @Override
    public boolean update(LeaseContract entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}