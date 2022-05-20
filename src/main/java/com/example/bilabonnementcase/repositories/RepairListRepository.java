package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//Author: Güler
public class RepairListRepository implements IRepository<RepairList> {

    private Connection conn;

    public RepairListRepository() {
        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public boolean create(RepairList entity) {
        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO owxws8zh8rp2amnk.repairlists " +
                    "(`repair_start`, `car_number`) VALUES (?,?)");

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
    public ArrayList<RepairList> getListOfObject() {
        ArrayList<RepairList> allRepairLists = new ArrayList<>();
        int id = 0;
        String repairStart = "";
        int carNumber = 0;

        String sqlString = ("SELECT * FROM owxws8zh8rp2amnk.repairlists;");
        try {
            PreparedStatement pstmt = conn.prepareStatement(sqlString);

            ResultSet repairRS = pstmt.executeQuery();
            while (repairRS.next()){
                id = repairRS.getInt(1);
                repairStart = repairRS.getString(2);
                carNumber = repairRS.getInt(3);

                RepairList tempList = new RepairList(id, repairStart, carNumber);

                allRepairLists.add(tempList);
            }

        } catch (SQLException e) {
            System.out.println("Failed at showing repair lists. Try again.");
            e.printStackTrace();
        }
        return allRepairLists;
    }

    @Override
    public boolean update(RepairList entity) {

        try{
            PreparedStatement pstmt = conn.prepareStatement("UPDATE owxws8zh8rp2amnk.repairlists" +
                    " SET `repair_start`= ?, `car_number` = ? " +
                    "WHERE (`repairlist_id` = ?)");

            pstmt.setString(1, entity.getRepairStart());
            pstmt.setInt(2, entity.getCarNumber());

            pstmt.setInt(3, entity.getRepairListId());

            pstmt.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return true;
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
