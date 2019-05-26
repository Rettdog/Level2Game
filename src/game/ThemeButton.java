package game;

//import java.awt.Color;
import java.awt.Graphics;

public class ThemeButton extends GameObject{

	ThemeButton(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
	}
	
	boolean checkClicked(int x, int y) {
		//System.out.println("x = "+x);
		//System.out.println("y = "+y);
		//System.out.println("X range = "+this.x+" to "+(this.x+width));
		//System.out.println("Y range = "+this.y+" to "+(this.y+height));
		if(this.x <= x && x<= this.x+width) {
			if(this.y <= y && y<= this.y+height) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	
	
	void update() {
		
	}

	void draw(Graphics g) {
		//g.setColor(Color.BLUE);
		//g.fillRect(x, y-25, width, height);
		g.drawImage(GamePanel.themeButtonImage, x, y-25, width, height, null);
		
			
	}
	
}
