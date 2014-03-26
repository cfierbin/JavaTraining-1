import java.util.ArrayList;

import com.practicaljava.lesson15.Employee;
import com.practicaljava.lesson15.RetiredEmployee;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestGenerics {

	public static void main(String[] args) {
		
		ArrayList<Employee> listEmployees = new ArrayList<>();
		
		listEmployees.add(new Employee("Barak", "Obama"));
		listEmployees.add(new RetiredEmployee("Robert", "Gates"));
		listEmployees.add(new RetiredEmployee("Gerge W.", "Bush"));
		listEmployees.add(new Employee("John F.", "Kerry"));
		
		ArrayList<RetiredEmployee> listRetiredEmployees =GetRetiredEmployees(listEmployees);
		
		System.out.println("All employees:");
		PrintEmployeeInformation(listEmployees);
		
		System.out.println("Retired employees:");
		PrintEmployeeInformation(listRetiredEmployees);
			
	}
	
	public static void PrintEmployeeInformation(ArrayList<? extends Employee> listEmployees){
		for (Employee employee : listEmployees) {
			employee.PrintEmployeeName();
		}
	}
	
	
	public static <T> ArrayList<RetiredEmployee> GetRetiredEmployees (ArrayList<? extends Employee> listEmployees){
		
		ArrayList<RetiredEmployee> listRetiredEmployees = new ArrayList<>();
		
		for (int i = 0; i < listEmployees.size(); i++) {
			
			@SuppressWarnings("unchecked")
			T listItem = (T) listEmployees.get(i);
			
			if (listItem instanceof RetiredEmployee) {
				
				listRetiredEmployees.add((RetiredEmployee) listItem);
			}
		}
		
		return listRetiredEmployees;
	}

}
