package com.fatec.lab.eng.subme.controllers;

import com.fatec.lab.eng.subme.dto.*;
import com.fatec.lab.eng.subme.entities.CompanyEntity;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.entities.InvoiceEntity;
import com.fatec.lab.eng.subme.entities.PlanEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.*;
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
    UserService userService;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PlanRepository planRepository;


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

    @Autowired
    AddressService addressService;

    @Autowired
    AuthorizationService authorizationService;

    //creates---------------------------------------------------------------------------------------

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO){
        return userService.validateLogon(userDTO);
    }

    //cadastra empresa
    @PostMapping("/create/companies")
    public ResponseEntity<?> createCompany(@RequestBody CompanyDTO companyDTO){
        return companyService.create(companyDTO);
    }

    //cadastra planos
    @PostMapping("/create/plans")
    public ResponseEntity<?> createPlan(@RequestBody PlanDTO planDTO, @RequestHeader(value="Authorization") String token){
        planDTO.setCompanyId(authorizationService.GetIdFromJWT(token));
        return planService.create(planDTO);
    }

    //cadastra cliente vinculando-o com o plano e assim, gerando uma subscription
    @PostMapping("/create/customers")
    public ResponseEntity<?> createCustomer(@RequestBody SubscriptionDTO subscriptionDTO, @RequestHeader(value="Authorization") String token){
        return customerService.create(subscriptionDTO , authorizationService.GetIdFromJWT(token));
    }

    @PostMapping("/create/subscriptions")
    public ResponseEntity<?> createSubscription(@RequestBody SubscriptionDTO subscriptionDTO, @RequestHeader(value="Authorization") String token){
        subscriptionDTO.setCompanyId(authorizationService.GetIdFromJWT(token));
        return subscriptionService.createWithCustomerRegistered(subscriptionDTO);
    }

    //Updates---------------------------------------------------------------------------------------



    @PutMapping("/update/plans")
    public ResponseEntity<?> updatePlan(@RequestBody PlanDTO planDTO, @RequestHeader(value="Authorization") String token){
        planDTO.setCompanyId(authorizationService.GetIdFromJWT(token));
        return planService.update(planDTO);
    }

    @PutMapping("/update/customers")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDTO customerDTO, @RequestHeader(value="Authorization") String token){
        customerDTO.setCompanyId(authorizationService.GetIdFromJWT(token));
        return customerService.update(customerDTO);
    }

    @PutMapping("/update/subscriptions")
    public ResponseEntity<?> updateSubscriptions(@RequestBody SubscriptionDTO subscriptionDTO, @RequestHeader(value="Authorization") String token){
        subscriptionDTO.setCompanyId(authorizationService.GetIdFromJWT(token));
        return subscriptionService.update(subscriptionDTO);
    }

    @PutMapping("/update/addresses")
    public ResponseEntity<?> updateAddresses(@RequestBody AddressDTO addressDTO, @RequestHeader(value="Authorization") String token){
        return addressService.update(addressDTO);
    }

    //Delete------------------------------------------------------------------------------
    @DeleteMapping("/delete/customers/{id}")
    public ResponseEntity<?> deleteCustomers(@PathVariable Long id, @RequestHeader(value="Authorization") String token) {
        return customerService.delete(id);
    }

    @DeleteMapping("/delete/plans/{id}")
    public ResponseEntity<?> deletePlans(@PathVariable Long id, @RequestHeader(value="Authorization") String token) {
        return planService.delete(id);
    }


    /* TRABALHANDO NESSE AINDA
    @GetMapping("/subscription/search/{id}")
    public ResponseEntity<SubscriptionDTO> searchSubscriptionById(@RequestBody Long id){
        return ResponseEntity.ok(ModelToDTO.subscriptionFactory(subscriptionRepository.findById(id).get()));
    }*/

    //Filters---------------------------------------------------------------------------------------

    @GetMapping("/customers")
    @ResponseBody
    public ResponseEntity<List<CustomerDTO>> filterAllCostumers(@RequestParam Optional<List<String>> param, @RequestHeader(value="Authorization") String token){
        if (param.isPresent()) return customerService.filteredList(param.get(), authorizationService.GetIdFromJWT(token));
        return ResponseEntity.ok().body(customerService.toList(authorizationService.GetIdFromJWT(token)));
    }

    @GetMapping("/plans")
    public ResponseEntity<List<PlanDTO>> filterAllPlans(@RequestParam Optional<List<String>> param, @RequestHeader(value="Authorization") String token){
        if (param.isPresent()) return planService.filteredList(param.get(), authorizationService.GetIdFromJWT(token));
        return ResponseEntity.ok().body(planService.toList(authorizationService.GetIdFromJWT(token)));
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<List<SubscriptionDTO>> getAllSubscriptions(@RequestParam Optional<List<String>> param, @RequestHeader(value="Authorization") String token){
        if(param.isPresent()) return subscriptionService.filteredList(param.get(), authorizationService.GetIdFromJWT(token) );
        return ResponseEntity.ok().body(subscriptionService.toList(authorizationService.GetIdFromJWT(token)));
    }


























    //-----------------------------------------------------------------------------------
    @GetMapping("/companies")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies(){
        return ResponseEntity.ok().body(companyService.toList());
    }

    @GetMapping("/invoices")
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices(){
        return ResponseEntity.ok().body(invoiceService.toList());
    }

    //searchs-------------------------------------------------------------------------------

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




}
