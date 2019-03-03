package game;

import java.awt.Graphics;

public class Background extends GameObject {
	int speed;

	Background(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
		speed = 5;
	}

	void update() {
		super.update();
		y += speed;
		if (y >= 0) {
			y = -1 * Ninjoreo.height;
		}
	}

	void draw(Graphics g) {
		// g.setColor(Color.GREEN);
		g.drawImage(GamePanel.treeBackgroundImage, x, y, width, 2 * height, null);
		// g.fillRect(x, y, width, 2 * height);
	}

}
