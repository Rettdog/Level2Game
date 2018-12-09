package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Long logTimer = (long) 0;
	int logSpawnTime = 1000;
	ArrayList<Platform> list = new ArrayList<Platform>();
	//ArrayList<Alien> aliens = new ArrayList<Alien>();
	Oreo oreo;
	int score;
	void checkCollision(){
		

	
	}
	ObjectManager(Oreo oreo){
		this.oreo = oreo;
	}
	void addPlatform(Platform form) {
		list.add(form);

	}
	public void manageEnemies() {
		if (System.currentTimeMillis() - logTimer >= logSpawnTime) {
			addPlatform(new Platform(new Random().nextInt(Ninjoreo.width - 20), 0, 50, 50));
System.out.println("add");
			logTimer = System.currentTimeMillis();
		}
	}
	void draw(Graphics g) {
		oreo.draw(g);
		// System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).draw(g);

		}
		
	}
	public void update() {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			list.get(i).update();

		}
	}

}
