package com.practicaljava.unit1;

public class Main {

	public static void main(String[] args) {
		
		Person person = new Person(
				  "Svyatoslav"
				, "Strygin"
				, "27 Mezhevaya"
				, "Vsevolozhsk"
				, "Leningradskaya Oblast"
				, "188643"
				, "Russian Federation");
		
		person.PrintPersonInformation();
	}
}
