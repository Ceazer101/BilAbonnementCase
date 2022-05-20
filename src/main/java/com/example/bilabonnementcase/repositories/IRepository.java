package com.example.bilabonnementcase.repositories;

import java.util.ArrayList;

//Author: Maja
//Author: Güler
public interface IRepository<T> {

    public boolean create(T entity);

    public ArrayList<T> getListOfObject();

    public boolean update(T entity);

    public boolean delete(int id);
}
