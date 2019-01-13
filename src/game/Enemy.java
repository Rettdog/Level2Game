package game;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject {
	boolean collision;

	Enemy(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
		collision = false;

	}

	void update() {
		super.update();
		if (collision) {
			y += 20;
		} else {
			y += 5;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);

		// g.fillRect(x, y, width, height);
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);

	}

	int getY() {
		return y;

	}
}
