package com.kb.common.entity;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * Created by garlapati on 11/4/2016.
 */
public class RidgeAcctPrimaryKey implements Serializable {
    String acct_id;
    @Column(name="per_id")
	private String perId;
}
