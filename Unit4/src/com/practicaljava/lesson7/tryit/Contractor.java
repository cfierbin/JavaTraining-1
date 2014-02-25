package com.practicaljava.lesson7.tryit;

import com.practicaljava.lesson6.Payable;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class Contractor implements Payable {

	private String name;

	public Contractor(String name) {
		this.name = name;
	}

	public boolean increasePay(int percent) {
		System.out.println(
				        (percent < INCREASE_CAP) 
				        ? "Increasing hourly rate by " + percent + "%. "
						: "Sorry, can't increase hourly rate by more than " + INCREASE_CAP + "%: " + name
		);
		return percent < INCREASE_CAP;
	}

}
