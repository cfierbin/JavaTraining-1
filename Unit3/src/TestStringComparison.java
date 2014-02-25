/**
 * Demonstrate of features for working with strings in Java. 
 */

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestStringComparison {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Case one:");
		String gfriend = "Masha";
		if (gfriend == "Masha") {
			System.out.println("Expression (gfiend == \"Masha\") return true");
		} else {
			System.out.println("Expression (gfiend == \"Masha\") return false");
		}

		System.out.println("Case two:");

		String gfriend1 = new String("Natasha");
		String gfriend2 = new String("Natasha");

		if (gfriend1 == gfriend2) {
			System.out.println("Expression (gfriend1 == gfriend2) return true");
		} else {
			System.out
					.println("Expression (gfriend1 == gfriend2) return false");
		}

		System.out.println("Case three:");
		if (gfriend1 == "Natasha") {
			System.out
					.println("Expression (gfriend1 == \"Natasha\") return true");
		} else {
			System.out
					.println("Expression (gfriend1 == \"Natasha\") return false");
		}

		System.out.println("Case four:");
		if (gfriend1.equals(gfriend2)) {
			System.out
					.println("Expression (gfriend1.equals(gfriend2)) return true");
		} else {
			System.out
					.println("Expression (gfriend1.equals(gfriend2)) return false");
		}

		System.out.println("Case five:");
		if ("Natasha".equals(gfriend1)) {
			System.out
					.println("Expression (\"Natasha\".equals(gfriend1)) return true");
		} else {
			System.out
					.println("Expression (\"Natasha\".equals(gfriend1)) return false");
		}

	}

}
