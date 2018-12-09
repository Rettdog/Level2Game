package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int menuState = 0;
	final int gameState = 1;
	final int endState = 2;
	int currentState = menuState;
	Timer timer;
	GameObject object;
	Font titleFont;
	Font nontitle;
	Oreo ninjoreo = new Oreo(250,350,50,50);
	ObjectManager manager = new ObjectManager(ninjoreo);
	boolean jumping=false;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		// object = new GameObject(10,10,100,100);
		titleFont = new Font("Arial", Font.PLAIN, 80);
		nontitle = new Font("Arial", Font.PLAIN, 28);
	}

	void updateMenuState() {

	}

	void updateGameState() {
ninjoreo.update();
manager.update();
manager.manageEnemies();

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, Ninjoreo.width, Ninjoreo.height);    
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Ninjoreo",100,200);
		g.setFont(nontitle);
		g.drawString("Press enter to start",120,300);
		g.drawString("Press space for instructions",75,400);
		
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.GREEN);

		g.fillRect(0, 0, Ninjoreo.width, Ninjoreo.height);  
		ninjoreo.draw(g);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, Ninjoreo.width, Ninjoreo.height);    
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over",50,200);
		g.setFont(nontitle);
		g.drawString("You fatally injured "+0,120,300);
		g.drawString("fatally injurers",160,350);
		
	}

	void startGame() {
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// object.update();
		repaint();
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
		if (e.getKeyCode() == 10) {
			// System.out.println(e.getKeyCode());
			currentState++;

			if (currentState > endState) {

				currentState = menuState;

			}
		}
	if(e.getKeyCode()==38) {
		ninjoreo.jump();
		
	}

	if(e.getKeyCode()==37) {
		ninjoreo.xSpeed=-5;
		
	}
	if(e.getKeyCode()==39) {
		ninjoreo.xSpeed=5;
		
	}
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("released");
		if(e.getKeyCode()==37) {
			ninjoreo.xSpeed=0;
			
		}
		if(e.getKeyCode()==39) {
			ninjoreo.xSpeed=0;
			
		}
	}

}
