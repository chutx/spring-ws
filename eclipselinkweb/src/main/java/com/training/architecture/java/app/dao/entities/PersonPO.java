package com.training.architecture.java.app.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="person")
public class PersonPO implements Serializable {

	private static final long serialVersionUID = -6139803366000163445L;
	
	@Id
	@Column(name="id")
	@TableGenerator(name="person_id", table="ids_sequences", 
	pkColumnName="table_name", pkColumnValue="person_gen", 
	valueColumnName="seq_val", initialValue=1,
	allocationSize=1, schema="springsch")
	@GeneratedValue(generator="person_id")
	private Long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
