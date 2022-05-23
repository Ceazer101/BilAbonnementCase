package com.example.bilabonnementcase.models;


//Author: Güler
public class LeaseContract {

    private int contractId;
    private String salesPerson;
    private String leaseStart;
    private String leaseEnd;
    private int leasePrice;
    private String file;
    private int carNumber;

    public LeaseContract(int contractId, String salesPerson, String leaseStart, String leaseEnd, int leasePrice, String file, int carNumber) {
        this.contractId = contractId;
        this.salesPerson = salesPerson;
        this.leaseStart = leaseStart;
        this.leaseEnd = leaseEnd;
        this.leasePrice = leasePrice;
        this.file = file;
        this.carNumber = carNumber;
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

    public String getLeaseStart() {
        return leaseStart;
    }

    public String getLeaseEnd() {
        return leaseEnd;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public String getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "contractId=" + contractId +
                ", salesPerson='" + salesPerson + '\'' +
                ", leaseStart='" + leaseStart + '\'' +
                ", leaseEnd='" + leaseEnd + '\'' +
                ", leasePrice=" + leasePrice +
                ", carNumber=" + carNumber +
                ", file='" + file + '\'' +
                '}';
    }
}
