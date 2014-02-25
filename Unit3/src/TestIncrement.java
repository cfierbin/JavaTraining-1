/**
 * Demonstate of diffrence between ++i and i++ operations
 */

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestIncrement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int i = 0;
		
		System.out.println("i = " + i);
		
		System.out.println("i++ = " + i++);
		System.out.println("after i++, i = " + i);
		
		System.out.println("++i = " + ++i);
		System.out.println("after ++i, i = " + i);
	}

}
