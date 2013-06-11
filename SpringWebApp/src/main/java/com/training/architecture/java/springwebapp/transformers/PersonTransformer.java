package com.training.architecture.java.springwebapp.transformers;

import org.apache.commons.collections.Transformer;
import org.springframework.stereotype.Service;

import com.training.architecture.java.springwebapp.domain.Person;
import com.training.architecture.java.springwebapp.entities.PersonPO;

@Service("personTransformer")
public class PersonTransformer implements Transformer {

	public Object transform(Object obj) {
		Object result = null;
		if(obj instanceof PersonPO){
			PersonPO po = (PersonPO) obj;
			result = convertToPerson(po);
		}else if(obj instanceof Person){
			Person person = (Person) obj;
			result = convertToPersonPO(person);
		}
		
		return result;
	}

	private Person convertToPerson(PersonPO po){
		Person p = new Person();
		p.setFirstName(po.getName());
		p.setLastName(po.getLastName());
		return p;
	}
	
	private PersonPO convertToPersonPO(Person person){
		PersonPO po = new PersonPO();
		po.setLastName(person.getLastName());
		po.setName(person.getFirstName());
		return po;
	}
}
