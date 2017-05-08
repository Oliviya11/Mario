package com.mario.personage;

import java.awt.*;
import javax.swing.ImageIcon;
import com.mario.array_objects.objects.MyObject;
import com.mario.ru.Main;



public class Personnage {
  protected int largeur, hauteur;
  protected int x, y;
  private int counter=0;
  protected boolean alive = true;
  protected boolean go = false;
  protected boolean isRight = true;
  
  public Personnage(int x, int y, int largeur, int hauteur) {
	  
	  this.x = x;
	  this.y = y;
	  this.largeur = largeur;
	  this.hauteur = hauteur;
	  
  }

public int getLargeur() {
	return largeur;
}

public void setLargeur(int largeur) {
	this.largeur = largeur;
}

public int getHauteur() {
	return hauteur;
}

public void setHauteur(int hauteur) {
	this.hauteur = hauteur;
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

public boolean isGo() {
	return go;
}

public void setGo(boolean go) {
	this.go = go;
}

public boolean isRight() {
	return isRight;
}

public void setIsRight(boolean isRight) {
	this.isRight = isRight;
}


  
//****Methods****
public Image go(String name, int frequence) {
	
	String str=null;
	ImageIcon ico=null;
	Image img = null;
	
	if ((Main.scene.getxChateau1() > 390 && !isRight) && name.equals("manMario")){
		go = false;
		Main.scene.setDx(0);
	}
	if ((Main.scene.getxPesh() < 432 && isRight) && name.equals("manMario")){
		go = false;
		Main.scene.setDx(0);
	}
	
	 if (!go){
		if (isRight) str = "/images/"+name+"StandRight.png";
		else str = "/images/"+name+"StandLeft.png";
	}
	else {
		counter++;
		if (counter / frequence ==0){
		if (isRight) str = "/images/"+name+"StandRight.png";
		else str = "/images/"+name+"StandLeft.png";
	  }
		else {
			if (isRight) str = "/images/"+name+"GoRight.png";
			else str = "/images/"+name+"GoLeft.png";
		}
	 if (counter == 2*frequence) counter =0;
	}
	
	ico = new ImageIcon(getClass().getResource(str));
	img = ico.getImage();
	
	return img;

}

  public boolean contactAvant(MyObject object) {
	 if (((x + largeur + 7 >= object.getX()&& isRight && x+largeur + 7 <= object.getX()+ object.getLength()) || (x <= object.getX()+object.getLength()&& !isRight && x >= object.getX()))&& y + hauteur > object.getY())
		   return true;
		 return false;
  }

public boolean isAlive() {
	return alive;
}

public void setAlive(boolean alive) {
	this.alive = alive;
} 

}
