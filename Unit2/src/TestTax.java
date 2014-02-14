import com.practicaljava.unit2.*;

public class TestTax {

	public static void main(String[] args) {

		System.out.println("---------------------------------");
		System.out.println("Last rates: ");
		System.out.println("1 EUR : $" + Config.EUR_USD_RATE);
		System.out.println("1 USD : �" + Config.USD_EUR_RATE);
		System.out.println("---------------------------------");

		Tax tax1 = new Tax(65000, "TX", 4);
		tax1.printTax();

		Tax tax2 = new Tax(30000, "NY", 4);
		tax2.printTax();

		NJTax njTax = new NJTax(29000, 4);
		njTax.printTax();

	}

}
