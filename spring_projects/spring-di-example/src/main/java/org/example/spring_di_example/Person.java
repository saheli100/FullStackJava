package org.example.spring_di_example;

public class Person {
	
	private String personId;
	private String personName;
	private Address address;

	
	/* public Person(Address address) { super(); this.address = address; } */
	 
	
		
		
		  public Address getAddress() { return address; } public void
		  setAddress(Address address) { this.address = address; }
		 
		 
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", address=" + address + "]";
	}
	
	

}