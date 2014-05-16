package com.orus.game;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel{

	private final String img = "images/pesho.png";
	
	public Board() {
		setBackground(Color.BLACK);

		Card newCard = new Card(20, 50);
		ImageIcon ii = new ImageIcon(this.getClass().getResource(img));
		newCard.setImage(ii.getImage());
	}
		
}
