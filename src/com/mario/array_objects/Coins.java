package com.mario.array_objects;

import java.awt.Graphics;
import java.util.ArrayList;

import com.mario.array_objects.objects.Coin;
import com.mario.audio.Audio;
import com.mario.ru.Main;

public class Coins {
	private ArrayList<Coin> coins= new ArrayList<Coin>();
	private Coin coin1 = new Coin(434, 165); //402 145 
	private Coin coin2 = new Coin(1234, 160);
	private Coin coin3 = new Coin(1304, 115);
	private Coin coin4 = new Coin(1374, 60);
	private Coin coin5 = new Coin(1682, 165);
	private Coin coin6 = new Coin(2701, 166);
	private Coin coin7 = new Coin(3022, 155);
	private Coin coin8 = new Coin(3432, 145);
	private Coin coin9 = new Coin(4232, 165);
	private Coin coin10 = new Coin(4632, 80);
	public Coins() {
       addCoinsToArray();
	}
	
	private void addCoinsToArray(){
		coins.add(coin1);
		coins.add(coin2);
		coins.add(coin3);
		coins.add(coin4);
		coins.add(coin5);
		coins.add(coin6);
		coins.add(coin7);
		coins.add(coin8);
		coins.add(coin9);
		coins.add(coin10);
	}
	
	public void replace() {
		for (Coin o: coins) {
			o.setX(o.getX() - Main.scene.getDx());
		}
	}
	public void remove() {
		for (int i = 0; i < coins.size(); i++){
			if (Main.scene.getMario().contactCoin(coins.get(i))) {
				coins.remove(i);
				Main.scene.getScore().increaseCollectedCoins();
				addMusic();
			
			}
		}
	}
	public void drawCoins(Graphics g){
		for (int i = 0; i < coins.size(); i++){
			g.drawImage(coins.get(i).twinkle(), coins.get(i).getX(), coins.get(i).getY(), null);
		}
	}
	private void addMusic(){
		Audio.playSound("/mus/eat.wav");
	}
	}
