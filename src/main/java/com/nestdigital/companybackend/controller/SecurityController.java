package com.nestdigital.companybackend.controller;


import com.nestdigital.companybackend.Model.EmployModel;
import com.nestdigital.companybackend.Model.SecurityModel;
import com.nestdigital.companybackend.dao.EmployDao;
import com.nestdigital.companybackend.dao.SecurityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao dao;

    @CrossOrigin(value = "*")
    @PostMapping("/addSecurity")
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

    @CrossOrigin(value = "*")
    @GetMapping("/viewSecurity")
    public List<SecurityModel> viewSecurity(){
        return (List<SecurityModel>) dao.findAll();
    }
    @CrossOrigin(value = "*")
    @PostMapping("/searchSecurity")
    public List<SecurityModel> searchSecurity(@RequestBody SecurityModel security){
        return (List<SecurityModel>) dao.searchSecurity(security.getName());
    }

    @CrossOrigin(value = "*")
    @PostMapping("/authSecurity")
    public List<SecurityModel> authSecurity(@RequestBody SecurityModel security){
        return (List<SecurityModel>) dao.authSecurity(security.getEmail(),security.getPassword());
    }
    @Transactional
    @CrossOrigin(value = "*")
    @PostMapping("/updateSecurity")
    public String updateSecurity(@RequestBody SecurityModel security){
        dao.updateSecurityById(security.getAddress(),security.getAge(),security.getEmail(),security.getName(),security.getPassword(),security.getSalary(),security.getPhone(),security.getId());
        return "Successfully Updated";
    }

}
