package com.example.bilabonnementcase.models;

import java.sql.Blob;

public class LeaseContract {

    private int contractId;
    private String salesPerson;
    private String leasePeriod;
    private int carNumber;
    private String file;

    public LeaseContract(int contractId, String salesPerson, String leasePeriod, int carNumber, String file) {
        this.contractId = contractId;
        this.salesPerson = salesPerson;
        this.leasePeriod = leasePeriod;
        this.carNumber = carNumber;
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

    public int getCarNumber() {
        return carNumber;
    }

    public String getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "leaseContract{" +
                "contractId=" + contractId +
                ", salesPerson='" + salesPerson + '\'' +
                ", car=" + carNumber +
                ", file=" + file +
                '}';
    }
}
