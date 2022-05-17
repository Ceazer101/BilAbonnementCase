package com.example.bilabonnementcase.repositories;

import com.example.bilabonnementcase.models.User;

public class UserRepository implements IRepository<User>{
    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User getEntityById(int id) {
        return null;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
