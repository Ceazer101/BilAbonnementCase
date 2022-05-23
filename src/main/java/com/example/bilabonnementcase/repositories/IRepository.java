package com.example.bilabonnementcase.repositories;

import java.util.ArrayList;

//Author: Maja, Güler
public interface IRepository<T> {

    public boolean create(T entity);

    public ArrayList<T> getAllEntities();

    public boolean update(T entity);

    public boolean delete(int id);
}
