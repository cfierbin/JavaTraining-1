package com.practicaljava.lesson6;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public interface Payable {
	public final int INCREASE_CAP = 20;

	boolean increasePay(int percent);
}
