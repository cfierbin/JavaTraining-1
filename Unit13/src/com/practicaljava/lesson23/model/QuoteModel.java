package com.practicaljava.lesson23.model;


/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class QuoteModel {
	
	public String symbol;
	public int quantity;
	public double price;
	
	
	public QuoteModel(String symbol, int quantity, double price){
		this.symbol = symbol;
		this.quantity = quantity;
		this.price = price;
	}
	
	public void printQuote(){
		System.out.println("symbol: " + symbol + " quantity: " + quantity + " price: " + price);
	}

}
