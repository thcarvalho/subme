package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CompanyDTO;
import com.fatec.lab.eng.subme.entities.CompanyEntity;
import com.fatec.lab.eng.subme.entities.UserEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.AddressRepository;
import com.fatec.lab.eng.subme.repositories.CompanyRepository;
import com.fatec.lab.eng.subme.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<CompanyDTO> toList(){
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        for (CompanyEntity entity : companyRepository.findAll()){
            companyDTOS.add(ModelToDTO.companyFactory(entity));
        }
        return companyDTOS;
    }

    public ResponseEntity<?> create(CompanyDTO companyDTO){
        if (companyRepository.existsByCnpj(companyDTO.getCnpj())){
            return ResponseEntity.badRequest().body("CNPJ já cadastrado!");
        }else if (userRepository.existsByUsername(companyDTO.getUsername())){
            return ResponseEntity.badRequest().body("Username já existe!");
        }
        UserEntity userEntity = new UserEntity(companyDTO.getName(), companyDTO.getEmail(),
                companyDTO.getUsername(), companyDTO.getPassword());
        userRepository.save(userEntity);
        CompanyEntity companyEntity = DTOToModel.companyFactory(companyDTO, userEntity);
        //addressRepository.save(companyEntity.getaddress());
        companyRepository.save(companyEntity);
        return ResponseEntity.ok().body(companyEntity);
    }
}
