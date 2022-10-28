package com.nestdigital.companybackend.dao;

import com.nestdigital.companybackend.Model.LogModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<LogModel,Integer> {

    @Modifying
    @Query(value = "UPDATE `logs` SET `logout_time`= :logoutTime,`logout_sec_id`=:logout_sec_id WHERE `id`=:log_id",nativeQuery = true)
    public void updateLogDetails(String logoutTime,int logout_sec_id,int log_id);

    @Query(value = "SELECT l.`id`, l.`emp_id`, l.`login_time`, l.`logout_time`,l.`login_sec_id`, l.`logout_sec_id`, e.name AS emp_name,s1.name AS login_sec_name,s2.name AS logout_sec_name FROM `logs`l  JOIN employees e JOIN securities s1 JOIN securities s2 ON l.emp_id=e.id AND l.login_sec_id=s1.id AND l.logout_sec_id = s2.id",nativeQuery = true)
    public List<Map<String,String>> viewAllLogs();

    @Query(value =  "SELECT l.`id`, l.`emp_id`, l.`login_time`, l.`logout_time`,l.`login_sec_id`, l.`logout_sec_id`, e.name AS emp_name,s1.name AS login_sec_name,s2.name AS logout_sec_name FROM `logs`l  JOIN employees e JOIN securities s1 JOIN securities s2 ON l.emp_id=e.id AND l.login_sec_id=s1.id AND l.logout_sec_id = s2.id WHERE l.emp_id = :emp_id",nativeQuery = true)
    public List<Map<String,String>> viewLogByEmpId(Integer emp_id);
}
