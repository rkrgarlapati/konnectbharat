package com.kb.customercontact.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kb.customercontact.entity.CustomerContact;

@Repository
public interface CustContactRepository extends CrudRepository<CustomerContact, String> {

    public List<CustomerContact> findAllByOrderByDatetimeDesc();

    public List<CustomerContact> findBycommunicationclassOrderByDatetimeDesc(String communicationclass);

    @Query(value = "select cc.communicationId, cc.status, cc.communicationclass, " +
            "cc.communicationtype, cc.datetime, cc.assignedDate, cc.assignedTo from CustomerContact cc where cc.status=?1 " +
            " and LOWER(cc.assignedTo) like LOWER(CONCAT('%', ?2, '%')) and cc.communicationclass=?3 and (cc.datetime between ?4 and ?5)")
    public List<Object[]> getStatusAndAssignedToAndCommunicationclassAndDatetimeBetween(String status, String assignedTo, String type, Date startDate, Date endDate);

    @Query(value = "select cc.communicationId, cc.status, cc.communicationclass, " +
            "cc.communicationtype, cc.datetime, cc.assignedDate, cc.assignedTo from CustomerContact cc where cc.status=?1 " +
            " and LOWER(cc.assignedTo) like LOWER(CONCAT('%', ?2, '%')) and (cc.datetime between ?3 and ?4)")
    public List<Object[]> getStatusAndAssignedToAndDatetimeBetween(String status, String assignedTo, Date startDate, Date endDate);

    @Query(value = "select cc.communicationId, cc.status, cc.communicationclass, " +
            "cc.communicationtype, cc.datetime, cc.assignedDate, cc.assignedTo from CustomerContact cc where cc.status=?1 " +
            "and cc.communicationclass=?2 and (cc.datetime between ?3 and ?4)")
    public List<Object[]> getStatusAndContactTypeAndDatetimeBetween(String status, String type, Date startDate, Date endDate);

    @Query(value = "select cc.communicationId, cc.status, cc.communicationclass, " +
            "cc.communicationtype, cc.datetime, cc.assignedDate, cc.assignedTo from CustomerContact cc where cc.status=?1 " +
            "and (cc.datetime between ?2 and ?3)")
    public List<Object[]> getStatusAndDatetimeBetween(String status, Date startDate, Date endDate);


}
