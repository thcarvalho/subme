package com.fatec.lab.eng.subme.services.interfaces;

import java.util.List;

public interface IBaseService<T> {
    List<T> GetAll();
    T GetById(int id);
    void Add(T model);
    void Update(T model, int id);
    void Delete(int id);
}
