package com.practicaljava.lesson7.tryit;

import com.practicaljava.lesson6.Payable;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class Employee implements Payable {

	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by" + percent + "%:" + name);
		return true;
	}

}
