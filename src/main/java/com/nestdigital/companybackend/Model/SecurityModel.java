package com.nestdigital.companybackend.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "securities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SecurityModel {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String age;
    private String address;
    private String salary;
    private String date;
    private String phone;
    private String email;
    private String password;
}
