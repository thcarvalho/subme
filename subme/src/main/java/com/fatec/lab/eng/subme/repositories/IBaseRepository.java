package com.fatec.lab.eng.subme.repositories;

import java.util.List;

public interface IBaseRepository<T> {
    List<T> GetAll();
    T GetById(int id);
    void Add(T model);
    void Update(T model, int id);
    void Delete(int id);
}
