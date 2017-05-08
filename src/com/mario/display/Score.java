package com.mario.display;



public class Score {
private final int availableCoins = 10;
private int collectedCoins = 0;
  public void increaseCollectedCoins(){
	  collectedCoins++;
  }
public int getCollectedCoins() {
	return collectedCoins;
}
public int getAvailableCoins() {
	return availableCoins;
}
  
}
