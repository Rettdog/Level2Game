package game;

import java.awt.Color;
import java.awt.Graphics;

public class Oreo extends GameObject{
float ySpeed;
float xSpeed;

	Oreo(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
		ySpeed = 0;
		xSpeed=0;
	}
	void update() {
		super.update();
		y+=ySpeed;
		x+=xSpeed;
		ySpeed+=.7;
		if(y>Ninjoreo.height-height) {
			y=Ninjoreo.height-height;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);

        g.fillRect(x, y, width, height);
        

	}
    void jump() {
    	
    	ySpeed=-20;
    	
    	
    }
		
	

}
