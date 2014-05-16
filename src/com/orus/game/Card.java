package com.orus.game;

import java.awt.Image;


public class Card {
	private final int x;
	private final int y;
	private Image img;
	
	public Card(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	public void setImage(Image image) {
		this.img = image;
	}
}
