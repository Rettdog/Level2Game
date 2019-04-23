package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {

	final int menuState = 0;
	final int gameState = 1;
	final int endState = 2;
	final int cookieMonster = 0;
	final int marshMaulerSkin = 1;
	final int ninCheezitSkin = 2;
	public static int skinState;
	public static BufferedImage ninjoreoBasic;
	public static BufferedImage rightFacingStick;
	public static BufferedImage leftFacingStick;
	public static BufferedImage cookieMonsterImage;
	public static BufferedImage marshMauler;
	public static BufferedImage treeBackgroundImage;
	public static BufferedImage fireImage;
	public static BufferedImage smokeBackgroundImage;
	public static BufferedImage themeButtonImage;
	public static BufferedImage ninCheezitClosed;
	public static BufferedImage ninCheezitLargeSquint;
	public static BufferedImage ninCheezitNormal;
	public static BufferedImage ninCheezitSquint;
	public static BufferedImage ninCheezitTongue;
	public static BufferedImage knifeImage;
	public static BufferedImage plateImage;
	public static BufferedImage kitchenBackgroundImage;
	int currentState = menuState;
	Timer timer;
	GameObject object;
	ThemeButton button;
	Font titleFont;
	Font nontitle;
	Font subtitleFont;
	Oreo ninjoreo = new Oreo(200, 650, 50, 50);
	Background background = new Background(0, -1 * Ninjoreo.height, Ninjoreo.width, Ninjoreo.height);
	ObjectManager manager = new ObjectManager(ninjoreo, background);
	boolean jumping = false;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		button = new ThemeButton(325,650,100,100);
		//button.addActionListener(this);
		//skinState = cookieMonster;
		skinState = cookieMonster;
		// object = new GameObject(10,10,100,100);
		titleFont = new Font("Arial", Font.PLAIN, 80);
		nontitle = new Font("Arial", Font.PLAIN, 28);
		subtitleFont = new Font("Arial", Font.PLAIN, 40);
		try {
			ninjoreoBasic = ImageIO.read(this.getClass().getResourceAsStream("NinjoreoBasic.png"));
			rightFacingStick = ImageIO.read(this.getClass().getResourceAsStream("RightFacingStick.png"));
			leftFacingStick = ImageIO.read(this.getClass().getResourceAsStream("LeftFacingStick.png"));
			cookieMonsterImage = ImageIO.read(this.getClass().getResourceAsStream("CookieMonster.png"));
			treeBackgroundImage = ImageIO.read(this.getClass().getResourceAsStream("Background.png"));
			marshMauler =ImageIO.read(this.getClass().getResourceAsStream("MarshMauler.png"));
			fireImage =ImageIO.read(this.getClass().getResourceAsStream("Fire.png"));
			themeButtonImage=ImageIO.read(this.getClass().getResourceAsStream("button.png"));
			smokeBackgroundImage = ImageIO.read(this.getClass().getResourceAsStream("SmokeBackground.png"));
			knifeImage = ImageIO.read(this.getClass().getResourceAsStream("Knife.png"));
			ninCheezitClosed = ImageIO.read(this.getClass().getResourceAsStream("NinCheezit/NinCheezitClosed.png"));
			ninCheezitLargeSquint = ImageIO.read(this.getClass().getResourceAsStream("NinCheezit/NinCheezitLargeSquint.png"));
			ninCheezitNormal = ImageIO.read(this.getClass().getResourceAsStream("NinCheezit/NinCheezitNormal.png"));
			ninCheezitSquint = ImageIO.read(this.getClass().getResourceAsStream("NinCheezit/NinCheezitSquint.png"));
			ninCheezitTongue = ImageIO.read(this.getClass().getResourceAsStream("NinCheezit/NinCheezitTongue.png"));
			plateImage = ImageIO.read(this.getClass().getResourceAsStream("Plate.png"));
			kitchenBackgroundImage = ImageIO.read(this.getClass().getResourceAsStream("Kitchen.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void updateMenuState() {
		// currentState = menuState;
		ninjoreo.update();

	}

	void updateGameState() {
		// currentState = gameState;
		ninjoreo.update();
		manager.update();
		manager.manageEnemies();
		manager.lose();

	}

	void updateEndState() {
		// currentState = endState;
		background.update();
	}

	void drawMenuState(Graphics g) {
		
		g.setColor(Color.BLUE);
background.draw(g);

		
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		switch(skinState) {
		case 0:
			g.drawString("Ninjoreo", 100, 200);
		break;
		case 1:
			g.drawString("Marsh", 100, 180);
			g.drawString("Mauler", 100, 250);
		break;
		case 2:
			g.drawString("NinCheezit", 60, 200);
		break;
		
		}
		
		g.setFont(nontitle);
		g.drawString("Press enter to start", 120, 300);
		g.drawString("Press space for instructions", 75, 400);
		ninjoreo.doublejump=5;
		
		if (ninjoreo.y > 700) {
			ninjoreo.doublejump=5;
			ninjoreo.jump();
		}
		
		if (ninjoreo.x < 0) {
			ninjoreo.x = 0;
		}
		if (ninjoreo.x > Ninjoreo.width - 50) {
			ninjoreo.x = Ninjoreo.width - 50;
		}
		if (ninjoreo.y < 1) {
			ninjoreo.ySpeed = 20;
		}
		ninjoreo.draw(g);
		button.draw(g);
	}

	void drawGameState(Graphics g) {
		// g.setColor(Color.GREEN);

		// g.fillRect(0, 0, Ninjoreo.width, Ninjoreo.height);
		ninjoreo.draw(g);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		background.speed = 1;
		background.draw(g);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 53, 203);
		g.setColor(Color.RED);
		g.setFont(titleFont);
		g.drawString("Game Over", 50, 200);
		
		switch (skinState) {
		case 0:
			g.setColor(Color.BLACK);
			g.setFont(nontitle);
			g.drawString("You totally wrecked " + manager.score / 2, 122, 302);
			g.setColor(Color.RED);
			g.drawString("You totally wrecked " + manager.score / 2, 120, 300);
			g.setColor(Color.BLACK);
			g.drawString("cookie monsters", 162, 352);
			g.setColor(Color.RED);
			g.drawString("cookie monsters", 160, 350);
		break;
		case 1:
			g.setColor(Color.BLACK);
			g.setFont(nontitle);
			g.drawString("You absorbed " + manager.score / 2, 122, 302);
			g.setColor(Color.RED);
			g.drawString("You absorbed " + manager.score / 2, 120, 300);
			g.setColor(Color.BLACK);
			g.drawString("fireballs", 162, 352);
			g.setColor(Color.RED);
			g.drawString("fireballs", 160, 350);
		break;
		case 2:
			g.setColor(Color.BLACK);
			g.setFont(nontitle);
			g.drawString("You destroyed " + manager.score / 2, 122, 302);
			g.setColor(Color.RED);
			g.drawString("You destroyed " + manager.score / 2, 120, 300);
			g.setColor(Color.BLACK);
			g.drawString("knives", 194, 352);
			g.setColor(Color.RED);
			g.drawString("knives", 192, 350);
		break;
		}
		// g.drawString("fatally injurers", 160, 350);
		g.setColor(Color.BLACK);
		g.setFont(subtitleFont);
		g.drawString("Press enter to proceed", 52, 452);
		g.setColor(Color.RED);
		g.drawString("Press enter to proceed", 50, 450);

	}

	void startGame() {
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// object.update();
		repaint();
		if (ninjoreo.lose) {
			ninjoreo.lose = false;
			currentState = endState;
		}
		if (currentState == menuState) { 
			updateMenuState();
		} else if (currentState == gameState) {
			updateGameState();
		} else if (currentState == endState) {
			updateEndState();
		}

	}

	@Override

	public void paintComponent(Graphics g) {
		ninjoreo.draw(g);
		if (currentState == menuState) {
			drawMenuState(g);
		} else if (currentState == gameState) {
			drawGameState(g);
		} else if (currentState == endState) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == 39) {

			// System.out.println("hello");
		}
		if (e.getKeyCode() == 37) {

		}
		if (e.getKeyCode() == 40) {

		}
		if (e.getKeyCode() == 38) {

		}

		// TODO Auto-generated method stub
		//System.out.println("pressed");
		//System.out.println(e.getKeyCode());
		if (currentState == menuState) {

			if (e.getKeyCode() == 32) {
				switch(skinState) {
				case 0:
					JOptionPane.showMessageDialog(null,
							"Use the side arrows to move side to side and the up arrow to jump.\nJump on the cookie monsters "
									+ "to make them fall but \nmake sure not to hit them from below"
									+ ".\nDon't fall too fast, or you will fall through \nthe logs and into the abyss"
									+ "\nYou can test out the controls on this screen.");
				break;
				case 1:
					JOptionPane.showMessageDialog(null,
							"Use the side arrows to move side to side and the up arrow to jump.\nJump on the fireballs "
									+ "to make them fall but \nmake sure not to hit them from below or you will melt into the fire"
									+ ".\nDon't fall too fast, or you will fall through \nthe logs and into the fire below"
									+ "\nYou can test out the controls on this screen.");
				break;
				case 2:
					JOptionPane.showMessageDialog(null,
							"Use the side arrows to move side to side and the up arrow to jump.\nJump on the knife "
									+ "to make them fall but \nmake sure not to hit them from below or you will cut into crumbs"
									+ ".\nDon't fall too fast, or you will fall through \nthe plates and onto the floor below"
									+ "\nYou can test out the controls on this screen.");
				break;
				}
				
			}
		}
		if (e.getKeyCode() == 10) {
			if (currentState == menuState) {
				System.out.println("enter");
				ninjoreo.doublejump = 3;
				ninjoreo.jump();

			}

			currentState++;

			if (currentState > endState) {

				currentState = menuState;

			}

			if (currentState == menuState) {
				background = new Background(0, -1 * Ninjoreo.height, Ninjoreo.width, Ninjoreo.height);
				ninjoreo = new Oreo(200, 650, 50, 50);
				manager = new ObjectManager(ninjoreo, background);
			}

		}
		if (e.getKeyCode() == 38) {
			ninjoreo.jump();

		}

		if (e.getKeyCode() == 37) {
			ninjoreo.xSpeed = -5;

		}
		if (e.getKeyCode() == 39) {
			ninjoreo.xSpeed = 5;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("released");
		if (e.getKeyCode() == 37) {
			ninjoreo.xSpeed = 0;

		}
		if (e.getKeyCode() == 39) {
			ninjoreo.xSpeed = 0;

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("clicked");
		if(button.checkClicked(e.getX(), e.getY())) {
			skinState++;
			System.out.println("upper");
			if(skinState>2) {
				skinState=0;
			}
			if(skinState==marshMaulerSkin) {
				skinState=marshMaulerSkin;
			}
			if(skinState==ninCheezitSkin) {
				skinState=ninCheezitSkin;
			}
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
