package com.example.dynamicmapping.persistence.entity;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
@Data
public class ProfileEntity {

    @Id
    private String customerId;
    private String firstname;
    private String lastname;
    private String status;
    private String addressLine;
    private String city;
    private String province;
    private String postalCode;

}
