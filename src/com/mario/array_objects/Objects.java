package com.mario.array_objects;

import java.awt.Graphics;
import java.util.ArrayList;

import com.mario.array_objects.objects.Block;
import com.mario.array_objects.objects.MyObject;
import com.mario.array_objects.objects.Truba;
import com.mario.ru.Main;

public class Objects {
	private ArrayList<MyObject> objects= new ArrayList<MyObject>();
	private Truba truba1 = new Truba(560, 227);
	private Truba truba2 = new Truba(1000, 227);
	private Truba truba3 = new Truba(1600, 227);
	private Truba truba4 = new Truba(1900, 227);
	private Truba truba5 = new Truba(2500, 227);
	private Truba truba6 = new Truba(3000, 227);
	private Truba truba7 = new Truba(3650, 227);
	private Truba truba8 = new Truba(4500, 227);
	
	private Block block1 = new Block(430, 195);
	private Block block2 = new Block(1230, 195);
	private Block block3 = new Block(1300, 185);
	private Block block4 = new Block(1370, 175);
	private Block block5 = new Block(2030, 195);
	private Block block6 = new Block(2630, 175);
 	private Block block7 = new Block(2695, 195);
	private Block block8 = new Block(3520, 175);
	private Block block9 = new Block(3580, 155);
	private Block block10 = new Block(4150, 185);
	private Block block11 = new Block(4230, 215);
	private Block block12 = new Block(4330, 225);
	
	public Objects(){
		addBlocks();
		addTrubs();
	}
	
	private void addBlocks() {
		objects.add(block1);
		objects.add(block2);
		objects.add(block3);
		objects.add(block4);
		objects.add(block5);
		objects.add(block6);
		objects.add(block7);
		objects.add(block8);
		objects.add(block9);
		objects.add(block10);
		objects.add(block11);
		objects.add(block12);
	}
	
	private void addTrubs() {
		objects.add(truba1);
		objects.add(truba2);
		objects.add(truba3);
		objects.add(truba4);
		objects.add(truba5);
		objects.add(truba6);
		objects.add(truba7);
		objects.add(truba8);
	}
	
	public void replace(){
		for (MyObject o: objects) {
			o.setX(o.getX() - Main.scene.getDx());
		}
	}

	public ArrayList<MyObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<MyObject> objects) {
		this.objects = objects;
	}
	public void drawObjects(Graphics g) {
		for (int i = 0; i < objects.size(); i++){
			g.drawImage(objects.get(i).getObject(), objects.get(i).getX(), objects.get(i).getY(), null);
		}
	}
	
}
