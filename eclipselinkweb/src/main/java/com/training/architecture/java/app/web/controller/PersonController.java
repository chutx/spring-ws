package com.training.architecture.java.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.architecture.java.app.business.service.PersonService;
import com.training.architecture.java.app.domain.Person;

@Controller
@RequestMapping(value="person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="save")
	public String save(Person person){
		personService.savePerson(person);
		return "page1";
	}
	
	@RequestMapping(value="fetch")
	public String fetchPerson(Long id){
		Person person = personService.getPerson(id);
		return "page1";
	}
}
