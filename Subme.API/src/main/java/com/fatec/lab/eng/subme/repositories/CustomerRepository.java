package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.CustomerEntity;

import java.util.List;

public class CustomerRepository implements IBaseRepository<CustomerEntity>{
    @Override
    public List<CustomerEntity> GetAll() {
        return null;
    }

    @Override
    public CustomerEntity GetById(int id) {
        return null;
    }

    @Override
    public void Add(CustomerEntity model) {

    }

    @Override
    public void Update(CustomerEntity model, int id) {

    }

    @Override
    public void Delete(int id) {

    }
}
