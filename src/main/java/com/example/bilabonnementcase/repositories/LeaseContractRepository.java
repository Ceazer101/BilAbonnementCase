package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


//Author: Güler
public class LeaseContractRepository implements IRepository<LeaseContract> {

    private Connection conn;

    public LeaseContractRepository(){
        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public boolean create(LeaseContract entity) {
       try{
           PreparedStatement pstmt = conn.prepareStatement("INSERT INTO owxws8zh8rp2amnk.leasecontracts " +
                   "(`sales_person`, `lease_start`, `lease_end`, `lease_price`, `file`, `car_number`)"
                   + "VALUES (?,?,?,?,?,?)");

           pstmt.setString(1, entity.getSalesPerson());
           pstmt.setString(2, entity.getLeaseStart());
           pstmt.setString(3, entity.getLeaseEnd());
           pstmt.setInt(4, entity.getLeasePrice());
           pstmt.setString(5, entity.getFile());
           pstmt.setInt(6, entity.getCarNumber());

           pstmt.executeUpdate();

       } catch (SQLException e) {
           System.out.println("Something went wrong. Try again.");
           e.printStackTrace();
       }

       return true;
    }

    @Override
    public ArrayList<LeaseContract> getAllEntities() {
        ArrayList<LeaseContract> allLeases = new ArrayList<>();
        int contractId;
        String salesPerson;
        String leaseStart;
        String leaseEnd;
        int leasePrice;
        String file;
        int carNumber;

        String sqlString = ("SELECT * FROM owxws8zh8rp2amnk.leasecontracts;");

        try {
            PreparedStatement pstmt = conn.prepareStatement(sqlString);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                contractId = rs.getInt(1);
                salesPerson = rs.getString(2);
                leaseStart = rs.getString(3);
                leaseEnd = rs.getString(4);
                leasePrice = rs.getInt(5);
                file = rs.getString(6);
                carNumber = rs.getInt(7);

                LeaseContract tempList = new LeaseContract(contractId, salesPerson, leaseStart, leaseEnd, leasePrice, file, carNumber);

                allLeases.add(tempList);
            }

        } catch (SQLException e) {
            System.out.println("Failed at showing repair lists. Try again.");
            e.printStackTrace();
        }
        return allLeases;
    }

    @Override
    public boolean update(LeaseContract entity) {

        try{
            PreparedStatement pstmt = conn.prepareStatement("UPDATE owxws8zh8rp2amnk.leasecontracts" +
                    " SET `sales_person`= ?, `lease_start` = ?, `lease_end`= ?, `lease_price` = ?, `file`= ?, `car_number` = ? " +
                    "WHERE (`leasecontracts_id` = ?)");

            pstmt.setString(1, entity.getSalesPerson());
            pstmt.setString(2, entity.getLeaseStart());
            pstmt.setString(3, entity.getLeaseEnd());
            pstmt.setInt(4, entity.getLeasePrice());
            pstmt.setString(5, entity.getFile());
            pstmt.setInt(6, entity.getCarNumber());

            pstmt.setInt(7, entity.getContractId());

            pstmt.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean delete(int id) {
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM `owxws8zh8rp2amnk`.`leasecontracts`" +
                    " WHERE (`car_number` = '" + id +"' );");

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Something went wrong. Try again.");
            e.printStackTrace();
        }
        return true;
    }



}
