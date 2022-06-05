package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.AddressDTO;
import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.InvoiceDTO;
import com.fatec.lab.eng.subme.dto.PlanDTO;
import com.fatec.lab.eng.subme.entities.AddressEntity;
import com.fatec.lab.eng.subme.entities.InvoiceEntity;
import com.fatec.lab.eng.subme.entities.SubscriptionEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.AddressRepository;
import com.fatec.lab.eng.subme.repositories.InvoiceRepository;
import com.fatec.lab.eng.subme.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public ResponseEntity<?> update(AddressDTO addressDTO){
        if (!addressRepository.existsById(addressDTO.getId())) ResponseEntity.badRequest().body("Endereço informado não consta nas bases");
        AddressEntity addressEntity = DTOToModel.addressFactory(addressDTO);
        addressRepository.save(addressEntity);
        return ResponseEntity.ok().body(addressDTO);
    }


}
