/**
 * 
 */
package com.practicaljava.lesson23.controller;

import com.practicaljava.lesson23.QuoteEmulator;
import com.practicaljava.lesson23.QuoteProvider;
import com.practicaljava.lesson23.model.MyTableModel;
import com.practicaljava.lesson23.view.MyFrameView;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class MyFrameController {
	
	public void showMyFrame(){
		
		QuoteEmulator quoteEmulator = new QuoteEmulator();
		QuoteProvider quoteProvider = new QuoteProvider();
		quoteEmulator.subscribe(quoteProvider);
		
		MyTableModel  tableModel = new MyTableModel(); 
		quoteProvider.subscribe(tableModel, "GOOG"); 
	
		MyFrameView myFrameView = new MyFrameView("Stock Quotes",tableModel); 
		myFrameView.setSize(300, 300);
		myFrameView.pack();
		myFrameView.setVisible(true);
		
		quoteEmulator.start();

	}
	

}
