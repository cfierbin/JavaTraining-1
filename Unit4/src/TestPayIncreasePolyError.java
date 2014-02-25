import com.practicaljava.lesson6.Contractor;
import com.practicaljava.lesson6.Employee;
import com.practicaljava.lesson6.ForeignContractor;
import com.practicaljava.lesson6.Payable;
import com.practicaljava.lesson6.Person;

/**
 * 
 */

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestPayIncreasePolyError {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Person workers[] = new Person[3];
		workers[0] = new Employee("Nikita");
		workers[1] = new Contractor("Stas");
		workers[2] = new ForeignContractor("Turbo");

		for (Person person : workers) {
			((Payable)person).increasePay(30);
		}
	}

}
