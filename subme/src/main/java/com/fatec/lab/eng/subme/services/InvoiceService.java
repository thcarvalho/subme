package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.InvoiceDTO;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.entities.InvoiceEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.InvoiceRepository;
import com.fatec.lab.eng.subme.services.interfaces.IInvoiceService;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService implements IInvoiceService {
    private InvoiceRepository invoiceRepository;

    public InvoiceService() {
        this.invoiceRepository = new InvoiceRepository();
    }

    @Override
    public List<InvoiceDTO> GetAll() {
        List<InvoiceEntity> invoices = invoiceRepository.GetAll();
        List<InvoiceDTO> dtos = new ArrayList<>();
        for (InvoiceEntity entity : invoices) {
            dtos.add(ModelToDTO.invoiceFactory(entity));
        }
        return dtos;
    }

    @Override
    public InvoiceDTO GetById(int id) {
        InvoiceEntity invoice = invoiceRepository.GetById(id);
        return ModelToDTO.invoiceFactory(invoice);
    }

    @Override
    public void Add(InvoiceDTO model) {
        InvoiceEntity invoice = DTOToModel.invoiceFactory(model);
        invoiceRepository.Add(invoice);
    }

    @Override
    public void Update(InvoiceDTO model, int id) {
        InvoiceEntity current = invoiceRepository.GetById(id);
        if (current == null) return;

        InvoiceEntity updated = DTOToModel.invoiceFactory(model);
        invoiceRepository.Update(updated, id);
    }

    @Override
    public void Delete(int id) {
        InvoiceEntity invoice = invoiceRepository.GetById(id);
        if (invoice == null) return;

        invoiceRepository.Delete(id);
    }
}
