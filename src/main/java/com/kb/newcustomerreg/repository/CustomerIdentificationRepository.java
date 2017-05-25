package com.kb.newcustomerreg.repository;

import com.kb.newcustomerreg.entity.CustomerIdentfication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by garlapati on 10/23/2016.
 */
@Repository
public interface CustomerIdentificationRepository extends CrudRepository<CustomerIdentfication, String> {
    public List<CustomerIdentfication> findByPerIdNbr(String per_id_nbr);
}
