package com.example.demo.repo;

import java.util.Collection;

import com.example.demo.model.Person;

public interface PersonRepository {
	public Person createPerson(Person person);

	// public List<Person> getAllPersons();
	public Collection<Person> getAllPersons();

	public Person getPeresonByIdPerson(Integer personId);

	public Person updatePersonById(Integer personId, Person person);

	public Person findByFirstName(String name);
	public Person findByLastName(String name);
	public Person findByEmail(String email);

	public Person updateByFirstName(String name, Person person);
	public String deletePersonById(Integer personId);

}
