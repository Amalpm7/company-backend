package com.nestdigital.companybackend.dao;

import com.nestdigital.companybackend.Model.EmployModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployDao extends CrudRepository<EmployModel,Integer> {

    @Modifying
    @Query(value = "DELETE FROM `employees` WHERE `id`= :id",nativeQuery = true)
    void deleteEmployById(Integer id);

    @Query(value = "SELECT `id`, `address`, `age`, `email`, `name`, `password`, `salary`, `phone`, `date` FROM `employees` WHERE `name`= :name",nativeQuery = true)
    List<EmployModel> searchEmployee(String name );

    @Query(value = "SELECT * FROM `employees` WHERE `email`= :email AND`password`= :password",nativeQuery = true)
    List<EmployModel> authEmployee(String email, String password);

    @Modifying
    @Query(value = "UPDATE `employees` SET `address`= :address,`age`=:age,`email`=:email,`name`=:name,`password`=:password,`salary`=:salary,`phone`=:phone WHERE `id`=:id",nativeQuery = true)
    void updateEmployeeById(String address,String age,String email,String name,String password,String salary,String phone,Integer id);
}
