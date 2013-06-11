package com.training.architecture.java.springwebapp.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.architecture.java.springwebapp.business.BusinessClass;
import com.training.architecture.java.springwebapp.dao.PersonDao;

@Service
public class BusinessClassImpl implements BusinessClass {

	@Autowired
	private PersonDao personDao;
	
	@Transactional
	public String sayHello(Long id) {
		return personDao.fetchName(id);
	}

}
