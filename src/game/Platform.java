package game;

import java.awt.Color;
import java.awt.Graphics;

public class Platform extends GameObject {

	Platform(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		y += 5;
	}

	void draw(Graphics g) {

	//	g.setColor(Color.GRAY);
		//g.fillRect(x, y, width, height);
		g.drawImage(GamePanel.stick, x, y, width, height, null);

	}

}
