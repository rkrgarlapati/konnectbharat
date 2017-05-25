package com.kb.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.kb.login.entity.LoggedInUser;

public interface LoggedInUserRepository extends CrudRepository<LoggedInUser, String> {

	LoggedInUser findByPerIdAndWebPassword(String perId, String webPassword);
	LoggedInUser findByWebUseridAndWebPassword(String webUserid, String webPassword);
}