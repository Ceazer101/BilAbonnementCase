package com.example.bilabonnementcase.models;

import java.sql.Blob;

public class LeaseContract {

    private int contractId;
    private String salesPerson;
    private Car car;
    private Blob file;

    public LeaseContract(int contractId, String salesPerson, Car car, Blob file) {
        this.contractId = contractId;
        this.salesPerson = salesPerson;
        this.car = car;
        this.file = file;
    }

    public int getContractId() {
        return contractId;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public Car getCar() {
        return car;
    }

    public Blob getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "leaseContract{" +
                "contractId=" + contractId +
                ", salesPerson='" + salesPerson + '\'' +
                ", car=" + car +
                ", file=" + file +
                '}';
    }
}
