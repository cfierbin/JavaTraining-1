import com.practicaljava.lesson22.QuoteEmulator;
import com.practicaljava.lesson22.QuoteProvider;
import com.practicaljava.lesson22.WatchList;


/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestWatchList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		QuoteEmulator quoteEmulator = new QuoteEmulator();
		QuoteProvider quoteProvider = new QuoteProvider();
		quoteEmulator.subscribe(quoteProvider);
		
		WatchList watchList = new WatchList(quoteProvider);
		quoteProvider.subscribe(watchList, "APPL"); //default symbol
		
		quoteEmulator.start();
	}

}
