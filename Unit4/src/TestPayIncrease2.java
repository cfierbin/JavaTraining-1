import com.practicaljava.lesson7.Contractor;
import com.practicaljava.lesson7.Employee;
import com.practicaljava.lesson7.Person;

/**
 * 
 */

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestPayIncrease2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person workers[] = new Person[3];

		workers[0] = new Employee("Ignat");
		workers[1] = new Contractor("Terenty");
		workers[2] = new Employee("Vitaly");

		for (Person person : workers) {
			person.promote(30);
		}

	}

}
