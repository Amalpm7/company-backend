package com.nestdigital.companybackend.controller;


import com.nestdigital.companybackend.Model.EmployModel;
import com.nestdigital.companybackend.Model.SecurityModel;
import com.nestdigital.companybackend.dao.EmployDao;
import com.nestdigital.companybackend.dao.SecurityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao dao;

    @CrossOrigin(value = "*")
    @PostMapping("/")
    public String addSecurity(@RequestBody SecurityModel security){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        String currentDate= String.valueOf(dt.format(now));
        security.setDate(currentDate);
        System.out.println(security.toString());
        dao.save(security);
        return "{status:success}";
    }
    @Transactional
    @CrossOrigin(value = "*")
    @PostMapping("/deleteSecurity")
    public String deleteSecurity(@RequestBody SecurityModel security){

        dao.deleteSecurityById(security.getId());
        return "{status:success}";
    }

}
