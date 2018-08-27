package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeView extends JFrame {
	
	private JButton[] buttons;
	private ActionListener actionListener;
	
	public TicTacToeView() {		
		
		super("TicTacToe");
		setLayout(new GridLayout(3, 3));					
	}
	
	public void init() {
		
		this.buttons = new JButton[9];
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();			
			buttons[i].setPreferredSize(new Dimension(100, 100));
			buttons[i].addActionListener(actionListener);
			buttons[i].setName(Integer.toString(i));
			add(buttons[i]);
		}		
		pack();
	}
	
	public void initializeWinningWindow(String value) {
		
		Object[] options = {"Yes, please",
        "No way!"};
		
		JOptionPane.showOptionDialog(this,
			String.format("%s has won the Game. \n" 
    		+ "Wanna restart?", value),
				
		"Game finished!",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,     					//do not use a custom Icon
		options,  					//the titles of buttons
		options[0]); 				//default button title
	}
	
	public void setButtonActionListener(ActionListener listener) {
		this.actionListener = listener;
	}
	
	
}
