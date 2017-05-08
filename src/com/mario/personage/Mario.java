package com.mario.personage;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.mario.array_objects.Enemies;
import com.mario.array_objects.Objects;
import com.mario.array_objects.objects.Block;
import com.mario.array_objects.objects.Coin;
import com.mario.array_objects.objects.MyObject;
import com.mario.array_objects.objects.Truba;
import com.mario.audio.Audio;
import com.mario.ru.Main;

public class Mario extends Personnage {
	
	private ImageIcon icoMario;
	private Image imgMario; 
	private int jumpHeight = 125;
	private int earthLevel = 265;
    private int MAX = earthLevel - jumpHeight;
    private boolean upJump=true, breakJump= false;
    private int jumpCounter = 0;
    private int liveCounter = 0;
    private boolean can = true;
    
	public Mario(int x, int y) {
		super(x, y, 20, 34);
	
	}

	public int getEarthLevel() {
		return earthLevel;
	}


	public int getMAX() {
		return MAX;
	}


	public void setMAX(int mAX) {
		MAX = mAX;
	}


	public int getJumpHeight() {
		return jumpHeight;
	}


	public void setJumpHeight(int jumpHeight) {
		this.jumpHeight = jumpHeight;
	}


	public void setEarthLevel(int earthLevel) {
		this.earthLevel = earthLevel;
	}

	public Image getImgMario(){return imgMario;}

	public ImageIcon getIcoMario() {
		return icoMario;
	}

	public void setIcoMario(ImageIcon icoMario) {
		this.icoMario = icoMario;
	}

    public boolean isUpJump() {
		return upJump;
	}


	public void setUpJump(boolean upJump) {
		this.upJump = upJump;
	}
	public boolean getBreakJump() {
		return breakJump;
	}


	public void setBreakJump(boolean breakJump) {
		this.breakJump = breakJump;
	}

	public Image jump() {
    	String str=null;
    	ImageIcon ico=null;
    	Image img = null;
   
    	if (isRight)
	    	str = "/images/manMarioJampRight.png";
	    	else
	    	str = "/images/manMarioJampLeft.png";
    	if (breakJump && y < earthLevel || y < MAX) {
            y=earthLevel; 
            jumpCounter++;
            Main.scene.setJump(false);
        	}	
    	   /*
    	if (breakJump && y < earthLevel || y < MAX) {
                //y=earthLevel; 
        		//if (y < earthLevel)
        			//y=y+1;
                jumpCounter++;
              //  Main.scene.setJump(false);
            	}
            */
    	if (upJump){
    		y=y-1;
    		if (y == MAX) { 
    			upJump = false;
    			jumpCounter++;
    			
    		}
    	}
    	else if (y < earthLevel){
    		 y=y+1;
    		 if (y  == earthLevel){
           		 upJump = true;	 	
           		 }
    		 if (isRight)
    		    	str = "/images/manMarioJamp2Right.png";
    		    	else
    		    	str = "/images/manMarioJamp2Left.png";
    	 }
    
    	ico = new ImageIcon(getClass().getResource(str));
    	img = ico.getImage();        
    	return img;
    	
    }
    private void peresekObjectY(MyObject object) {
    	if (y == object.getY()+ object.getHeight() && x + hauteur > object.getX() && x < object.getX() + object.getLength()+5)
    		breakJump = true;
    }
    private void peresekObjectX(MyObject object) {
    	if (x + largeur== object.getX()-1 && y + hauteur > object.getY() && y < object.getY() + object.getHeight()+5)
    		breakJump = true;
    }
    
    private void standOnObject2(MyObject object) {
    	if (y + hauteur < object.getY()  && x + largeur >= object.getX() && x + largeur/2 <= object.getX() + object.getLength() && alive) {
    		jumpCounter = 0;
    		
    		earthLevel = object.getY()- hauteur;
    		MAX = earthLevel - jumpHeight;
    		if (!Main.scene.isJump())
    			y = earthLevel - 1;
    			
      	}
    }

