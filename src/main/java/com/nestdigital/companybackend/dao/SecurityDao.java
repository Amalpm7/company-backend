package com.nestdigital.companybackend.dao;

import com.nestdigital.companybackend.Model.EmployModel;
import com.nestdigital.companybackend.Model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {

    @Modifying
    @Query(value = "DELETE FROM `securities` WHERE `id`= :id",nativeQuery = true)
    void deleteSecurityById(Integer id);

    @Query(value = "SELECT `id`, `address`, `age`, `email`, `name`, `password`, `salary`, `phone`, `date` FROM `securities` WHERE `name`= :name",nativeQuery = true)
    List<SecurityModel> searchSecurity(String name );

    @Query(value = "SELECT * FROM `securities` WHERE `email`= :email AND`password`= :password",nativeQuery = true)
    List<SecurityModel> authSecurity(String email, String password);

    @Modifying
    @Query(value = "UPDATE `securities` SET `address`= :address,`age`=:age,`email`=:email,`name`=:name,`password`=:password,`salary`=:salary,`phone`=:phone WHERE `id`=:id",nativeQuery = true)
    void updateSecurityById(String address,String age,String email,String name,String password,String salary,String phone,Integer id);
}
