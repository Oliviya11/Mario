package com.mario.display;

import com.mario.ru.Chrono;
import com.mario.ru.Main;

public class Countdown implements Runnable{
    private final int PAUSE = 1000;
    private int timeCounter = 70;
    private String str = "Remaining time: 70";
    
    public Countdown() {
    	Thread countDown = new Thread(this);
    	countDown.start();
    }
	@Override
	public void run() {
		while(true) {
			try {Thread.sleep(PAUSE);
		     } catch (InterruptedException e) {}
			if (!Chrono.pause && timeCounter>0 && !Main.scene.checkWin() && !Main.scene.checkLose()) 
			timeCounter--;
			str = "Remaining time: "+timeCounter;
		}
		
	}
	public int getTimeCounter() {
		return timeCounter;
	}
	public String getStr() {
		return str;
	}
   
	
}
