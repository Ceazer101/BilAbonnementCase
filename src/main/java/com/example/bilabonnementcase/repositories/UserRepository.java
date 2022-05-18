package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.Role;
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

    public boolean validateLoginInformation(String username, String password){
        boolean isAMatch = false;

        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM owxws8zh8rp2amnk.users" +
                    " WHERE (`username` = ? AND `password` = ?);");

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rsVerify = pstmt.executeQuery();

            while (rsVerify.next()) {
                if(password.equals(rsVerify.getString("password")) && username.equals(rsVerify.getString("username"))){
                    isAMatch = true;
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return isAMatch;
    }

    public User getUserByUsername(String username){
        String password = "";
        Role role = null;
        User thisUser = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM owxws8zh8rp2amnk.users" +
                    " WHERE (`username` = ?);");

            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                password = rs.getString("password");
                role = Role.valueOf(rs.getString("role"));
            }

            thisUser = new User(username, password, role);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return thisUser;
    }




}

