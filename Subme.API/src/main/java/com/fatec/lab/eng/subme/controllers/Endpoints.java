package com.fatec.lab.eng.subme.controllers;

import com.fatec.lab.eng.subme.dto.*;
import com.fatec.lab.eng.subme.entities.CompanyEntity;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.entities.InvoiceEntity;
import com.fatec.lab.eng.subme.entities.PlanEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.CompanyRepository;
import com.fatec.lab.eng.subme.repositories.CustomerRepository;
import com.fatec.lab.eng.subme.repositories.PlanRepository;
import com.fatec.lab.eng.subme.repositories.SubscriptionRepository;
import com.fatec.lab.eng.subme.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;

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
    @PostMapping("/create/companies")
    public ResponseEntity<?> createCompany(@RequestBody CompanyDTO companyDTO){
        return companyService.create(companyDTO);
    }

    //cadastra planos
    @PostMapping("/create/plans")
    public ResponseEntity<?> createPlan(@RequestBody PlanDTO planDTO){
        return planService.create(planDTO);
    }

    //cadastra cliente vinculando-o com o plano e assim, gerando uma subscription
    @PostMapping("/create/customers")
    public ResponseEntity<?> createCustomer(@RequestBody SubscriptionDTO subscriptionDTO){
        return customerService.create(subscriptionDTO);
    }

    @GetMapping("/search/companies/{id}")
    public ResponseEntity<CompanyDTO> searchCompanyById(@RequestBody Long id){
        return ResponseEntity.ok(ModelToDTO.companyFactory(companyRepository.findById(id).get()));
    }

    @GetMapping("/search/plans/{id}")
    public ResponseEntity<PlanDTO> searchPlanById(@RequestBody Long id){
        return ResponseEntity.ok(ModelToDTO.planFactory(planRepository.findById(id).get()));
    }

    @GetMapping("/search/customers/{id}")
    public ResponseEntity<CustomerDTO> searchCustomerById(@RequestBody Long id){
        return ResponseEntity.ok(ModelToDTO.customerFactory(customerRepository.findById(id).get()));
    }

    /* TRABALHANDO NESSE AINDA
    @GetMapping("/subscription/search/{id}")
    public ResponseEntity<SubscriptionDTO> searchSubscriptionById(@RequestBody Long id){
        return ResponseEntity.ok(ModelToDTO.subscriptionFactory(subscriptionRepository.findById(id).get()));
    }*/


    @GetMapping("/customers")
    @ResponseBody
    public ResponseEntity<List<CustomerDTO>> filterAllCostumers(@RequestParam Optional<List<String>> param){
       return customerService.filterList(param.get());
    }

    @GetMapping("/plans")
    public ResponseEntity<List<PlanDTO>> filterAllPlans(@RequestParam Optional<List<String>> param){
        return planService.filterList(param.get());
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<List<SubscriptionDTO>> getAllSubscriptions(@RequestParam Optional<List<String>> param){
        return subscriptionService.filterList(param.get());
    }




    @GetMapping("/companies")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies(){
        return ResponseEntity.ok().body(companyService.toList());
    }

    @GetMapping("/invoices")
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices(){
        return ResponseEntity.ok().body(invoiceService.toList());
    }





}
