package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	
	
	
	public PersonServiceImpl(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public Person createPerson(Person person) {
		// TODO Auto-generated method stub
		return personRepository.createPerson(person);
	}

	/*
	 * @Override public List<Person> getAllPersons() { // TODO Auto-generated method
	 * stub return personRepository.getAllPersons(); }
	 */
	@Override
	public Collection<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personRepository.getAllPersons();
	}

	@Override
	public Person getPeresonByIdPerson(Integer personId) {
		// TODO Auto-generated method stub
		
		return personRepository.getPeresonByIdPerson(personId);
		
	}
	@Override
	public Person updatePersonById(Integer personId, Person person) {
		// TODO Auto-generated method stub
		return personRepository.updatePersonById(personId, person);
	}
	@Override
	public Person findByFirstName(String name) {
		// TODO Auto-generated method stub
		return personRepository.findByFirstName(name);
	}

	@Override
	public Person updateByFirstName(String name, Person person) {
		// TODO Auto-generated method stub
		return personRepository.updateByFirstName(name, person);
	}

	@Override
	public Person findByLastName(String name) {
		// TODO Auto-generated method stub
		return personRepository.findByLastName(name);
	}

	@Override
	public Person findByEmail(String email) {
		// TODO Auto-generated method stub
		return personRepository.findByEmail(email);
	}

	@Override
	public String deletePersonById(Integer personId) {
		// TODO Auto-generated method stub
		return personRepository.deletePersonById(personId);
	}

}