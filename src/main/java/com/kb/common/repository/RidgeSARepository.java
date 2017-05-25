package com.kb.common.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kb.common.entity.RidgeSA;

/**
 * Created by garlapati on 11/4/2016.
 */
@Repository
@Transactional(readOnly = true)
public interface RidgeSARepository extends CrudRepository<RidgeSA, String> {
    public List<RidgeSA> findByAcctId(String acct_id);

    public List<RidgeSA> findByAcctIdAndTypeIn(String acct_id, List<String> types);

    @Modifying
    @Query("update RidgeSA sa set sa.statusflg = ?1, sa.start_dt = ?2 where sa.sa_id = ?3")
    public int activateSAStatus(String sa_status_flg, Date start_dt, String sa_id);

    public List<RidgeSA> findByTypeAndCityContainsAndAreaContainsAndStatusflg(String type, String city, String area,
                                                                              String statusFlg);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rss.amount,cid.perIdNbr from RidgeSA sa, RidgeSASale rss,CustomerIdentfication cid, RidgeAcct racc where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%'))and LOWER(sa.area) like LOWER(CONCAT('%', ?2, '%')) and sa.type=?3 and "
            + "sa.statusflg=?4 and sa.sa_id = rss.sa_id and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAreaAndTypeForSale(String city, String area, String type, String status);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rss.amount,cid.perIdNbr from RidgeSA sa, RidgeSASale rss,CustomerIdentfication cid, RidgeAcct racc where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%'))and LOWER(sa.area) like LOWER(CONCAT('%', ?2, '%')) and sa.type=?3 and sa.statusflg=?4 and cid.perIdNbr=?5 and sa.sa_id = rss.sa_id "
            + "and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAreaAndTypeForSaleWithUserID(String city, String area, String type, String status, String userId);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rss.amount,cid.perIdNbr from RidgeSA sa, RidgeSASale rss,CustomerIdentfication cid, RidgeAcct racc  where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%')) and sa.type=?2 and sa.statusflg=?3 and sa.sa_id = rss.sa_id and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAndTypeForSale(String city, String type, String status);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rss.amount,cid.perIdNbr from RidgeSA sa, RidgeSASale rss,CustomerIdentfication cid, RidgeAcct racc where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%')) and sa.type=?2 and sa.statusflg=?3 and cid.perIdNbr=?4 and sa.sa_id = rss.sa_id "
            + "and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAndTypeForSaleWithUserID(String city, String type, String status, String userId);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rsa.rent_amount,cid.perIdNbr from RidgeSA sa, RidgeSARental rsa,CustomerIdentfication cid, RidgeAcct racc  where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%'))and LOWER(sa.area) like LOWER(CONCAT('%', ?2, '%')) and sa.type=?3  and sa.statusflg=?4 and sa.sa_id = rsa.sa_id and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAreaAndTypeForTenant(String city, String area, String type, String status);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rsa.rent_amount,cid.perIdNbr from RidgeSA sa, RidgeSARental rsa,CustomerIdentfication cid, RidgeAcct racc where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%'))and LOWER(sa.area) like LOWER(CONCAT('%', ?2, '%')) and sa.type=?3  and sa.statusflg=?4 and cid.perIdNbr=?5  and sa.sa_id = rsa.sa_id"
            + " and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAreaAndTypeForTenantWithUserID(String city, String area, String type, String status, String userId);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rsa.rent_amount,cid.perIdNbr from RidgeSA sa, RidgeSARental rsa,CustomerIdentfication cid, RidgeAcct racc where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%')) and sa.type=?2  and sa.statusflg=?3 and sa.sa_id = rsa.sa_id and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAndTypeForTenant(String city, String type, String status);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rsa.rent_amount,cid.perIdNbr from RidgeSA sa, RidgeSARental rsa,CustomerIdentfication cid, RidgeAcct racc where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%')) and sa.type=?2  and sa.statusflg=?3 and cid.perIdNbr=?4  and sa.sa_id = rsa.sa_id"
            + " and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAndTypeForTenantWithUserID(String city, String type, String status, String userId);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rsm.dob, rsm.religion,rsm.employment,cid.perIdNbr from RidgeSA sa, RidgeSAMatrimony rsm,CustomerIdentfication cid, RidgeAcct racc where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%'))and LOWER(sa.area) like LOWER(CONCAT('%', ?2, '%')) and sa.type=?3  and sa.statusflg=?4 "
            + "and sa.sa_id = rsm.sa_id and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAreaAndTypeForMatrimony(String city, String area, String type, String status);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rsm.dob, rsm.religion,rsm.employment,cid.perIdNbr from RidgeSA sa, RidgeSAMatrimony rsm,CustomerIdentfication cid, RidgeAcct racc where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%'))and LOWER(sa.area) like LOWER(CONCAT('%', ?2, '%')) and sa.type=?3  and sa.statusflg=?4 and cid.perIdNbr=?5 and sa.sa_id = rsm.sa_id"
            + " and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAreaAndTypeForMatrimonyWithUserID(String city, String area, String type, String status, String userId);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rsm.dob, rsm.religion,rsm.employment,cid.perIdNbr from RidgeSA sa, RidgeSAMatrimony rsm,CustomerIdentfication cid, RidgeAcct racc where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%')) and sa.type=?2  and sa.statusflg=?3 and sa.sa_id = rsm.sa_id and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAndTypeForMatrimony(String city, String type, String status);

    @Query(value = "select sa.sa_id,sa.area,sa.statusflg,sa.start_dt,sa.actual_party_name, "
            + "sa.actual_party_contact,rsm.dob, rsm.religion,rsm.employment,cid.perIdNbr from RidgeSA sa, RidgeSAMatrimony rsm,CustomerIdentfication cid, RidgeAcct racc where lower(sa.city) "
            + "like LOWER(CONCAT('%', ?1, '%')) and sa.type=?2  and sa.statusflg=?3 and cid.perIdNbr=?4 and sa.sa_id = rsm.sa_id"
            + " and racc.acct_id = sa.acctId and racc.perId = cid.per_id")
    public List<Object[]> getAgreementDetailsByCityAndTypeForMatrimonyWithUserID(String city, String type, String status, String userId);


}
