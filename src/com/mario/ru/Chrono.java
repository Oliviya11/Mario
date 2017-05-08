package com.mario.ru;

public class Chrono implements Runnable {
    
	private final int PAUSE = 3;
	public static boolean pause = false;

	@Override
	public void run() {
		
		while(true) {
			if(!pause) {
				Main.scene.repaint();
				Main.scene.getMario().hit(Main.scene.getObjects());
				Main.scene.getMario().stop(Main.scene.getObjects());
				Main.scene.getMario().stand(Main.scene.getObjects());
				Main.scene.getEnemie().stop(Main.scene.getObjects());
				Main.scene.getEnemie().goInOpposite();
				Main.scene.getMario().kill(Main.scene.getEnemie());
				}
			if (!Main.fenetre.isActive()) {pause = true;} 
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) { }
		}
		
	}
  
}
