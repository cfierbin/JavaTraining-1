/**
 * 
 */
package com.practicaljava.lesson7;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class Contractor extends Person {

	/**
	 * @param name
	 */
	public Contractor(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practicaljava.lesson7.Person#increasePay(int)
	 */
	@Override
	public boolean increasePay(int percent) {
		System.out.println((percent < INCREASE_CAP) ? "Increasing salary by "
				+ percent + "%. " + getName()
				: "Sorry, can't increase hourly rate by more than "
						+ INCREASE_CAP + "%. " + getName());

		return percent < INCREASE_CAP;
	}

}
