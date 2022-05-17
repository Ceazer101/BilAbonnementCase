package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepairListRepository implements IRepository<RepairList> {

    private Connection conn;

    public RepairListRepository() {
        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public boolean create(RepairList entity) {
        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO owxws8zh8rp2amnk.repairlists " +
                    "(`repair_start`, `car_number`)" + "VALUES (?,?)");

            pstmt.setString(1, entity.getRepairStart());
            pstmt.setInt(2, entity.getCarNumber());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Something went wrong. Try again.");
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public RepairList getEntityById(int id) {
        return null;
    }

    @Override
    public boolean update(RepairList entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM `owxws8zh8rp2amnk`.`repairlists`" +
                    " WHERE (`car_number` = '" + id + "' );");

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Something went wrong. Try again.");
            e.printStackTrace();
        }
        return true;
    }
}
