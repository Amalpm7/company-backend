package com.nestdigital.companybackend.dao;

import com.nestdigital.companybackend.Model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {

    @Modifying
    @Query(value = "DELETE FROM `securities` WHERE `id`= :id",nativeQuery = true)
    void deleteSecurityById(Integer id);
}
