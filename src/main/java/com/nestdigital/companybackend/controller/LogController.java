package com.nestdigital.companybackend.controller;


import com.nestdigital.companybackend.Model.LogModel;
import com.nestdigital.companybackend.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {

    @Autowired
    private LogDao dao;

    @CrossOrigin(originPatterns = "*")
    @PostMapping("/login")
    public String addLogDetails(@RequestBody LogModel logModel){
        DateTimeFormatter date= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        logModel.setLoginTime(String.valueOf(date.format(now)));
        dao.save((logModel));
        return "Success";
    }
    @Transactional
    @CrossOrigin(originPatterns = "*")
    @PostMapping("/checkOut")
    public String updateLogDetails(@RequestBody LogModel logModel){
        DateTimeFormatter date= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        logModel.setLogoutTime(String.valueOf(date.format(now)));
        dao.updateLogDetails(logModel.getLogoutTime(),logModel.getLogout_sec_id(),logModel.getId());
        return "Log Success";
    }
    @CrossOrigin(originPatterns = "*")
    @PostMapping("/viewAllLog")
    public List<Map<String,String>> viewAllLog(){
        return (List<Map<String, String>>) dao.viewAllLogs();
    }

    @CrossOrigin(originPatterns = "*")
    @PostMapping("/viewLogById")
    public List<Map<String,String>> viewLogById(@RequestBody LogModel logModel){
        return (List<Map<String, String>>) dao.viewLogByEmpId(logModel.getEmp_id());
    }
}
