package com.appy.domain;

public class Address {

	private String firstline;
	private String city;
	private String state;
	private String zip;
	
	public Address(){}

	public String getFirstline() {
		return firstline;
	}

	
	public Address(String firstline, String city, String state, String zip) {
		super();
		this.firstline = firstline;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public void setFirstline(String firstline) {
		this.firstline = firstline;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String toString(){
		return "Address: [firstline:"+ this.firstline+
				", city:" + this.city +
				", state:"+ this.state+
				", zip:" +this.zip+
				"]";
	}
}
