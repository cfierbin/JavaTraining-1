import com.practicaljava.lesson7.tryit.Employee;
import com.practicaljava.lesson7.tryit.Contractor;
import com.practicaljava.lesson6.Payable;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestPayIncreaseInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Payable workers[] = new Payable[3];

		workers[0] = new Employee("Nikita");
		workers[1] = new Contractor("Stas");
		workers[2] = new Employee("Turbo");

		for (Payable payable : workers) {
			((Payable) payable).increasePay(30);
		}

	}

}
