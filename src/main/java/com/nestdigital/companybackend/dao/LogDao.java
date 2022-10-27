package com.nestdigital.companybackend.dao;

import com.nestdigital.companybackend.Model.LogModel;
import org.springframework.data.repository.CrudRepository;

public interface LogDao extends CrudRepository<LogModel,Integer> {
}
