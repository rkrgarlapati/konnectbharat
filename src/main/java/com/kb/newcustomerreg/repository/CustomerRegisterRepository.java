package com.kb.newcustomerreg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kb.newcustomerreg.entity.Customer;

@Repository
public interface CustomerRegisterRepository extends CrudRepository<Customer, String> {
    Customer findByWebuserid(String emp_userid);
}