package com.practicaljava.lesson23.view;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.practicaljava.lesson23.model.MyTableModel;



@SuppressWarnings("serial")
public class MyFrameView extends JFrame implements TableModelListener {

	MyTableModel myTableModel;
	JTable myTable;

	public MyFrameView(String winTitle, MyTableModel tableModel) {
		super(winTitle);

		myTableModel = tableModel;
		myTable = new JTable(myTableModel);

		// Add the JTable to frame and enable scrolling
		add(new JScrollPane(myTable));

		// Register an event listener
		myTableModel.addTableModelListener(this);
	}

	public void tableChanged(TableModelEvent e) {
		// Code to process data changes goes here
		myTable.updateUI();
		
	}

	
}