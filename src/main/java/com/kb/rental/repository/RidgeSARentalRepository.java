package com.kb.rental.repository;

import com.kb.rental.entity.RidgeSARental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by garlapati on 11/5/2016.
 */
@Repository
public interface RidgeSARentalRepository extends CrudRepository<RidgeSARental, String> {
}
