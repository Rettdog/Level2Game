package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Long logTimer = (long) 0;
	int logSpawnTime = 750;
	ArrayList<Platform> list = new ArrayList<Platform>();
	
	Oreo oreo;
	int score;

	public boolean checkCollision() {
		for (Platform a : list) {

			if ((a.y <= oreo.y + oreo.height) && (a.y + 25 >= oreo.y + oreo.height)) {

				if ((a.x <= oreo.x + oreo.width) && (a.x + a.width >= oreo.x)) {

					return true;

				}
			}

		}
		return false;
	}

	ObjectManager(Oreo oreo) {
		this.oreo = oreo;
	}

	void addPlatform(Platform form) {
		list.add(form);

	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - logTimer >= logSpawnTime) {
			addPlatform(new Platform(new Random().nextInt(Ninjoreo.width - 20), 0, 200, 25));
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
		oreo.setCollision(checkCollision());
	}

	public void lose() {
		if (Ninjoreo.height<=oreo.y + oreo.height) {
			System.out.println("lose");
			oreo.lose = true;
		}
	}

}
