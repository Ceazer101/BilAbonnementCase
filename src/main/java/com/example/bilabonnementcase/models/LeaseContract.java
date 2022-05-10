package com.example.bilabonnementcase.models;

import java.sql.Blob;

public class LeaseContract {

    private int contractId;
    private String salesPerson;
    private String leasePeriod;
    private int car;
    private String file;

    public LeaseContract(int contractId, String salesPerson, String leasePeriod, int car, String file) {
        this.contractId = contractId;
        this.salesPerson = salesPerson;
        this.leasePeriod = leasePeriod;
        this.car = car;
        this.file = file;
    }

    public String getLeasePeriod() {
        return leasePeriod;
    }

    public int getContractId() {
        return contractId;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public int getCar() {
        return car;
    }

    public String getFile() {
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
