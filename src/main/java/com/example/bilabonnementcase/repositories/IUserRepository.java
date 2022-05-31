package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.User;

//Author: Maja

public interface IUserRepository <T>{

    public boolean validateLoginInformation(String username, String password);

    public User getUserByUsername(String username);

}
