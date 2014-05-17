package com.orus.game;

import java.awt.Image;


public class Card extends Sprite {
	private int x;
	private int y;
	private Image img;
	private int clickX;
	private int clickY;
	
	public Card(int x, int y) {
		this.x = x;
		this.y = y;
		
	}	
}