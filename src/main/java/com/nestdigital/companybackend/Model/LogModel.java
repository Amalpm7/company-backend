package com.nestdigital.companybackend.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logs")
public class LogModel {

    @Id
    @GeneratedValue
    private int id;
    private int emp_id;
    private String type;
    private String loginTime;
    private String logoutTime;

}
