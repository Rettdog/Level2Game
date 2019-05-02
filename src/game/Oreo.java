package game;

import java.awt.Graphics;

public class Oreo extends GameObject {
	float ySpeed;
	float xSpeed;
	boolean collided;
	int doublejump;
	double maxSpeed;

	Oreo(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
		ySpeed = 0;
		xSpeed = 0;
		doublejump = 2;
		maxSpeed = 15.4;
	}

	void update() {
		//System.out.println(ySpeed);
		super.update();
		y += ySpeed;
		x += xSpeed;
		ySpeed += .7;
		// maxSpeed+=.01;

		/*
		 * if (y > Ninjoreo.height - height) { y = Ninjoreo.height - height; doublejump
		 * = 2;
		 * 
		 * 
		 * }
		 */
		if (collided && ySpeed >= 0) {
			doublejump = 2;
			ySpeed = -1;
		}
		if (ySpeed >= maxSpeed) {
			ySpeed = (float) maxSpeed;
		}

	}

	void setCollision(boolean cool) {
		collided = cool;

	}

	void draw(Graphics g) {

		// g.setColor(Color.BLUE);

		// g.drawRect(x, y, width, height);
		switch(GamePanel.skinState) {
		case 0:
			g.drawImage(GamePanel.ninjoreoBasic, x, y, width, height, null);
			break;
		case 1:
			g.drawImage(GamePanel.marshMauler, x, y, width, height, null);
			break;
		case 2:
			g.drawImage(GamePanel.ninCheezitNormal, x, y, width, height, null);
			break;
		
		case 3:
		g.drawImage(GamePanel.totoroImage, x, y, width, height, null);
		break;
		}
	}
		
	

	void jump() {
		if (doublejump > 0) {
			ySpeed = -17;
			doublejump -= 1;
		}
	}

}
