package com.nestdigital.companybackend.controller;

import com.nestdigital.companybackend.Model.EmployModel;
import com.nestdigital.companybackend.dao.EmployDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class EmployController {

    @Autowired
    private EmployDao employeeDao;

    @CrossOrigin(value = "*")
    @PostMapping("/addEmp")
    public String addEmployee(@RequestBody EmployModel employModel){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        String currentDate= String.valueOf(dt.format(now));
        employModel.setDate(currentDate);
        System.out.println(employModel.toString());
        employeeDao.save(employModel);
        return "{status:success}";
    }

    @Transactional
    @CrossOrigin(value = "*")
    @PostMapping("/deleteEmp")
    public String deleteEmployee(@RequestBody EmployModel employModel){

        employeeDao.deleteEmployById(employModel.getId());
        return "{status:success}";
    }
    @CrossOrigin(value = "*")
    @GetMapping("/viewEmp")
    public List<EmployModel> viewEmployee(){
        return (List<EmployModel>) employeeDao.findAll();
    }
    @CrossOrigin(value = "*")
    @PostMapping("/searchEmp")
    public List<EmployModel> searchEmployee(@RequestBody EmployModel employModel){
        return (List<EmployModel>) employeeDao.searchEmployee(employModel.getName());
    }
    @CrossOrigin(value = "*")
    @PostMapping("/authEmp")
    public List<EmployModel> authEmployee(@RequestBody EmployModel employModel){
        return (List<EmployModel>) employeeDao.authEmployee(employModel.getEmail(),employModel.getPassword());
    }
    @Transactional
    @CrossOrigin(value = "*")
    @PostMapping("/updateEmp")
    public String updateEmployee(@RequestBody EmployModel employModel){
        employeeDao.updateEmployeeById(employModel.getAddress(),employModel.getAge(),employModel.getEmail(),employModel.getName(),employModel.getPassword(),employModel.getSalary(),employModel.getPhone(),employModel.getId());
        return "Successfully Updated";
    }

}
