package com.kb.employee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kb.employee.entity.EmployeeIdentfication;

/**
 * Created by garlapati on 10/23/2016.
 */
@Repository
public interface EmployeeIdentificationRepository extends CrudRepository<EmployeeIdentfication, String> {
    public List<EmployeeIdentfication> findByPerId(String per_id);
}
