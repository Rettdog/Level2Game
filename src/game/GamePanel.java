package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int menuState = 0;
	final int gameState = 1;
	final int endState = 2;
	final int cookieMonster = 0;
	public static int skinState;
	public static BufferedImage ninjoreoBasic;
	public static BufferedImage rightFacingStick;
	public static BufferedImage leftFacingStick;
	public static BufferedImage cookieMonsterImage;
	public static BufferedImage treeBackgroundImage;
	int currentState = menuState;
	Timer timer;
	GameObject object;

	Font titleFont;
	Font nontitle;
	Font subtitleFont;
	Oreo ninjoreo = new Oreo(200, 650, 50, 50);
	Background background = new Background(0, -1 * Ninjoreo.height, Ninjoreo.width, Ninjoreo.height);
	ObjectManager manager = new ObjectManager(ninjoreo, background);
	boolean jumping = false;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
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

		g.drawImage(treeBackgroundImage, 0, 0, Ninjoreo.width, 2 * Ninjoreo.height, null);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Ninjoreo", 100, 200);
		g.setFont(nontitle);
		g.drawString("Press enter to start", 120, 300);
		g.drawString("Press space for instructions", 75, 400);
		if (ninjoreo.y > 700) {
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
		g.setColor(Color.BLACK);
		g.setFont(nontitle);
		g.drawString("You totally wrecked " + manager.score / 2, 122, 302);
		g.setColor(Color.RED);
		g.drawString("You totally wrecked " + manager.score / 2, 120, 300);
		switch (skinState) {
		case 0:
			g.setColor(Color.BLACK);
			g.drawString("cookie monsters", 162, 352);
			g.setColor(Color.RED);
			g.drawString("cookie monsters", 160, 350);
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
		System.out.println("typed");
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
		System.out.println("pressed");
		System.out.println(e.getKeyCode());
		if (currentState == menuState) {

			if (e.getKeyCode() == 32) {
				JOptionPane.showMessageDialog(null,
						"Use the arrow keys to jump and move.\nJump on the enemies "
								+ "to make them fall but \nmake sure not to hit them from below"
								+ ".\nDon't fall too fast, or you will fall through \nthe logs and into the abyss");
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
		System.out.println("released");
		if (e.getKeyCode() == 37) {
			ninjoreo.xSpeed = 0;

		}
		if (e.getKeyCode() == 39) {
			ninjoreo.xSpeed = 0;

		}
	}

}
