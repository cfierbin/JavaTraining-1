/**
 * 
 */
package com.practicaljava.lesson22;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class WatchList implements IQuoteStreamer, ActionListener {

	private QuoteProvider quoteProvider;
	private Color color = Color.black;
	private JFrame watchListForm;
	private JPanel windowContent;
	private JButton subscribe;

	private double lastPrice;

	private JTextField symbol;
	private JLabel price;
	private JLabel quantity;

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;

	public WatchList(QuoteProvider quoteProvider) {

		this.quoteProvider = quoteProvider;

		lastPrice = 0;
		windowContent = new JPanel();
		windowContent.setLayout(new java.awt.GridLayout(2, 4));

		label1 = new JLabel("");
		windowContent.add(label1);
		label2 = new JLabel("SYMBOL");
		windowContent.add(label2);
		label3 = new JLabel("PRICE");
		windowContent.add(label3);
		label4 = new JLabel("QUANTITY");
		windowContent.add(label4);

		symbol = new JTextField("APPL");
		price = new JLabel();
		quantity = new JLabel();

		subscribe = new JButton("Subscribe");
		subscribe.addActionListener(this);

		windowContent.add(subscribe);
		windowContent.add(symbol);
		windowContent.add(price);
		windowContent.add(quantity);

		watchListForm = new JFrame("Watch List");
		watchListForm.setContentPane(windowContent);
		watchListForm.pack();
		watchListForm.setSize(500, 150);
		watchListForm.setVisible(true);
	}

	public void updateQuote(Quote quote) {

		if (quote.price > lastPrice)
			color = Color.green;
		else
			color = Color.red;

		price.setText(String.format("%.4f", quote.price));
		price.setForeground(color);
		quantity.setText(Integer.toString(quote.quantity));
		quantity.setForeground(color);
		symbol.setForeground(color);

		lastPrice = quote.price;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		quoteProvider.subscribe(this, symbol.getText());
	}

}
