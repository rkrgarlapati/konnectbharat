package com.kb.sale.repository;

import com.kb.sale.entity.RidgeSASale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by garlapati on 11/5/2016.
 */
@Repository
public interface RidgeSASaleRepository extends CrudRepository<RidgeSASale, String> {
}
