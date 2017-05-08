package com.mario.array_objects.objects;



import javax.swing.ImageIcon;

public class Block extends MyObject{

	public Block(int x, int y) {
		super(x, y, 30, 30);
		super.objectIco = new ImageIcon(getClass().getResource("/images/block.png"));
		super.object = super.objectIco.getImage();
	}
	

}
