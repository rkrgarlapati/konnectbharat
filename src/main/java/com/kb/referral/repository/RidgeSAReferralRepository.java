package com.kb.referral.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kb.referral.entity.RidgeSAReferral;

@Repository
public interface RidgeSAReferralRepository extends CrudRepository<RidgeSAReferral, String> {
	public List<RidgeSAReferral> findByAcctId(String acct_id);
}
