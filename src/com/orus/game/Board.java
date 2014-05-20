package com.orus.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	private Card newCard;
	private final String img = "images/craft.png";
	private final String backgroundImgString = "images/dungeon.png";
	private Image backgroundImage;
	private int clickX;
	private int clickY;
	MouseClickCoordinates mouseClickCoords;
	
	public Board() {
		setFocusable(true);
		init();
		
		backgroundImage = (new ImageIcon(getClass().getResource(backgroundImgString)).getImage());
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickX = e.getX();
				clickY = e.getY();
				
				mouseClickCoords = new MouseClickCoordinates();
				mouseClickCoords.setX(clickX);
				mouseClickCoords.setY(clickY);
				
				
				if (mouseClickCoords.getX() >= newCard.getX() && 
					mouseClickCoords.getX() <= newCard.getX() + 20 && 
					mouseClickCoords.getY() >= newCard.getY() && 
					mouseClickCoords.getY() <= newCard.getY() + 20) {
					
					System.out.println("IT WORKS!!!");
					System.out.println(mouseClickCoords.getX() + " " + mouseClickCoords.getY());
					
					//TODO: make side window for card preview, if clicked -> preview = true;
					newCard.setX(newCard.getX() + 10);
					newCard.setY(newCard.getY() + 10);
					
					repaint();
				}
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		 g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}

	public void init() {
		newCard = new Card();
		ImageIcon ii = new ImageIcon(this.getClass().getResource(img));
		newCard.setImage(ii.getImage());
		
		newCard.setX(100);
		newCard.setY(200);
		System.out.println(newCard.getX());
	}
	
	public void drawCard(Graphics g) {
		g.drawImage(newCard.getImage(), newCard.getX(), newCard.getY(), this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.BLACK);
		drawCard(g);
		
		g.dispose();
	}
	
	
//	public void run() {
//		while (true) {
//			repaint();			
//		}
//	}
		
}
