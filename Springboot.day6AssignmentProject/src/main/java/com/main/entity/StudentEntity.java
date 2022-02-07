package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentEntity {
	
	int ssn;
	String name;	
	String email;
	String password;
	int age;
	
	public StudentEntity() {
		super();
	}

	public StudentEntity(int ssn, String name, String email, int age, String password) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
	}

	@Id
	@GeneratedValue
	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentDTO [ssn=" + ssn + ", name=" + name + ", email=" + email + ", password=" + password + ", age=" + age + "]";
	}
	

}
