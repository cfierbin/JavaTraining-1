import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestCollections {

	public static void main(String[] args) {
		
		LinkedList<String> passengerList = new LinkedList<>();
		
		passengerList.add("Nikita");
		passengerList.add("Stas");
		passengerList.add("Turbo");
		
		ListIterator<String> iterator = passengerList.listIterator();
		
		System.out.println(iterator.next());
		
		iterator.add("VIP Customer");
		iterator.previous();
		
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());

	}

}
