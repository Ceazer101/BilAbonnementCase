package com.example.bilabonnementcase.repositories;

public interface IRepository<T> {

    public boolean create(T entity);

    public T getEntityById(int id);

    public boolean update(String collumn, int id);

    public boolean delete(int id);
}
