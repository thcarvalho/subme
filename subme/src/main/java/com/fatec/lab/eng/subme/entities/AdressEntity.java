package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.Adress;
import com.fatec.lab.eng.subme.dto.Customer;
import com.fatec.lab.eng.subme.dto.Plan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ADRESSES")
public class AdressEntity {
    @Id
    private Long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "ADRESS")
    private Adress adress;

    @Column(name = "PLAN")
    private List<Plan> plans;

    @Column(name = "COSTUMER")
    private List<Customer> costumers;

    @Column(name = "DAT_CREATE")
    private Date createdAt;

    @Column(name ="DAT_UPDATE")
    private Date updatedAt;

}
