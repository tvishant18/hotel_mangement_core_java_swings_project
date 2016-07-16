package com.service;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;

public class Image_panel2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private BufferedImage image;
	
	public Image_panel2() {
		setForeground(Color.BLACK);
		setBackground(new Color(204, 102, 0));
try {
	image=ImageIO.read(new File("C:\\Users\\vishant thakur\\Desktop\\wallpaper.jpg"));
} catch (IOException e) {
	
	e.printStackTrace();
}
		
	}
protected void paintComponent(Graphics g){
	super.paintComponent(g);
	g.drawImage(image, 30, 0, null);
}
}
