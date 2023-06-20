package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@Column(name = "student_name")
	private String name;
	@Column(name = "entering_date")
	private String enteringDate;
	private String nationality;
	//@Column(name = "student_code")
	private String code;
	public Students() {
		super();
	}
	public Students( String name, String enteringDate, String nationality, String code) {
		super();
		//this.id = id;
		this.name = name;
		this.enteringDate = enteringDate;
		this.nationality = nationality;
		this.code = code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnteringDate() {
		return enteringDate;
	}
	public void setEnteringDate(String enteringDate) {
		this.enteringDate = enteringDate;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}