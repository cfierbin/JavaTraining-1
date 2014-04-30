package com.practicaljava.lesson23;

import java.util.ArrayList;
import java.util.Random;

import com.practicaljava.lesson23.model.QuoteModel;

/**
 * 
 */

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class QuoteEmulator extends Thread {
	
	private final String[] symbols = {"APPL","GOOG","MSFT","YNDX"};
	private ArrayList<IQuoteStreamer> subscribersList;
	private Random numericGenerator;
	
	public QuoteEmulator(){
		subscribersList = new ArrayList<>();
		numericGenerator = new Random();
	}
	
	public void subscribe(IQuoteStreamer subscriber){
		subscribersList.add(subscriber);
	}
	
	public void unsubscribe(IQuoteStreamer subscriber){
		subscribersList.remove(subscriber);
	}
	
	private void sendQuote(){
		
		QuoteModel quote = new QuoteModel(
				  symbols[numericGenerator.nextInt(4)]
				, numericGenerator.nextInt(100)
				, numericGenerator.nextDouble() + numericGenerator.nextInt(10)+90);
		
		for (IQuoteStreamer subscriber : subscribersList) {
			subscriber.updateQuote(quote);
		}
	}

	public void run(){
		
		for (int i = 0; i < 100; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sendQuote();
		}
		
		System.out.println("Business day Exchange ended");
		
	}
	
}
