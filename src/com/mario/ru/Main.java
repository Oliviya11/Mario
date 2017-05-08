package com.mario.ru;

import javax.swing.JFrame;

public class Main {
	
	public static Scene scene;
	public static JFrame fenetre;
	
	public static void main(String[] args) {
		addScene();
		
	}
	
	public static void addScene(){
		fenetre = new JFrame("Mario");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(700, 360);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		scene = new Scene();
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);
	}

}
