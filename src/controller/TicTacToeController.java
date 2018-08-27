package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import model.TicTacToeModel;
import view.TicTacToeView;

public class TicTacToeController {
	
	private TicTacToeView _view; 
	private TicTacToeModel _model;
	
	public TicTacToeController() {
		
		this._view = new TicTacToeView();
		this._model = new TicTacToeModel();
		
		addListener();
		
		_view.init();
				
	}
	
	private void addListener() {
		_view.setButtonActionListener(new ButtonActionListener());
	}
	
	public void showView() {
		this._view.setVisible(true);
	}
	
	class ButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			_model.setDisbledClicks();
			button.setText(_model.getText());
			String name = button.getName();
			_model.addDisabledButtons(button);
			button.setEnabled(false);
								
			if(checkWin()) {
				_view.initializeWinningWindow(button.getText());
			}
		}		
	}
	
	private boolean checkWin() {
		
		List<JButton> disabledButtons = _model.getDisbaledButtons();
		String[][] winningOptions = new String[][] 
			{{"0", "1", "2"}, {"3", "4", "5"}, {"6", "7", "8"},
			{"0", "3", "6"}, {"1", "4", "7"}, {"2", "5", "8"},
			{"0", "4", "8"}, {"2", "4", "6"}};
		
			
		for (JButton button : disabledButtons) {
			for (String[] winningArray : winningOptions) {
				if(Arrays.asList(winningArray).contains(button.getName())) {
					int checked = 0;
					for (JButton value : disabledButtons) {
						if(Arrays.asList(winningArray).contains(value.getName()) && button.getText().equals(value.getText())) {
							checked++;
						}
					}
					if(checked == 3) {
						return true;
					}
				}
			}
		}	
		return false;				
	}
}
