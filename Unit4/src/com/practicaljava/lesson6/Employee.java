package com.practicaljava.lesson6;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class Employee extends Person implements Payable {

	public Employee(String name) {
		super(name);
	}

	@Override
	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by " + percent + "%. "
				+ getName());
		return true;
	}
}
