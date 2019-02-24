package game;

import java.awt.Graphics;

public class Platform extends GameObject {

	float speed;

	Platform(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
		speed = 5;
	}

	void update() {
		super.update();
		y += speed;
		// speed+=.01;
	}

	void draw(Graphics g) {

		// g.setColor(Color.GRAY);
		// g.fillRect(x, y, width, height);
		switch (GamePanel.skinState) {
		case 1:
			g.drawImage(GamePanel.rightFacingStick, x, y, width, height, null);
		case 2:
			g.drawImage(GamePanel.leftFacingStick, x, y, width, height, null);
		}
		g.drawImage(GamePanel.rightFacingStick, x, y, width, height, null);

	}

}
