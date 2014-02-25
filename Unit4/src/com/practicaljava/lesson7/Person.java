/**
 * 
 */
package com.practicaljava.lesson7;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public abstract class Person {

	private String name;
	int INCREASE_CAP = 20;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return "Person's name is " + name;
	}

	public void changeAddress(String address) {
		System.out.println("New address is " + address);
	}

	private void giveDayOff() {
		System.out.println("Giving a day off to " + name);
	}

	public void promote(int percent) {
		System.out.println(" Promotion a worker...");
		giveDayOff();
		// calling an abstract method
		increasePay(percent);
	}

	// an abstcat method to be implemented in subclasses
	public abstract boolean increasePay(int percent);

}
