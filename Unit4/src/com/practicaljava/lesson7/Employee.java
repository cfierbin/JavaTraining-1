/**
 * 
 */
package com.practicaljava.lesson7;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class Employee extends Person {

	/**
	 * @param name
	 */
	public Employee(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practicaljava.lesson7.Person#increasePay(int)
	 */
	@Override
	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by " + percent + "%. "
				+ getName());

		return true;
	}

}
