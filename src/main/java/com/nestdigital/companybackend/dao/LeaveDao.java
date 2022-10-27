package com.nestdigital.companybackend.dao;

import com.nestdigital.companybackend.Model.LeaveModel;
import org.springframework.data.repository.CrudRepository;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {
}
