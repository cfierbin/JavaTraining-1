/**
 * 
 */
package com.practicaljava.lesson6;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class ForeignContractor extends Person {

	/**
	 * @param name
	 */
	public ForeignContractor(String name) {
		super(name);
	}

	public boolean increasePay(int percent) {
		System.out.println("I'm just a foreign worker");
		return true;
	}
}
