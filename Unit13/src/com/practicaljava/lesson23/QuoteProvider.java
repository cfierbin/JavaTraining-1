package com.practicaljava.lesson23;

import java.util.ArrayList;

import com.practicaljava.lesson23.model.QuoteModel;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class QuoteProvider implements IQuoteStreamer {
	
	private volatile ArrayList<IQuoteStreamer> subscribersList;
	private volatile ArrayList<String> subscribersSymbol;
	
	public QuoteProvider(){
		subscribersList = new ArrayList<>();
		subscribersSymbol = new ArrayList<>();
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
	public void updateQuote(QuoteModel quote) {
		
		quote.printQuote();
		
		for (IQuoteStreamer  subscriber : subscribersList) {
			
			int index = subscribersList.indexOf(subscriber);
			
			if(quote.symbol.equals(subscribersSymbol.get(index))){
				subscriber.updateQuote(quote);
			}
		}
		
	}
		

}
