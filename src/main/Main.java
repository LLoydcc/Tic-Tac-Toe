package main;

import controller.TicTacToeController;
import view.TicTacToeView;

public class Main {

	public static void main(String[] args) {
		
		TicTacToeController controller = new TicTacToeController();
		controller.showView();		
	}

}
