package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CompanyDTO;
import com.fatec.lab.eng.subme.entities.CompanyEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.CompanyRepository;
import com.fatec.lab.eng.subme.services.interfaces.ICompanyService;

import java.util.ArrayList;
import java.util.List;

public class CompanyService implements ICompanyService {
    private CompanyRepository companyRepository;

    public CompanyService() {
        this.companyRepository = new CompanyRepository();
    }

    @Override
    public List<CompanyDTO> GetAll() {
        List<CompanyEntity> companies = companyRepository.GetAll();
        List<CompanyDTO> dtos = new ArrayList<>();
        for (CompanyEntity entity : companies) {
            dtos.add(ModelToDTO.companyFactory(entity));
        }
        return dtos;
    }

    @Override
    public CompanyDTO GetById(int id) {
        CompanyEntity company = companyRepository.GetById(id);
        return ModelToDTO.companyFactory(company);
    }

    @Override
    public void Add(CompanyDTO model) {
        CompanyEntity company = DTOToModel.companyFactory(model);
        companyRepository.Add(company);
    }

    @Override
    public void Update(CompanyDTO model, int id) {
        CompanyEntity current = companyRepository.GetById(id);
        if (current == null) return;

        CompanyEntity updated = DTOToModel.companyFactory(model);
        companyRepository.Update(updated, id);
    }

    @Override
    public void Delete(int id) {
        CompanyEntity company = companyRepository.GetById(id);
        if (company == null) return;

        companyRepository.Delete(id);
    }
}
