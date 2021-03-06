package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.Role;
import com.example.bilabonnementcase.models.User;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Author: Maja
public class UserRepository implements IUserRepository <User> {

    private Connection conn;

    public UserRepository() {
        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public boolean validateLoginInformation(String username, String password){

        boolean isAMatch = false;

        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM owxws8zh8rp2amnk.users" +
                    " WHERE (`username` = ? AND `password` = ?);");

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                if(password.equals(rs.getString("password")) && username.equals(rs.getString("username"))){
                    isAMatch = true;
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return isAMatch;
    }

    @Override
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

