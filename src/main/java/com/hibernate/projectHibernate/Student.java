package com.hibernate.projectHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // marking
//@Table(name="myStudents") //renaming table name
public class Student {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + " : " + this.name + " : " + this.city;
	}

	@Id // making it primary key
	private int id;
	private String name;
	private String city;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
