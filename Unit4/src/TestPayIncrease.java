/**
 * Demonstration of upcasting and downcasting in Java.
 */

import com.practicaljava.lesson6.Employee;
import com.practicaljava.lesson6.Payable;
import com.practicaljava.lesson6.Contractor;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestPayIncrease {
	public static void main(String[] args) {

		Payable workers[] = new Payable[3];

		workers[0] = new Employee("John");
		workers[1] = new Contractor("Barak");
		workers[2] = new Employee("Valera");

		for (Payable worker : workers) {
			worker.increasePay(30);
		}
	}
}
