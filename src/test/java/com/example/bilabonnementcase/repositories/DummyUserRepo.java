package com.example.bilabonnementcase.repositories;


import com.example.bilabonnementcase.models.LeaseContract;
import com.example.bilabonnementcase.models.User;

import java.util.ArrayList;
import java.util.Arrays;

public class DummyUserRepo implements IRepository{
/*
    ArrayList<User> userList = new ArrayList<User>(
            Arrays.asList(
                    new User("maja", "hej"),
                    new User("chris", "hejhej"),
                    new User("güler", "hallo")
            )
    );

    public boolean validateLoginInformation(User user){
        for(User u : userList){
            if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }*/

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public Object getEntityById(int id) {
        return null;
    }

    @Override
    public boolean update(String collumn, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
