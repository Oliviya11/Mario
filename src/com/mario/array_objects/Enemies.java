package com.mario.array_objects;

import java.awt.Graphics;
import java.util.ArrayList;

import com.mario.array_objects.objects.MyObject;
import com.mario.array_objects.objects.Truba;
import com.mario.personage.Champ;
import com.mario.personage.EnemyPersonnage;
import com.mario.personage.Tortue;
import com.mario.ru.Main;

public class Enemies {
	private ArrayList<EnemyPersonnage> enemies = new ArrayList<EnemyPersonnage>();
	private Champ champ1 = new Champ(615, 264);
	private Champ champ2 = new Champ(1100, 264);
	private Champ champ3 = new Champ(1500, 264);
	private Champ champ4 = new Champ(1800, 264);
	private Champ champ5 = new Champ(2400, 264);
	private Champ champ6 = new Champ(2200, 264);
	private Champ champ7 = new Champ(3515, 264);
	private Champ champ8 = new Champ(2600, 264);
	private Champ champ9 = new Champ(3100, 264);
	
	private Tortue tort1 = new Tortue(815, 265);
	private Tortue tort2 = new Tortue(1250, 265);
	private Tortue tort3 = new Tortue(1935, 265);
	private Tortue tort4 = new Tortue(3400, 265);
	private Tortue tort5 = new Tortue(4400, 265);
	private Tortue tort6 = new Tortue(3735, 265);
	private Tortue tort7 = new Tortue(4035, 265);
	private Tortue tort8 = new Tortue(2800, 265);
	
	public Enemies(){
		add();
	}
	
	private void add(){
		enemies.add(champ1);
		enemies.add(champ2);
		enemies.add(champ3);
		enemies.add(champ4);
		enemies.add(champ5);
		enemies.add(champ6);
		enemies.add(champ7);
		enemies.add(champ8);
		enemies.add(champ9);
		enemies.add(tort1);
		enemies.add(tort2);
		enemies.add(tort3);
		enemies.add(tort4);
		enemies.add(tort5);
		enemies.add(tort6);
		enemies.add(tort7);
		enemies.add(tort8);
	}
	public void replace(){
		for (EnemyPersonnage p: enemies){
	  		p.setX(p.getX() - Main.scene.getDx());
	  		}
	}
	public void drawChamps(Graphics g) {
		for (EnemyPersonnage p: enemies){
		if (p instanceof Champ){
			if (p.isAlive())g.drawImage(p.go("champ", 25), p.getX(), p.getY(), null);
			else g.drawImage(p.getImg(), p.getX(), p.getY(), null);
			}
		else {
			if (p.isAlive())g.drawImage(p.go("tort", 25), p.getX(), p.getY(), null);
			else g.drawImage(p.getImg(), p.getX(), p.getY()+5, null);
		}
		}
	}
	
	public void stop(Objects obj) {
		ArrayList<MyObject> objects = obj.getObjects();
		for (MyObject o: objects){
			
			for (EnemyPersonnage p: enemies){
			if (o instanceof Truba && p.contactAvant(o)) 
				p.setIsRight();		
			}
			
		}
		
	}

	public ArrayList<EnemyPersonnage> getEnemies() {
		return enemies;
	}

	public void setEnemyPersonnage(ArrayList<EnemyPersonnage> enemies) {
		this.enemies = enemies;
	}
	
	public void goInOpposite(){
		for (int i = 0; i<enemies.size(); i++){
			for (int j = 0; j<enemies.size(); j++){
			if (i!=j && enemies.get(i).isAlive() && enemies.get(j).isAlive()){
			if (enemies.get(i).contactAvantEnemy(enemies.get(j))) {
				enemies.get(i).setIsRight();
				enemies.get(j).setIsRight();
				}	
			}
			}
			}
	}
	
}
