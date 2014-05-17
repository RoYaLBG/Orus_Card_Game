package com.orus.game;

import java.awt.Image;

public class Sprite {
	private boolean visible;
	private Image image;
	protected int x;
	protected int y;
	
	public Sprite() {
		visible = true;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image){
		this.image = image;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
