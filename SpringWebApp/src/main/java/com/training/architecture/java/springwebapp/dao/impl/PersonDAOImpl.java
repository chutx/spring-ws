package com.training.architecture.java.springwebapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.training.architecture.java.springwebapp.dao.PersonDao;

@Repository
public class PersonDAOImpl implements PersonDao {

	public String fetchName(Long id){
		
		return "starting";
	}

}
