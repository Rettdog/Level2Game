package game;

import java.awt.Color;
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

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		// object = new GameObject(10,10,100,100);
	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, Ninjoreo.width, Ninjoreo.height);    
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.GREEN);

		g.fillRect(0, 0, Ninjoreo.width, Ninjoreo.height);    
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, Ninjoreo.width, Ninjoreo.height);    
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
		// object.draw(g);
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
		// TODO Auto-generated method stub
		System.out.println("pressed");
		if (e.getKeyCode() == 10) {
			// System.out.println(e.getKeyCode());
			currentState++;

			if (currentState > endState) {

				currentState = menuState;

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("released");
	}

}
