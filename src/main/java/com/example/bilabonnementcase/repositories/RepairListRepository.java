package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.Damage;
import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

//Author: Güler, Chris, Maja
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
    public ArrayList<RepairList> getAllEntities() {
        return null;
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
                    " WHERE (`repairlist_id` = ? );");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Something went wrong. Try again.");
            e.printStackTrace();
        }
        return true;
    }

    public boolean isCarRented(int carNumber){
        boolean isRented = false;

        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM owxws8zh8rp2amnk.cars " +
                    "WHERE (`car_number` = ?)");

            pstmt.setInt(1, carNumber);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if (rs.getInt("is_rented") == 1){
                    isRented = true;
                } else {
                    isRented = false;
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return isRented;
    }

    public boolean isLeasePeriodOver(int carNumber){

        boolean isOver = false;

        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM owxws8zh8rp2amnk.leasecontracts " +
                    "WHERE (`car_number` = ?)");

            pstmt.setInt(1, carNumber);

            ResultSet rsVerify = pstmt.executeQuery();

            java.sql.Date today = java.sql.Date.valueOf(LocalDate.now());

            while (rsVerify.next()){
                java.sql.Date endOfLease = java.sql.Date.valueOf(rsVerify.getString("lease_end"));

                if (today.after(endOfLease)){
                    isOver = true;
                } else {
                    isOver = false;
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return isOver;
    }

    public void updateLeasePeriodStatus(boolean periodOver, int carNumber){

        try{
            if (periodOver == true) {

                PreparedStatement pstmt = conn.prepareStatement("UPDATE owxws8zh8rp2amnk.cars " +
                        "SET `has_lease_ended` = ? " +
                        "WHERE `car_number` = ?;");

                pstmt.setInt(1, 1);
                pstmt.setInt(2, carNumber);
                pstmt.executeUpdate();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public boolean createDamage(Damage damage, int repairListId) {

        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO owxws8zh8rp2amnk.damages " +
                    "(`damage_title`, `damage_description`, `damage_price`, `repairlist_id`) VALUES (?,?,?,?)");

            pstmt.setString(1, damage.getDamageTitle());
            pstmt.setString(2,damage.getDamageDescription());
            pstmt.setInt(3, damage.getDamagePrice());
            pstmt.setInt(4, repairListId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Something went wrong. Try again.");
            e.printStackTrace();
        }
        return true;
    }

    public int getRepairListIdFromCarNumber(int carNumber){
        int repairListId = 0;

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM owxws8zh8rp2amnk.repairlists " +
                    "WHERE `car_number` = ?;");

            pstmt.setInt(1, carNumber);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                repairListId = rs.getInt("repairlist_id");
            }

        }catch (SQLException e) {
            System.out.println("Something went wrong. Try again.");
            e.printStackTrace();
        }
        return repairListId;
    }

    public RepairList getRepairlistFromCar(int carNumber) {
        int repairListId = 0;
        String repairStart = "";
        RepairList tempObject = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM owxws8zh8rp2amnk.repairlists " +
                    "WHERE `car_number` = ?;");

            pstmt.setInt(1, carNumber);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                repairListId = rs.getInt("repairlist_id");
                repairStart = rs.getString("repair_start");

                tempObject = new RepairList(repairListId, repairStart, carNumber);
            }

        } catch (SQLException e) {
            System.out.println("Failed at showing repair lists. Try again.");
            e.printStackTrace();
        }
        return tempObject;
    }

    public Damage getDamagesFromCar(int repairId) {
        int id = 0;
        String title = "";
        String description = "";
        int price = 0;
        Damage tempObject = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM owxws8zh8rp2amnk.Damages " +
                    "WHERE `repairlist_id` = ?;");

            pstmt.setInt(1, repairId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
                title = rs.getString(2);
                description = rs.getString(3);
                price = rs.getInt(4);

                tempObject = new Damage(id, title, description, price);
            }

        } catch (SQLException e) {
            System.out.println("Failed at showing repair lists. Try again.");
            e.printStackTrace();
        }
        return tempObject;
    }

}
