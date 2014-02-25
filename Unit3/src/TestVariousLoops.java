/**
 * Demonstrate using loops in Java.
 */

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestVariousLoops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String gfriends[] = new String[10];

		gfriends[0] = "Masha";
		gfriends[1] = "Natasha";
		gfriends[3] = "Izolda";
		gfriends[9] = "Mishel";

		System.out.println("Loop one:");
		for (int i = 0; i < gfriends.length; i++) {
			if (gfriends[i] != null) {
				System.out.println("I love " + gfriends[i]);
			}

		}

		System.out.println("Loop two:");
		for (String gfriend : gfriends) {
			if (gfriend != null) {
				System.out.println("I love " + gfriend);
			}
		}

		System.out.println("Loop three:");
		int i = 0;
		while (i < gfriends.length) {
			if (gfriends[i] != null) {
				System.out.println("I love " + gfriends[i]);
			}
			i++;
		}

	}

}
