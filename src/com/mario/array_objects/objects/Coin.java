package com.mario.array_objects.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mario.ru.Chrono;

public class Coin extends MyObject implements Runnable{
   private final int PAUSE = 15;
   private int counter;
   public Coin(int x, int y){
	   super(x, y, 10, 10);
	   
	   super.objectIco = new ImageIcon(getClass().getResource("/images/coin1.png"));
	   super.object = super.objectIco.getImage();
   }
   public Image twinkle() {
	   String str;
	   ImageIcon ico;
	   Image img;
	    counter++;
	    if (counter / 100 ==0)str = "/images/coin1.png";
	    else str = "/images/coin2.png";
	    if (counter == 200) counter = 0;
	    ico = new ImageIcon(getClass().getResource(str));
	    img = ico.getImage();
	    return img;
   }

@Override
public void run() {
	try {Thread.sleep(20);}
	catch (InterruptedException e){}
	
	while(true) {
		if (!Chrono.pause) twinkle();
		try {Thread.sleep(PAUSE);}
		catch (InterruptedException e){}
  }
 }


}
