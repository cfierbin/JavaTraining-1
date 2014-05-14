package com.practicaljava.lesson27.jsf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.practicaljava.lesson27.beans.QuoteBean;

@ManagedBean(name = "quoteController")
@SessionScoped
public class QuoteController implements Serializable {
	
	private QuoteBean quote1 = new QuoteBean("ORCL",10,75.00);
	
    private List<QuoteBean> items = Arrays.asList(quote1);

	public List<QuoteBean> getItems() {
	        if (items == null) {
	            items.add(new QuoteBean("ORCL",10,75.00));
	        }
	        return items;
	    }
	
}
