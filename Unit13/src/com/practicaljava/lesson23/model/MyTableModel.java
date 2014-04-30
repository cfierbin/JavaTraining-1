/**
 * 
 */
package com.practicaljava.lesson23.model;

import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import com.practicaljava.lesson23.IQuoteStreamer;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
@SuppressWarnings("serial")
public class MyTableModel extends AbstractTableModel implements IQuoteStreamer {
	// The data for JTable should be here

	ArrayList<QuoteModel> myData = new ArrayList<>();
	String[] orderColNames = { "Symbol", "Quantity", "Price" };
	
	public MyTableModel() {
		myData.add(new QuoteModel("APPL", 100, 135.5f));
		myData.add(new QuoteModel("GOOG", 300, 290.12f));
		myData.add(new QuoteModel("MSFT", 2000, 8.32f));
		myData.add(new QuoteModel("YNDX", 500, 27.8f));
	}

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return myData.size();

	}

	public Object getValueAt(int row, int col) {

		switch (col) {
		case 0: 
			return myData.get(row).symbol;
		case 1: 
			return myData.get(row).quantity;
		case 2: 
			return myData.get(row).price;
		default:
			return "";
		}
	}

	public String getColumnName(int col) {
		return orderColNames[col];
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	@Override
	public void updateQuote(QuoteModel quote) {
		
		for (QuoteModel quoteModel : myData) {
			if(quoteModel.symbol.equals(quote.symbol)){
				quoteModel.price = quote.price;
				quoteModel.quantity = quote.quantity;
				
				TableModelEvent event = new TableModelEvent(this, myData.indexOf(quoteModel), 2);
				fireTableChanged(event);
			}
		}
		
	}

}
