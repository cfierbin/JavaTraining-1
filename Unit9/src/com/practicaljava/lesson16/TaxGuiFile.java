package com.practicaljava.lesson16;

import java.awt.event.*;

import javax.swing.*;

import java.awt.GridLayout;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class TaxGuiFile extends JFrame implements ActionListener,
		Externalizable {
	JLabel lblGrIncome;
	JTextField txtGrossIncome = new JTextField(15);
	JLabel lblDependents = new JLabel("Number of Dependents:");
	JTextField txtDependents = new JTextField(2);
	JLabel lblState = new JLabel("State: ");

	// Define a data model for the ComboBox chState
	Vector states = new Vector(50);

	// Create a combobox to get data from the model
	JComboBox chState = new JComboBox(states);

	JLabel lblTax = new JLabel("State Tax: ");
	JTextField txtStateTax = new JTextField(10);
	JButton bGo = new JButton("Go");
	JButton bReset = new JButton("Reset");

	public TaxGuiFile() {
		lblGrIncome = new JLabel("Gross Income: ");
		GridLayout gr = new GridLayout(5, 2, 1, 1);
		setLayout(gr);

		add(lblGrIncome);
		add(txtGrossIncome);
		add(lblDependents);
		add(txtDependents);
		add(lblState);
		add(chState);
		add(lblTax);
		add(txtStateTax);
		add(bGo);
		add(bReset);

		// Populate states from a file
		populateStates();

		chState.setSelectedIndex(0);

		txtStateTax.setEditable(false);

		bGo.addActionListener(this);
		bReset.addActionListener(this);

		// Define, instantiate and register a WindowAdapter
		// to process windowClosing Event of this frame

		try (FileInputStream fIn = new FileInputStream(Config.APPLICATION_PATH
				+ "TaxGuiFile.ser");
				ObjectInputStream in = new ObjectInputStream(fIn);) {

			readExternal(in);

		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try (FileOutputStream fOut = new FileOutputStream(
						Config.APPLICATION_PATH + "TaxGuiFile.ser");
						ObjectOutputStream out = new ObjectOutputStream(fOut);) {
					writeExternal(out);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Good bye!");
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == bGo) {
			// The Button Go processing
			try {
				int grossInc = Integer.parseInt(txtGrossIncome.getText());
				int dependents = Integer.parseInt(txtDependents.getText());
				String state = (String) chState.getSelectedItem();

				Tax tax = new Tax(dependents, state, grossInc);
				String sTax = Double.toString(tax.calcTax());
				txtStateTax.setText(sTax);
			} catch (NumberFormatException e) {
				txtStateTax.setText("Non-Numeric Data");
			} catch (Exception e) {
				txtStateTax.setText(e.getMessage());
			}
		} else if (source == bReset) {
			// The Button Reset processing
			txtGrossIncome.setText("");
			txtDependents.setText("");
			chState.setSelectedIndex(0);
			txtStateTax.setText("");
		}
	}

	// The code below will read the file states.txt and
	// populate the dropdown chStates
	private void populateStates() {

		states.add("Select State");

		try (FileInputStream myFile = new FileInputStream(
				Config.APPLICATION_PATH + "states.txt");
				InputStreamReader inputStreamReader = new InputStreamReader(
						myFile, "UTF8");
				BufferedReader reader = new BufferedReader(inputStreamReader);) {
			String nextLine;
			boolean eof = false;
			while (!eof) {
				nextLine = reader.readLine();
				if (nextLine == null) {
					eof = true;
				} else {
					// Populate the model
					states.add(nextLine);
				}
			}

		} catch (IOException e) {
			txtStateTax.setText("Can't read states.txt");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		txtGrossIncome.setText(in.readUTF());
		txtDependents.setText(in.readUTF());
		chState.setSelectedIndex(in.readInt());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(txtGrossIncome.getText());
		out.writeUTF(txtDependents.getText());
		out.writeInt(chState.getSelectedIndex());
	}

}
