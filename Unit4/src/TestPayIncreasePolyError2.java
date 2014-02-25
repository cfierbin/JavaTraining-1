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
public class TestPayIncreasePolyError2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Payable workers[] = new Payable[3];
		workers[0] = new Employee("Nikita");
		workers[1] = new Contractor("Stas");
		//workers[2] = new ForeignContractor("Turbo");

		for (Payable person : workers) {
			((Payable)person).increasePay(30);
		}
	}

}
