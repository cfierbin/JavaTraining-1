/**
 * 
 */
package com.practicaljava.lesson15;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class Employee {
	
	private String firstName;
	private String lastName;
	
	public Employee(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void PrintEmployeeName(){
		System.out.println("My name is : " + firstName + " " + lastName);
	}

}
