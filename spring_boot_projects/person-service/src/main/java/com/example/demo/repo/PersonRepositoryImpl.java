/*
 * package com.example.demo.repo;
 * 
 * import java.util.ArrayList; import java.util.Collection; import
 * java.util.List;
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * import com.example.demo.model.Person;
 * 
 * @Repository public class PersonRepositoryImpl implements PersonRepository {
 * 
 * private List<Person> persons=null;
 * 
 * { persons=new ArrayList<Person>(); }
 * 
 * @Override public Person createPerson(Person person) { // TODO Auto-generated
 * method stub persons.add(person); return person; }
 * 
 * 
 * @Override public List<Person> getAllPersons() { // TODO Auto-generated method
 * return persons; }
 * 
 * 
 * }
 */
package com.example.demo.repo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
	
	private Map<Integer,Person> persons=null;
	
	{
		persons=new HashMap<Integer,Person>();
	}

	@Override
	public Person createPerson(Person person) {
		// TODO Auto-generated method stub
		persons.put(person.getPersonId(),person);
		return person;
	}

	@Override
	public Collection<Person> getAllPersons() {
		// TODO Auto-generated method stub
		System.out.println(persons);
		return persons.values();
	}

	@Override
	public Person getPeresonByIdPerson(Integer personId) {
		// TODO Auto-generated method stub
		Person thePerson=persons.get(personId);
		
		//System.out.println(thePerson);
		if(thePerson==null )
		{
			return null;
		}
		else
			return thePerson;
		
	}
	@Override
	public Person updatePersonById(Integer personId, Person person) {
		// TODO Auto-generated method stub
		Person thePerson = persons.get(personId);

		if (thePerson == null) {
			return null;
		} else
			thePerson.setFirstName(person.getFirstName());
		thePerson.setLastName(person.getLastName());
		thePerson.setEmail(person.getEmail());
		return thePerson;

		
	}
	@Override
	public Person updateByFirstName(String name, Person person) {
		// TODO Auto-generated method stub
		Person thePerson = findByFirstName(name);

		if (thePerson == null) {
			return null;
		} else
			//thePerson.setFirstName(person.getFirstName());
			thePerson.setLastName(person.getLastName());
		thePerson.setEmail(person.getEmail());
		return thePerson;
	}
	@Override
	public Person findByFirstName(String name) {
		// TODO Auto-generated method stub
		Person tempPerson=null;
		Collection<Person> personCollection=persons.values();
		for(Person p:personCollection)
		{
			if(p.getFirstName().equals(name))
			{
				tempPerson=p;
				break;
			}
		}
		return tempPerson;
	}
	@Override
	public Person findByLastName(String name) {
		// TODO Auto-generated method stub
		Person tempPerson=null;
		Collection<Person> personCollection=persons.values();
		for(Person p:personCollection)
		{
			if(p.getLastName().equals(name))
			{
				tempPerson=p;
				break;
			}
		}
		return tempPerson;
	}

	@Override
	public Person findByEmail(String email) {
		// TODO Auto-generated method stub
		Person tempPerson=null;
		Collection<Person> personCollection=persons.values();
		for(Person p:personCollection)
		{
			if(p.getEmail().equals(email))
			{
				tempPerson=p;
				break;
			}
		}
		return tempPerson;
	}

	@Override
	public String deletePersonById(Integer personId) {
		// TODO Auto-generated method stub
		Person tempPerson=null;
		Collection<Person> personCollection=persons.values();
		for(Person p:personCollection)
		{
			if(p.getPersonId()==personId)
			{
				persons.remove(personId);
				break;
			}
		}
		return "deleted";
	}

	

	

}