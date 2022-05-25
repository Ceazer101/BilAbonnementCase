package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.User;

public interface IUserRepository <T>{

    public boolean validateLoginInformation(String username, String password);

    public User getUserByUsername(String username);

}
