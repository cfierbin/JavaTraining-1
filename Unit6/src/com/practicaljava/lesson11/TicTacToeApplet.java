package com.practicaljava.lesson11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.util.Random;


public class TicTacToeApplet extends JApplet implements MouseListener {
	private static final String PLAYERX = "Player X";
	private static final String PLAYERO = "Player O";
	private String playerName = PLAYERX;

	private JButton[] buttons = new JButton[9];
	private JLabel playerNumber;
	private Panel buttonsPanel;
	private JButton restartButton;
	private JCheckBox enableAI;
	private Color winColor = new Color(255,0,0); //Red color
	private Color defaultColor;
	
	private Random random = new Random();
	
	public void init() {
		initComponents();
	}

	private void initComponents() {

		buttonsPanel = new Panel();
		playerNumber = new JLabel(playerName, SwingConstants.CENTER);
		Font buttonFont = new Font("Times New Roman", Font.PLAIN, 60);
		buttonsPanel.setLayout(new java.awt.GridLayout(4, 3));
		
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttons[i].addMouseListener(this);
			buttons[i].setFont(buttonFont);
			buttonsPanel.add(buttons[i]);
		}

		setPlayerName(PLAYERX);
		buttonsPanel.add(playerNumber);
		restartButton = new JButton("Restart");
		restartButton.addMouseListener(this);
		defaultColor = restartButton.getBackground();
		buttonsPanel.add(restartButton);
		enableAI = new JCheckBox("Enable AI in Player O");
		enableAI.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (playerName == PLAYERO)
					decideByAI();
			}
		});
		
		buttonsPanel.add(enableAI);
		
		add(buttonsPanel);
	}

	private void setPlayerName(String playerName) {
		this.playerName = playerName;
		playerNumber.setText(playerName + " your turn!. ");
	}

	private void reset() {
		for (JButton button : buttons) {
			button.setText("");
			button.setBackground(defaultColor);
		}
		setPlayerName(PLAYERX);
	}

	public boolean checkForWinner() {

		if (findThreeInARow()) {
			String winnerName = (playerName == PLAYERX) ? PLAYERO : PLAYERX;
			playerNumber.setText(winnerName.concat(" won!!! Congratulations!!!"));
			return true;
		}
		return false;
	}
	
	
	private void decideByAI() {

		ArrayList<Integer> emptyButtons = new ArrayList<Integer>();

		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].getText() == "") {
				emptyButtons.add(i);
			}
		}

		int randomButtonIndex = emptyButtons.get(random.nextInt(emptyButtons.size()));

		MouseEvent me = new MouseEvent(buttons[randomButtonIndex],
				MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0,
				buttons[random.nextInt(8)].getHeight() + 1,
				buttons[random.nextInt(8)].getWidth() + 1, 
				1, false);
		buttons[random.nextInt(8)].dispatchEvent(me);
	}
	
	
	public void mouseClicked(MouseEvent e) {
		javax.swing.JButton currentButton = (JButton) e.getComponent();

		if (currentButton.getText() == "Restart") {
			reset();

		} else {

			if (currentButton.getText() == "") {
				if (playerName == PLAYERX) {
					currentButton.setText("X");
					setPlayerName(PLAYERO);

					if (!checkForWinner() && enableAI.isSelected()) {
						decideByAI();
					}

				} else if (playerName == PLAYERO) {
					currentButton.setText("O");
					setPlayerName(PLAYERX);
					checkForWinner();
				}
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	
	private boolean setColorForThreeButtons(int buttonIndex1, int buttonIndex2, int buttonIndex3){
		buttons[buttonIndex1].setBackground(winColor);
		buttons[buttonIndex2].setBackground(winColor);
		buttons[buttonIndex3].setBackground(winColor);
		return true;
	}
	

	private boolean findThreeInARow() {
		
		for (int i = 0; i < 7; i=i+3) {
			//Horizontal lines
			if (buttons[i].getText() != "" && buttons[i].getText() == buttons[i + 1].getText()&& buttons[i + 1].getText() == buttons[i + 2].getText())
				return setColorForThreeButtons(i, i + 1, i + 2);
		}
		
		for (int i = 0; i < 3; i++) {
			//Vertical lines
		    if(buttons[i].getText() != "" && buttons[i].getText() == buttons[i + 3].getText()&& buttons[i + 3].getText() == buttons[i + 6].getText())
				return setColorForThreeButtons(i, i + 3, i + 6);
		}
		
		// Diagonal line like "\" 
		if (buttons[0].getText() != "" && buttons[0].getText() == buttons[4].getText() && buttons[4].getText() == buttons[8].getText())
			return setColorForThreeButtons(0, 4, 8);
		
		//Diagonal line like "/"
		if(buttons[2].getText() != "" && buttons[2].getText() == buttons[4].getText() && buttons[4].getText() == buttons[6].getText())
			return setColorForThreeButtons(2, 4, 6);
		
		//By default
		return false;
	}
}