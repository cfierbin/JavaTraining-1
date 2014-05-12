package com.practicaljava.lesson27.jsf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.practicaljava.lesson27.beans.Quote;

@Named("quoteController")
@SessionScoped
public class QuoteController implements Serializable {
	
	private Quote quote1 = new Quote("ORCL",10,75.00);
	
    private List<Quote> items = Arrays.asList(quote1);

	public List<Quote> getItems() {
	        if (items == null) {
	            items.add(new Quote("ORCL",10,75.00));
	        }
	        return items;
	    }
	
}
