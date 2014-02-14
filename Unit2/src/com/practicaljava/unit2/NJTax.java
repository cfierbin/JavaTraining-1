package com.practicaljava.unit2;

public class NJTax extends Tax {

	public NJTax(double grossIncome, int dependents) {
		super(grossIncome, "NJ", dependents);
	}

	public double adjustForStudents(double stateTax) {
		double adjustedTax = stateTax - 500;
		return adjustedTax;
	}
	
	public double calcTax(){
		return adjustForStudents(super.calcTax());
	}
	
}
