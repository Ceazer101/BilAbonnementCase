package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseContractRepository implements IRepository<LeaseContract> {

    private Connection conn;

    public LeaseContractRepository(){
        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public boolean create(LeaseContract entity) {
       try{
           PreparedStatement pstmt = conn.prepareStatement("INSERT INTO owxws8zh8rp2amnk.leasecontracts " +
                   "(`sales_person`, `lease_period`, `price`, `car_number`, `file`)" + "VALUES (?,?,?,?,?)");

           pstmt.setString(1, entity.getSalesPerson());
           pstmt.setString(2, entity.getLeasePeriod());
           pstmt.setInt(3, entity.getLeasePrice());
           pstmt.setInt(4, entity.getCarNumber());
           pstmt.setString(5, entity.getFile());

           pstmt.executeUpdate();

       } catch (SQLException e) {
           System.out.println("Something went wrong. Try again.");
           e.printStackTrace();
       }

       return true;
    }

    @Override
    public LeaseContract getEntityById(int id) {
        return null;
    }

    @Override
    public boolean update(String collumnName, int id) {

        return false;
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
