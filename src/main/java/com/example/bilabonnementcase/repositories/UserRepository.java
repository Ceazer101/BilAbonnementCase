package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.User;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Author: Maja
public class UserRepository implements IRepository<User>{

    private Connection conn;

    public UserRepository() {
        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User getEntityById(int id) {
        return null;
    }

    @Override
    public boolean update(String collumnName, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public boolean validateLoginInformation(User user){
        boolean isAMatch = false;

        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM owxws8zh8rp2amnk.users" +
                    " WHERE (`username` = ? AND `password` = ?);");

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());

            ResultSet rsVerify = pstmt.executeQuery();

            while (rsVerify.next()) {
                if(user.getPassword().equals(rsVerify.getString("password")) && user.getUsername().equals(rsVerify.getString("username"))){
                    isAMatch = true;
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return isAMatch;
    }


}

