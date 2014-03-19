package com.practicaljava.unit7;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class OrderWindow extends JFrame implements ActionListener {

	private JPanel windowContent;
	private GridLayout flowLayout;

	private JLabel bikeModelText;
	private JComboBox bikeModel;

	private JLabel bikeCountText;
	private JTextField bikeCount;

	private JButton placeOrder;
	private JLabel notification;

	private BikeOrder bikeOrder;

	public OrderWindow() {

		windowContent = new JPanel();
		flowLayout = new GridLayout(3, 2);
		windowContent.setLayout(flowLayout);

		bikeModelText = new JLabel("Bike model:");
		windowContent.add(bikeModelText);
		bikeModel = new JComboBox(BikeTypes.values());
		windowContent.add(bikeModel);

		bikeCountText = new JLabel("Count");
		windowContent.add(bikeCountText);
		bikeCount = new JTextField();
		windowContent.add(bikeCount);

		placeOrder = new JButton("placeOrder");
		placeOrder.addActionListener(this);
		windowContent.add(placeOrder);

		notification = new JLabel("");
		windowContent.add(notification);

		bikeOrder = new BikeOrder();

		setSize(400, 120);
		add(windowContent);
		setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {

		// bikeCount.get
		if (event.getSource() == placeOrder) {

			try {

				String textValue = bikeCount.getText();
				int bikeCount = Integer.parseInt(textValue);

				bikeOrder.AddBikesToOrder(
						(BikeTypes) bikeModel.getSelectedItem(), bikeCount);

				notification.setText("Order placed!");
			} catch (TooManyBikesException e) {
				notification.setText(e.getMessage());
			}
			finally
			{
				bikeOrder.clearOrder();
			}
		}

	}

}
