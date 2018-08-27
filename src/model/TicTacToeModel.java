package model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;

public class TicTacToeModel {
	
	private int disabledClicks = 0;
	private List<JButton> disabledButtons = new ArrayList<JButton>();

	public void setDisbledClicks() {
		disabledClicks++;
	}
	
	public int getDisbledClicks() {
		return this.disabledClicks;
	}
	
	public String getText() {
		if(this.getDisbledClicks() % 2 != 0) {
			return "X";
		}
		else {
			return "O";
		}
	}
	
	public void addDisabledButtons(JButton value) {
		this.disabledButtons.add(value);
	}
	
	public List<JButton> getDisbaledButtons() {
		return this.disabledButtons;
	}
}
