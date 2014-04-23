package com.practicaljava.lesson22;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class QuoteProvider implements IQuoteStreamer {
	
	private DAO dao;
	private volatile ArrayList<IQuoteStreamer> subscribersList;
	private volatile ArrayList<String> subscribersSymbol;
	
	public QuoteProvider(){
		subscribersList = new ArrayList<>();
		subscribersSymbol = new ArrayList<>();
		dao = new DAO();
	}
	
	
	public void subscribe(IQuoteStreamer subscriber, String symbol){
		subscribersList.add(subscriber);
		subscribersSymbol.add(symbol);
	}
	
	public void unsubscribe(IQuoteStreamer subscriber, String symbol){
		int index = subscribersList.indexOf(subscriber);
		subscribersSymbol.remove(index);
		subscribersList.remove(subscriber);
	}
	
	@Override
	public void updateQuote(Quote quote) {
		
		//Store quote to DB
		dao.insertQuote(quote.symbol, quote.quantity, quote.price);
		
		quote.printQuote();
		
		for (IQuoteStreamer  subscriber : subscribersList) {
			
			int index = subscribersList.indexOf(subscriber);
			
			if(quote.symbol.equals(subscribersSymbol.get(index))){
				subscriber.updateQuote(quote);
			}
		}
		
	}
		
		
		
		
		
		
	

	
	
	
	
}
