package com.appy.domain;

public class StudentVO {

	private String studentId;
	private String firstname;
	private String lastname;
	private Address address;
	
	public StudentVO(){}

	public StudentVO(String studentId, String firstname, String lastname, Address address) {
		super();
		this.studentId = studentId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	//TODO: there is a apache commons lib which can use reflection to do the toString()
	public String toString(){
		return "Student:[StudentId:"+this.studentId+
				", firstname:" + this.firstname+
				", lastname:" + this.lastname+
				", address:" + this.address+
				"]";
	}
	
}
