package com.orus.game;

import javax.swing.JFrame;

public class Game extends JFrame {

	public Game() {
		setTitle("Test Frame");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		add(new Board());
	}
	
	public static void main(String[] args) {
		Game pesho = new Game();
		
	}

}
