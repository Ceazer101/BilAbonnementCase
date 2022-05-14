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
                    "(`damage`, `repair_start`, `car_number`)" + "VALUES (?,?,?)");

            pstmt.setObject(1, entity.getDamage());
            pstmt.setString(2, entity.getRepairStart());
            pstmt.setInt(3, entity.getCarNumber());

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
                    " WHERE (`repairlist_id` = '" + id + "' );");

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Something went wrong. Try again.");
            e.printStackTrace();
        }
        return true;
    }
}
