package game;

import java.awt.Graphics;

public class Background extends GameObject {
	double speed;

	Background(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
		speed = 3;
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
		
		switch(GamePanel.skinState) {
		case 0:
			g.drawImage(GamePanel.treeBackgroundImage, x, y, width, 2 * height, null);
		break;
		case 1:
			g.drawImage(GamePanel.smokeBackgroundImage, x, y, width, 2 * height, null);
		break;
		case 2:
			g.drawImage(GamePanel.kitchenBackgroundImage, x, y, width, 2 * height, null);
		break;
		case 3:
			g.drawImage(GamePanel.treeBackgroundImage, x, y, width, 2 * height, null);
		break;
		}
		
		// g.fillRect(x, y, width, 2 * height);
	}

}
