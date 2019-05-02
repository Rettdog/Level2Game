package game;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject {
	boolean collision;
	double speed;
	int type;

	Enemy(int xp, int yp, int widthp, int heightp, int typep) {
		super(xp, yp, widthp, heightp);
		type=typep;
		// TODO Auto-generated constructor stub
		collision = false;
		speed=3;
	}

	void update() {
		super.update();
		if (collision) {
			y += 20;
		} else {
			y += speed;
		}
	}

	void draw(Graphics g) {
		//g.setColor(Color.BLUE);

		// g.fillRect(x, y, width, height);
		//g.setColor(Color.YELLOW);
		//g.fillRect(x, y, width, height);
		switch(GamePanel.skinState) {
		case 0:
			g.drawImage(GamePanel.cookieMonsterImage, x, y, width, height, null);
			
		break;
		case 1:
			g.drawImage(GamePanel.fireImage, x, y, width, height, null);
		break;
		case 2:
			g.drawImage(GamePanel.knifeImage, x, y, width, height, null);
		break;
		case 3:
			if(type==0) {
				g.drawImage(GamePanel.dustSpiritImage, x, y, width, height, null);
			}else {
				g.drawImage(GamePanel.acornImage, x, y, width, height, null);
			}
		break;
		}
		
		

	}

	int getY() {
		return y;

	}
}
