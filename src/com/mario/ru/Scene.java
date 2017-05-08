package com.mario.ru;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.mario.array_objects.Enemies;
import com.mario.array_objects.Coins;
import com.mario.array_objects.Objects;
import com.mario.audio.Audio;
import com.mario.display.Countdown;
import com.mario.display.Score;
import com.mario.personage.Mario;
@SuppressWarnings("serial")
public class Scene extends JPanel{

	private Mario mario;
	public Thread chronoEcran = new Thread(new Chrono());;
	private Audio a = new Audio("/mus/win.wav");

	private Coins coins = new Coins();
	
	private Objects objects = new Objects();
	private Enemies enemies = new Enemies();
	private ImageIcon icoFond = new ImageIcon(getClass().getResource("/images/background2.png"));
	private Image imgFond1 = icoFond.getImage();;
    private Image imgFond2 = icoFond.getImage();;		
	private ImageIcon icoChateau1;
	private Image imgChateau1;
	private ImageIcon icoDepart;
	private Image imgDepart;
    private boolean jump = false;
	private ImageIcon icoBash;
	private Image bash;
	private ImageIcon icoPesh;
	private Image pesh;
	private int xFond1;
 	private int xFond2;
	private int xChateau1;
	private int xDepart;
	private int xPesh = 5420;
	private int dx ;
	private int xBash = 5020;
    private Score score = new Score();
    private Font myFont = new Font("Aharoni", Font.BOLD,18);
    private Countdown countdown = new Countdown();
    private int location = 0;
    private ImageIcon prinsIco = new ImageIcon(getClass().getResource("/images/prins.png"));
    private Image prinsImage = prinsIco.getImage();
    
	
	public Scene() {

		xFond1 = -10;
		xChateau1 = 25;
		xDepart = 220;
		xFond2 = 1574;
		dx = 0;
		icoChateau1 = new ImageIcon(getClass().getResource("/images/castle.png"));
		imgChateau1 = icoChateau1.getImage();
		icoDepart = new ImageIcon(getClass().getResource("/images/table2.png"));
		imgDepart = icoDepart.getImage();
		icoBash = new ImageIcon(getClass().getResource("/images/bash.png"));
		bash = icoBash.getImage();
		icoPesh = new ImageIcon(getClass().getResource("/images/pesh.png"));
		pesh = icoPesh.getImage();
		mario = new Mario(352, 265);
		setFocusable(true);
		requestFocusInWindow();
	   this.addKeyListener(new Controller());
	//	chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
		
		
	}
	
	//*****Getters*****
	public int getDx() {return dx;}
	
	//*****Setters*****
	
	public Mario getMario() {
		return mario;
	}

	public void setMario(Mario mario) {
		this.mario = mario;
	}

	public void setDx(int dx) {
		this.dx = dx;
		}
	
	
	//*****Methods*****

	
	public void deplacementFond() {
      if (dx!=0){
		xFond1 = xFond1 - dx;
		xFond2 = xFond2 - dx;
		
		if(xFond1 == -1584)xFond1 = 1583;
		else if (xFond2 == -1584)xFond2 = 1584;
		else if(xFond1 == 1583)xFond1 = -1584;
		else if (xFond2 == 1584)xFond2 = -1584;	
		
		xChateau1 = xChateau1 - dx;
		xDepart = xDepart - dx;
		xBash = xBash - dx;
		xPesh = xPesh - dx;
		location = location - dx;
	        enemies.replace();
			coins.replace();
			objects.replace();
      }

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		deplacementFond();
		//Graphics g2 = (Graphics2D)g;
		g.drawImage(imgFond1, xFond1, 0, null);
		g.drawImage(imgFond2, xFond2, 0, null);
		g.drawImage(imgChateau1,xChateau1 , 56 , null);
		g.drawImage(imgDepart, xDepart, 253, null);
		g.drawImage(bash, xBash, 232, null);
		g.drawImage(pesh, xPesh, 210, null);
		coins.drawCoins(g);
		coins.remove();
		objects.drawObjects(g);
		enemies.drawChamps(g);
		
		Font myFont2 = new Font("Aharoni", Font.BOLD,50);
		g.setFont(myFont2);
		if (checkWin()) {
			g.drawImage(prinsImage, mario.getX()+25, mario.getY()-3, null);
			g.drawString("You win! ^_^", 230, 180);
			myFont2 = new Font("Aharoni", Font.BOLD,20);
			g.setFont(myFont);
			g.drawString("Press \"Enter\" to start new game ", 220, 200);
			a.play();
		
		}
		
		if (checkLose()){
			g.drawString("You lose...", 230, 180);
			myFont2 = new Font("Aharoni", Font.BOLD,20);
			g.setFont(myFont);
			g.drawString("Press \"Enter\" to start new game ", 220, 200);
		}
		if (Chrono.pause){
			g.fillRect(330, 140, 10, 40);
			g.fillRect(360, 140, 10, 40);
		}
		if (mario.isAlive()){
		if (!jump) {
           if (!mario.leyInObject(objects)&& mario.getY()<265) 
        	   g.drawImage(mario.downToEarth(), mario.getX(), mario.getY(), null);
           else g.drawImage(mario.go("manMario", 35), mario.getX(), mario.getY(), null);
		}
		else  {
			if (mario.getJumpCounter() > 0 && mario.getEarthLevel() < 265 && !mario.leyInObject(objects)){       //&& mario.getY() < mario.getEarthLevel()){
				//setPar();
				g.drawImage(mario.downToEarth(), mario.getX(), mario.getY(), null);
				
				mario.setJumpCounter(0);
				mario.setBreakJump(true);
				jump = false;
			}
			else g.drawImage(mario.jump(), mario.getX(), mario.getY(), null);
			
		} 
	}
		else {
			g.drawImage(mario.die(), mario.getX(), mario.getY()-10, null);
		}
		g.setFont(myFont);
		g.drawString("Coins have been collected: "+score.getCollectedCoins()+" from: "+score.getAvailableCoins(), 380, 18);
		g.drawString(countdown.getStr(), 7, 18);
		
	}
	/*
	private void setPar() {
	
    	mario.setEarthLevel(265);
		mario.setMAX(265-mario.getJumpHeight());
		mario.setY(265);
    }
    */
	public void setJump(boolean jump) {
		this.jump = jump;
	}
	public boolean checkWin(){
		if (countdown.getTimeCounter()>0 && score.getCollectedCoins() == 10 && mario.isAlive() && xPesh < 432)
			return true;
			
		return false;
	}
	public boolean checkLose(){
		if (countdown.getTimeCounter()<0 || !mario.isAlive())
			return true;
		return false;
	}

	public int getLocation2() {
		return location;
	}

	public int getxChateau1() {
		return xChateau1;
	}

	public int getxPesh() {
		return xPesh;
	}

	public boolean isJump() {
		return jump;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
	public void removeCoin(){
		coins.remove();
	}

	public Objects getObjects() {
		return objects;
	}

	public void setObjects(Objects objects) {
		this.objects = objects;
	}

	public Enemies getEnemie() {
		return enemies;
	}

	public Coins getCoins() {
		return coins;
	}
	
}
