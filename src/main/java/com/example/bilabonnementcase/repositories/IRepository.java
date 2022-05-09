package com.example.bilabonnementcase.repositories;

public interface IRepository<T> {

    public T create(T entity);

    public T getEntityById(int id);

    public boolean update(T entity);

    public boolean delete(int id);
}
