package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.CustumerEntity;

import java.util.List;

public class CustomerRepository implements IBaseRepository<CustumerEntity>{
    @Override
    public List<CustumerEntity> GetAll() {
        return null;
    }

    @Override
    public CustumerEntity GetById(int id) {
        return null;
    }

    @Override
    public void Add(CustumerEntity model) {

    }

    @Override
    public void Update(CustumerEntity model, int id) {

    }

    @Override
    public void Delete(int id) {

    }
}
