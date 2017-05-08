package com.mario.ru;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.mario.audio.Audio;

public class Controller implements KeyListener{
	@Override
	public void keyPressed(KeyEvent e) { 
  if (checkConditionsOfMariosMoving()){
	   if (e.getKeyCode() == KeyEvent.VK_RIGHT && checkConditionsOfMariosGoingRight()){
		   makeMarioGoRight();
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT && checkConditionsOfMariosGoingLeft()){
		    makeMarioGoLeft();
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			makeMariosJumpPossible();
		}
	}
		if (e.getKeyCode() == KeyEvent.VK_CAPS_LOCK){
               makePause();
	    }  else if (e.getKeyCode() == KeyEvent.VK_ENTER){
		    makeNewGame();
	    }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.scene.setDx(0);
		Main.scene.getMario().setBreakJump(true);
		Main.scene.getMario().setGo(false);
	    Main.scene.getMario().setUpJump(true);
		}
		

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}
	 private void prepereMarioForJump() {
		 if (Main.scene.getMario().isCan()){
				Main.scene.setJump(true);
				Main.scene.getMario().setBreakJump(false);
				}
	 }
	 
	 private void makeSoundWhenMarioJamp() {
		 if ((Main.scene.getMario().getEarthLevel() - 1 == Main.scene.getMario().getY() || Main.scene.getMario().getY()== 265)  && !Chrono.pause){
				Audio.playSound("/mus/jump2.wav");
			}
	 }
	
	 private void makeMariosJumpPossible() {
		 makeSoundWhenMarioJamp();
		 prepereMarioForJump();
	 }
	 
	 private void makeMarioGoLeft() {
			Main.scene.setDx(-1);
			Main.scene.getMario().setIsRight(false);
		    Main.scene.getMario().setGo(true);
	 }
	 
	 private void makeMarioGoRight() {
		   Main.scene.setDx(1);
		   Main.scene.getMario().setIsRight(true);
		   Main.scene.getMario().setGo(true);
	 }
	 
	 private void makePause() {
		 if (Chrono.pause) Chrono.pause = false;
	    	else  Chrono.pause = true;
	 }
	 private void makeNewGame() {
			Main.fenetre.dispose();
	    	Main.addScene();
	 }
	 private boolean checkConditionsOfMariosGoingRight(){
		if (Main.scene.getxPesh() > 432 &&(!Main.scene.getMario().checkStandOnObject(Main.scene.getObjects()) || !Main.scene.getMario().isRight()))
			return true;
		return false;
	 }
	 private boolean checkConditionsOfMariosGoingLeft(){
	   if (Main.scene.getxChateau1() < 390 && (!Main.scene.getMario().checkStandOnObject(Main.scene.getObjects()) || Main.scene.getMario().isRight()))
		   return true;
		 return false;
	 }
	 private boolean checkConditionsOfMariosMoving() {
		 if (!Main.scene.checkWin() && !Main.scene.checkLose()) 
			 return true;
		 return false;
	 }
}
