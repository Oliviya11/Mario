package com.mario.personage;


import javax.swing.ImageIcon;

public class Tortue extends EnemyPersonnage {

    public Tortue(int x, int y) {
		super(x, y, 27, 30, 20);
		super.isRight = true;
		super.go = true;
		super.go = true;
		super.icoDie = new ImageIcon(getClass().getResource("/images/tortDie.png"));
		super.imgDie = super.icoDie.getImage();
	}

}
