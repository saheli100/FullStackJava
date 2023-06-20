/*
 * package com.example.demo.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.http.HttpStatus; //import
 * org.springframework.http.HttpStatusCode; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.demo.model.Person; import
 * com.example.demo.service.PersonService;
 * 
 * @RestController public class PersonController {
 * 
 * private PersonService personService;
 * 
 * public PersonController(PersonService personService) { super();
 * this.personService = personService; }
 * 
 * @PostMapping("/persons") public ResponseEntity<Person>
 * createPerson(@RequestBody Person person) {
 * 
 * Person p=personService.createPerson(person);
 * 
 * 
 * return ResponseEntity.status(HttpStatus.CREATED).body(p);
 * 
 * }
 * 
 * 
 * @GetMapping("/persons") public ResponseEntity<List<Person>> getAllPersons() {
 * return ResponseEntity.ok().body(personService.getAllPersons()); }
 * 
 * }
 */
package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {

	private PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping("/persons")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {

		Person p=personService.createPerson(person);
	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
		
	}
	
	
	@GetMapping("/persons")
	public ResponseEntity<Collection<Person>> getAllPersons()
	{
		return ResponseEntity.ok().body(personService.getAllPersons());
	}
	
	@GetMapping("/persons/{personId}")
	public ResponseEntity<?> getPersonById(@PathVariable("personId") Integer personid)
	{
		Person p=personService.getPeresonByIdPerson(personid);
		System.out.println(p);
		
		if(p==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with id: "+personid+" not found");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
	@PutMapping("/persons/{personId}")
	public ResponseEntity<?> updatePerson(@PathVariable("personId") Integer personId, @RequestBody Person person) {
		Person p=personService.updatePersonById(personId, person);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with id: " + personId + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}

	}
	@PutMapping("/person/{name}")
	public ResponseEntity<?> updatePersonByFirstName(@PathVariable("name") String name, @RequestBody Person person) {
		Person p=personService.updateByFirstName(name, person);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with name: " + name + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}

	}
	@GetMapping("/persons/name/{firstName}")
	public ResponseEntity<?> getPersonByFirstName(@PathVariable("firstName") String firstName)
	{
		Person p=personService.findByFirstName(firstName);
		if(p==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with the first name "+firstName+" not found");
		}
		else
		{
			return ResponseEntity.ok(p);
		}
	}
	@GetMapping("/persons/lastName/{lastName}")
	public ResponseEntity<?> getPersonByLastName(@PathVariable("lastName") String lastName)
	{
		Person p=personService.findByLastName(lastName);
		if(p==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with the last name "+lastName+" not found");
		}
		else
		{
			return ResponseEntity.ok(p);
		}
	}
	@GetMapping("/persons/email/{email}")
	public ResponseEntity<?> getPersonByEmail(@PathVariable("email") String email)
	{
		Person p=personService.findByEmail(email);
		if(p==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with email "+email+" not found");
		}
		else
		{
			return ResponseEntity.ok(p);
		}
	}
	@DeleteMapping("/persons/{id}")
	public ResponseEntity<?> deletePersonById(@PathVariable("id") Integer id)
	{
		String p=personService.deletePersonById(id);
		if(p==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with id "+id+" not found");
		}
		else
		{
			return ResponseEntity.ok(p);
		}
	}

}