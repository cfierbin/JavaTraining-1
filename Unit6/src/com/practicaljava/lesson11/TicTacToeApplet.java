package com.practicaljava.lesson11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class TicTacToeApplet extends JApplet implements MouseListener {
	private static final String PLAYERX = "Player X";
	private static final String PLAYERO = "Player O";

	private String playerName = PLAYERX;

	private JButton[] buttons = new JButton[9];

	private JLabel playerNumber;
	private Panel buttonsPanel;
	
	private Color winColor = new Color(255,0,0);//red

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
		add(buttonsPanel);
	}

	private void setPlayerName(String playerName) {
		this.playerName = playerName;
		playerNumber.setText(playerName + " your turn!. ");
	}

	private void reset() {
		for (JButton button : buttons) {
			button.setText("");
		}
		setPlayerName(PLAYERX);
	}

	public void checkForWinner() {

		if (findThreeInARow()) {
			String winnerName = (playerName == PLAYERX) ? PLAYERO : PLAYERX;
			playerNumber.setText(winnerName.concat(" won!!! Congratulations!!!"));
			//reset();
		}

	}

	public void mouseClicked(MouseEvent e) {
		javax.swing.JButton currentButton = (JButton) e.getComponent();
		if (currentButton.getText() == "") {
			if (playerName == PLAYERX) {
				currentButton.setText("X");
				setPlayerName(PLAYERO);
			} else if (playerName == PLAYERO) {
				currentButton.setText("O");
				setPlayerName(PLAYERX);
			}
		}
		checkForWinner();
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
		
		for (int i = 0; i < 3; i++) {
			
			//Horizontal lines
			if (buttons[i].getText() != "" && buttons[i].getText() == buttons[i + 1].getText()&& buttons[i + 1].getText() == buttons[i + 2].getText())
				return setColorForThreeButtons(i, i + 1, i + 2);
			
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