package com.nestdigital.companybackend.dao;

import com.nestdigital.companybackend.Model.LeaveModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {
    @Modifying
    @Query(value = "UPDATE `leaves` SET `status`= :status WHERE id = :id",nativeQuery = true)
    void changeStatusOfLeave(int id,int status);
    @Query(value = "SELECT l.`id`, l.`status`, l.`apply_date`, l.`emp_id`, l.`leave_date`, l.`type`," +
            " l.`description`,e.name FROM `leaves` l JOIN employees e ON l.emp_id = e.id",nativeQuery = true)
    List<Map<String,String>> viewAllLeave();

    @Query(value = "SELECT l.`id`, l.`status`, l.`apply_date`, l.`emp_id`, l.`leave_date`, l.`type`," +
            " l.`description`,e.name FROM `leaves` l JOIN employees e ON l.emp_id = e.id WHERE l.emp_id = :id",nativeQuery = true)
    List<Map<String,String>> viewLeaveByEmpID(int id);
}
