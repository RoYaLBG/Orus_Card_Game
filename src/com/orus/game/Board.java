package com.orus.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	private Card newCard;
	private final String img = "images/craft.png";
	private Image image;
	private int clickX;
	private int clickY;
	private Dimension dim;
	
	public Board() {
		dim = new Dimension(200, 200);
		setBackground(Color.BLACK);
		setFocusable(true);
		init();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickX = e.getX();
				clickY = e.getY();
				
				if (clickX >= newCard.getX() && clickX <= newCard.getX() + 20 && clickY >= newCard.getY() && clickY <= newCard.getY() + 20) {
					System.out.println("IT WORKS!!!");
					
					newCard.setX(50);
					newCard.setY(50);
					repaint();
				}
			}
		});
	}
	
	public void init() {
		newCard = new Card(20, 50);
		ImageIcon ii = new ImageIcon(this.getClass().getResource(img));
		newCard.setImage(ii.getImage());
		
		
	}
	
	public Image getImage() {
		return image;
	}
	
	public void drawPesho(Graphics g) {
		g.drawImage(newCard.getImage(), newCard.getX(), newCard.getY(), this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.BLACK);
		drawPesho(g);
		
		g.dispose();
	}
	
	
	
//	public void run() {
//		repaint();
//	}
		
}
