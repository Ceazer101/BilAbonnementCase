package com.example.bilabonnementcase.models;

public class LeaseContract {

    private int contractId;
    private String salesPerson;
    private int leasePrice;
    private int carNumber;
    private String file;

    public LeaseContract(int contractId, String salesPerson, int leasePrice, int carNumber, String file) {
        this.contractId = contractId;
        this.salesPerson = salesPerson;
        this.leasePrice = leasePrice;
        this.carNumber = carNumber;
        this.file = file;
    }

    public int getLeasePrice() {
        return leasePrice;
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
