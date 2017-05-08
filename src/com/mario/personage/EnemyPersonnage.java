package com.mario.personage;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mario.ru.Chrono;


public class EnemyPersonnage extends Personnage implements Runnable {

	private final int PAUSE;
	private int dxEnemy;
	protected ImageIcon icoDie;
	protected Image imgDie;
	public EnemyPersonnage(int x, int y, int largeur, int hauteur, int p) {
		super(x, y, largeur, hauteur);
		PAUSE = p;
		Thread thread = new Thread(this);
		thread.start();
		
	}

	@Override
	public void run() {
		
		try {Thread.sleep(20);}
		catch (InterruptedException e){}
		
		while(true) {
	//	if (super.alive){
			if (super.alive && !Chrono.pause) change();
			try {Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
			}
//	  }
		
		
	}
	 public void change() {
	    	if (super.isRight) dxEnemy = 1;
	    	else dxEnemy = -1;
	    	super.setX(super.getX() + dxEnemy);
	    	
	    }
	    public void setIsRight(){
	    	if (super.isRight) super.isRight = false;
	    	else  super.isRight = true;
	    //	Main.scene.setDx(0);
	    	
	    }
		public int getDxEnemy() {
			return dxEnemy;
		}
		public void setDxEnemy(int dxEnemy) {
			this.dxEnemy = dxEnemy;
		}
		public boolean contactAvantEnemy(EnemyPersonnage object) {
			 if ((x + largeur >= object.getX()&& isRight && x+largeur <= object.getX()+object.getLargeur()) || (x - 7 <= object.getX()+object.getLargeur()&& !isRight && x - 7 >= object.getX()))
				   return true;
				 return false;
		  } 
		public Image getImg() {
			return imgDie;
		} 
		
}
