package com.kb.common.repository;

import com.kb.common.entity.RidgeAcct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by garlapati on 11/4/2016.
 */
@Repository
public interface RidgeAcctRepository extends CrudRepository<RidgeAcct, String> {
	public RidgeAcct findByPerId(String perId);
}
