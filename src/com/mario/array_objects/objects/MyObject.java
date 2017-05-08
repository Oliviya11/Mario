package com.mario.array_objects.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

public class MyObject {
private int length, height;
private int x, y;
private boolean blocked = false;
protected ImageIcon objectIco;
protected Image object;

MyObject(int x, int y, int length, int height) {
	this.x = x;
	this.y = y;
	this.length = length;
	this.height = height;
	
}

public boolean isBlocked() {
	return blocked;
}

public void setBlocked(boolean blocked) {
	this.blocked = blocked;
}

public int getLength() {
	return length;
}

public void setLength(int length) {
	this.length = length;
}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public Image getObject() {
	return object;
}
	


}
