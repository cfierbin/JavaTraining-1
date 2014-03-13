/**
 * 
 */
package com.practicaljava.unit5;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class Calculator {
	
	private JFrame mainWindow;
	private JPanel windowContent;
	private GridLayout gridLayout;
	private JButton[] numberButtons;
	
	
	
	public Calculator(){
	 
		
		windowContent = new JPanel();
		gridLayout = new GridLayout(4,3);
		
		windowContent.setLayout(gridLayout);
		
		
		numberButtons = new JButton[10];
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			windowContent.add(numberButtons[i]);
		}
		
		
		mainWindow = new JFrame("javax.swing Calculator");
		mainWindow.setContentPane(windowContent);
		mainWindow.setSize(400,400);
		mainWindow.setVisible(true);
		
	}
	
	
	
	
	

}
