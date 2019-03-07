package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Long logTimer = (long) 0;
	Long enemyTimer = (long) 0;
	int enemySpawnTime = 1440;
	int logSpawnTime = 749;
	double allSpeed=3.00;
	int speedCounter = 0;
	ArrayList<Platform> list = new ArrayList<Platform>();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	Background ground = new Background(0, 100, Ninjoreo.width, Ninjoreo.height);
	Oreo oreo;
	int score;
	
	ObjectManager(Oreo oreo, Background ground) {
		this.oreo = oreo;
		this.ground = ground;
		//speedIncreaseRate=2/10;
		
	}

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
					// oreo.lose = true;
					oreo.ySpeed = (float)(5+oreo.maxSpeed);
					
					// return true;

				}
			}

		}
		// top
		for (Enemy a : enemies) {

			if ((a.y <= oreo.y + oreo.height) && (a.y + a.height / 2 >= oreo.y + oreo.height)) {

				if ((a.x <= oreo.x + oreo.width) && (a.x + a.width >= oreo.x)) {
					a.collision = true;
					score++;
					speedCounter++;
					if(speedCounter>10) {
					allSpeed+=1;
					System.out.println("Speed increased to "+allSpeed);
					System.out.println("Platform speed = "+(list.get(1).speed+1));
					System.out.println("Enemy speed = "+(enemies.get(0).speed+1));
					System.out.println("MaxSpeed = "+(oreo.maxSpeed+.1));
					System.out.println("Background Speed = "+(ground.speed+1));
					System.out.println(" ");
					speedCounter=0;
					}
					return true;

				}
			}

		}
		return false;
	}

	

	void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}

	void addPlatform(Platform form) {
		list.add(form);

	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - logTimer >= logSpawnTime) {
			addPlatform(new Platform(new Random().nextInt(Ninjoreo.width) - 100, -25, 200, 25));
			//System.out.println("Speed increased to "+allSpeed);
			//System.out.println("Platform speed = "+list.get(0).speed);
			
			logTimer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addEnemy(new Enemy(new Random().nextInt(Ninjoreo.width - 20), -50, 50, 50));
			//System.out.println("add");
			//System.out.println("Enemy speed = "+enemies.get(0).speed);
			//System.out.println("MaxSpeed = "+oreo.maxSpeed);
			//System.out.println(" ");
			enemyTimer = System.currentTimeMillis();
		}
	}

	void draw(Graphics g) {
		ground.draw(g);
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
		for (Platform platy : list) {
			platy.speed = allSpeed;
		}
		for (Enemy enemy : enemies) {
			enemy.speed = allSpeed;
		}
		oreo.maxSpeed = 12.4 +allSpeed;
		ground.speed=allSpeed;
		for (int i = 0; i < list.size(); i++) {
			list.get(i).update();

		}
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();

		}
		oreo.setCollision(checkCollision());
		ground.update();
		
	}

	public void lose() {
		if (Ninjoreo.height <= oreo.y + oreo.height) {
			System.out.println("lose");
			oreo.lose = true;
		}
	}

}
