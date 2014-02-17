import com.practicaljava.unit2.*;

public class TestTax {

	public static void main(String[] args) {

		System.out.println("---------------------------------");
		System.out.println("Last rates: ");
		System.out.println("1 EUR : $" + Config.EUR_USD_RATE);
		System.out.println("1 USD : �" + Config.USD_EUR_RATE);
		System.out.println("---------------------------------");

		switch (args.length) {
		case 0:
		case 1:

			Tax tax1 = new Tax(65000, "TX", 4);
			tax1.printTax();

			Tax tax2 = new Tax(30000, "NY", 4);
			tax2.printTax();

			NJTax njTax1 = new NJTax(29000, 4);
			njTax1.printTax();
			break;

		case 2:

			NJTax njTax = new NJTax(Double.parseDouble(args[0]),
					Integer.parseInt(args[1]));
			njTax.printTax();
			break;

		case 3:

			Tax tax = new Tax(Double.parseDouble(args[0]), args[1],
					Integer.parseInt(args[2]));
			tax.printTax();
			break;

		default:
			System.out.println("Bad parameters");
			break;
		}

	}

}
