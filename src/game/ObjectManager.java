package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Long logTimer = (long) 0;
	Long enemyTimer = (long) 0;
	int enemySpawnTime = 1500;
	int logSpawnTime = 750;
	ArrayList<Platform> list = new ArrayList<Platform>();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	Oreo oreo;
	int score;

	public boolean checkCollision() {
		for (Platform a : list) {

			if ((a.y <= oreo.y + oreo.height) && (a.y + a.height / 2 >= oreo.y + oreo.height)) {

				if ((a.x <= oreo.x + oreo.width) && (a.x + a.width >= oreo.x)) {

					return true;

				}
			}

		}
		// bottom
		for (Enemy a : enemies) {

			if ((oreo.y < a.y + a.height) && (oreo.y > a.y + a.height / 2)) {

				if ((a.x <= oreo.x + oreo.width) && (a.x + a.width >= oreo.x)) {
					oreo.lose = true;
					return true;

				}
			}

		}
		// top
		for (Enemy a : enemies) {

			if ((a.y <= oreo.y + oreo.height) && (a.y + a.height / 2 >= oreo.y + oreo.height)) {

				if ((a.x <= oreo.x + oreo.width) && (a.x + a.width >= oreo.x)) {
					a.collision = true;
					score++;
					return true;

				}
			}

		}
		return false;
	}

	ObjectManager(Oreo oreo) {
		this.oreo = oreo;
	}

	void addEnemy(Enemy enemy) {
		enemies.add(enemy);
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
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addEnemy(new Enemy(new Random().nextInt(Ninjoreo.width - 20), 0, 50, 50));
			System.out.println("add");
			enemyTimer = System.currentTimeMillis();
		}
	}

	void draw(Graphics g) {
		oreo.draw(g);
		// System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).draw(g);

		}
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);

		}

	}

	void purgeObjects() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).y > Ninjoreo.height) {
				list.remove(i);
			}
		}
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).y > Ninjoreo.height) {
				enemies.remove(i);
			}
		}

	}

	public void update() {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			list.get(i).update();

		}
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();

		}
		oreo.setCollision(checkCollision());
	}

	public void lose() {
		if (Ninjoreo.height <= oreo.y + oreo.height) {
			System.out.println("lose");
			oreo.lose = true;
		}
	}

}
