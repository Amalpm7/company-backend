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
@Table(name = "logs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LogModel {

    @Id
    @GeneratedValue
    private int id;
    private int emp_id;
    private int login_sec_id;
    private int logout_sec_id;
    private String loginTime;
    private String logoutTime;

}
