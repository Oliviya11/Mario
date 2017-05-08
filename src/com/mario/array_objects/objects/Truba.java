package com.mario.array_objects.objects;

import javax.swing.ImageIcon;

public class Truba extends MyObject {
	
	public Truba(int x, int y) {
		super(x, y, 53, 71);
		super.objectIco = new ImageIcon(getClass().getResource("/images/truba.png"));
		super.object = super.objectIco.getImage();
		
	}
	

}
