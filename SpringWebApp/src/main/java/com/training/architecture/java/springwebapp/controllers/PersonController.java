package com.training.architecture.java.springwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.architecture.java.springwebapp.business.BusinessClass;
import com.training.architecture.java.springwebapp.domain.Person;

@Controller
@RequestMapping(value="person")
public class PersonController {

	@Autowired
	private BusinessClass businessClass;
	
	@RequestMapping("save")
	public String savePerson(Person person){
		businessClass.savePerson(person);
		return "page1";
	}
}
