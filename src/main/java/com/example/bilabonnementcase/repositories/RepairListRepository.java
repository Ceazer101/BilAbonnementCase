package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepairListRepository implements IRepository<RepairList> {

    private Connection conn;

    public RepairListRepository(){
        this.conn = DatabaseConnectionManager.getConnection();
    }


    @Override
    public boolean create(RepairList entity) {
        return false;
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
        return false;
    }
}
