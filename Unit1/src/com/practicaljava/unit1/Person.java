package com.practicaljava.unit1;

public class Person {
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	
	public Person(String firstName
				, String lastName
				, String address
				, String city
				, String state
				, String zipCode
				, String country)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}
	
	
	public void PrintPersonInformation(){
		System.out.println(this.firstName+" "+this.lastName);
		System.out.println(this.address);
		System.out.println(this.city+", "+this.state+" "+this.zipCode);
		System.out.println(this.country);
	}
}
