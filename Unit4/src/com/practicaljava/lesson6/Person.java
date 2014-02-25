package com.practicaljava.lesson6;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return "Person's name is " + name;
	}

}
