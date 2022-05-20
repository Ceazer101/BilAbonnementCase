package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.LeaseContract;

import java.util.ArrayList;
import java.util.Arrays;

public class DummyLeaseRepo implements IRepository<LeaseContract>{

    ArrayList<LeaseContract> leases = new ArrayList<LeaseContract>(
            Arrays.asList(
                    new LeaseContract(1, "Chris", "2022-02-04", "2023-02-04", 666, "djdf", 2)
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
    public ArrayList<LeaseContract> getListOfObject() {
        return null;
    }

    @Override
    public boolean update(LeaseContract entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        for(LeaseContract l: leases){
            if(id == l.getContractId()){
                return true;
            }
        }
        return false;
    }
}
