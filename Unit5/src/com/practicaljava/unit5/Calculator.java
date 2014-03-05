package com.practicaljava.unit5;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class Calculator {
	
	private JPanel windowContent;
	private JTextField displayField;
	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton bottonPoint;
	private JButton buttonEqual;
	private JPanel panel;
	
	
	public Calculator(){
		
		windowContent = new JPanel();
		
		BorderLayout borderLayout = new BorderLayout();
		windowContent.setLayout(borderLayout);
		
		displayField = new JTextField(30);
		windowContent.add("North", displayField);
		
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		
		bottonPoint = new JButton(".");
		buttonEqual = new JButton("=");
		
		panel = new JPanel();
		
		GridLayout gridLayout = new GridLayout(4,3);
		panel.setLayout(gridLayout);
		panel.add(button0);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(bottonPoint);
		panel.add(buttonEqual);
		
		windowContent.add("Center",panel);
		
		JFrame frame = new JFrame("Calculator");

		frame.setContentPane(windowContent);
		frame.pack();
		frame.setVisible(true);
	}
}
