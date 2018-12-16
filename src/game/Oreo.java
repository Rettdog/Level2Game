package game;

import java.awt.Color;
import java.awt.Graphics;

public class Oreo extends GameObject {
	float ySpeed;
	float xSpeed;
	boolean collided;
	int doublejump;

	Oreo(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
		ySpeed = 0;
		xSpeed = 0;
		doublejump = 2;
	}

	void update() {
		super.update();
		y += ySpeed;
		x += xSpeed;
		ySpeed += .7;
		if (y > Ninjoreo.height - height) {
			y = Ninjoreo.height - height;
			doublejump = 2;
		}
		if (collided && ySpeed >= 0) {
			doublejump = 2;
			ySpeed = -1;
		}

	}

	void setCollision(boolean cool) {
		collided = cool;

	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(x, y, width, height);

	}

	void jump() {
		if (doublejump > 0) {
			ySpeed = -17;
			doublejump -= 1;
		}
	}

}
