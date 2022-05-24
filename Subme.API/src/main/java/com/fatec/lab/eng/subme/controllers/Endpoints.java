package com.fatec.lab.eng.subme.controllers;

import com.fatec.lab.eng.subme.dto.*;
import com.fatec.lab.eng.subme.entities.CompanyEntity;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.entities.InvoiceEntity;
import com.fatec.lab.eng.subme.entities.PlanEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.repositories.CompanyRepository;
import com.fatec.lab.eng.subme.repositories.CustomerRepository;
import com.fatec.lab.eng.subme.repositories.PlanRepository;
import com.fatec.lab.eng.subme.repositories.SubscriptionRepository;
import com.fatec.lab.eng.subme.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Endpoints {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    CompanyService companyService;

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    PlanService planService;

    @Autowired
    SubscriptionService subscriptionService;


    //cadastra empresa
    @PostMapping("/company/create")
    public ResponseEntity<?> createCompany(@RequestBody CompanyDTO companyDTO){
        return companyService.create(companyDTO);
    }

    //cadastra planos
    @PostMapping("/plan/create")
    public ResponseEntity<?> createPlan(@RequestBody PlanDTO planDTO){
        return planService.create(planDTO);
    }

    //cadastra cliente vinculando-o com o plano e assim, gerando uma subscription
    @PostMapping("/customer/create")
    public ResponseEntity<?> createCustomer(@RequestBody SubscriptionDTO subscriptionDTO){
        return customerService.create(subscriptionDTO);
    }


    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCostumers(){
        return ResponseEntity.ok().body(customerService.toList());
    }

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies(){
        return ResponseEntity.ok().body(companyService.toList());
    }

    @GetMapping("/invoices")
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices(){
        return ResponseEntity.ok().body(invoiceService.toList());
    }

    @GetMapping("/plans")
    public ResponseEntity<List<PlanDTO>> getAllPlans(){
        return ResponseEntity.ok().body(planService.toList());
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<List<SubscriptionDTO>> getAllSubscriptions(){
        return ResponseEntity.ok().body(subscriptionService.toList());
    }



}