	public int getJumpCounter() {
		return jumpCounter;
	}


	public void setJumpCounter(int jumpCounter) {
		this.jumpCounter = jumpCounter;
	}

	public boolean getGo() {
		return false;
	}
	public boolean contactCoin(Coin coin){
		 if(coin.getX() >= x-5 && coin.getX()+coin.getLength() <= x+largeur+5 && coin.getY() >= y && coin.getY()+ coin.getHeight() <= y + hauteur && alive)
			 return true;
		  return false;
} 
	private void dieOrKill(EnemyPersonnage per){	
	if (per.alive && isAlive()){
		//107 240
	if(((x + largeur >= per.getX()&& isRight && x+largeur <= per.getX()+ per.getLargeur()) || (x <= per.getX()+per.getLargeur()&& !isRight && x >= per.getX()))&& y + hauteur <= per.getY()&& y+hauteur >=240){
	    per.setAlive(false);  
	    Audio.playSound("/mus/kill.wav");
	}
    if (((x + largeur >= per.getX()&& isRight && x+largeur <= per.getX()+ per.getLargeur()) || (x <= per.getX()+per.getLargeur()&& !isRight && x >= per.getX())) && y ==265){
    	super.alive = false;
       }
	 }
	 
	}
	public Image die(){
		ImageIcon ico;
		Image img;
		Main.scene.setDx(0);
		String str = "/images/bang.png";
		if (liveCounter==0)  Audio.playSound("/mus/bang.wav");
		if (liveCounter == 100) Audio.playSound("/mus/lose.wav"); 
		liveCounter++;
		if (liveCounter > 100){
			str = "/images/manMarioDie.png";
			setY(getY() - 1);
		}
		ico = new ImageIcon(getClass().getResource(str));
    	img = ico.getImage();     
    	return img;
		
	}
	
	public boolean leyInObject(Objects obj){
		ArrayList<MyObject> objects = obj.getObjects();
		for (MyObject o: objects){
			if (getX() + getLargeur() > o.getX() && getX() + getLargeur()/2 < o.getLength()+o.getX() && y+hauteur < o.getY()){ 
				return true;
			}
		}
		return false;
	}
	public boolean checkStandOnObject(Objects obj){
		ArrayList<MyObject> objects = obj.getObjects();
		for (MyObject o: objects){
			if(o instanceof Truba && contactAvant(o)){
				setGo(false);
				Main.scene.setDx(0);
			    return true;
			} 
		}
		return false;
	}
	public void hit(Objects obj){
		ArrayList<MyObject> objects = obj.getObjects();
		for (MyObject o: objects){
			peresekObjectX(o);
			if (o instanceof Block)
			peresekObjectY(o);
		}
	}
	public void stand(Objects obj) {
		ArrayList<MyObject> objects = obj.getObjects();
		for (MyObject o: objects){
			standOnObject2(o);
		}	
	}
	public void stop(Objects obj){
		ArrayList<MyObject> objects = obj.getObjects();
		for (MyObject o: objects){
			if(o instanceof Truba && contactAvant(o)){
				setGo(false);
				Main.scene.setDx(0);
			}
		}
	}
	
	public void kill(Enemies enem){
	       
		ArrayList<EnemyPersonnage> enemies = enem.getEnemies();
		
			for (EnemyPersonnage p: enemies){
	    		dieOrKill((EnemyPersonnage)p);
	    	}
	}
	public Image downToEarth() {
		String str=null;
    	ImageIcon ico=null;
    	Image img = null;
		 if (isRight)
		    	str = "/images/manMarioJamp2Right.png";
		    	else
		    	str = "/images/manMarioJamp2Left.png";
		earthLevel = 265;
		MAX = earthLevel - jumpHeight;
		if (y < earthLevel){
			y=y+1;
			can = false;
		}
		if (y == earthLevel) can = true;
		ico = new ImageIcon(getClass().getResource(str));
    	img = ico.getImage();        
    	return img;
	}

	public boolean isCan() {
		return can;
	}
}
