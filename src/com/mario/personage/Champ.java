package com.mario.personage;

import javax.swing.ImageIcon;

public class Champ extends EnemyPersonnage{
	
	
	public Champ(int x, int y) {
		super(x, y, 27, 30, 15);
		super.isRight = true;
		super.go = true;
		super.icoDie = new ImageIcon(getClass().getResource("/images/champDie.png"));
		super.imgDie = super.icoDie.getImage();
	}
}
