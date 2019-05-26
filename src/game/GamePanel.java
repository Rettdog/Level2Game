package game;

import java.applet.AudioClip;
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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {

	final int menuState = 0;
	final int gameState = 1;
	final int endState = 2;
	final static int cookieMonster = 0;
	final static int marshMaulerSkin = 1;
	final static int ninCheezitSkin = 2;
	final static int totoroSkin = 3;
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
	public static BufferedImage totoroImage;
	public static BufferedImage dustSpiritImage;
	public static BufferedImage acornImage;
	public int currentState = menuState;
	Timer timer;
	GameObject object;
	ThemeButton button;
	MusicPlayer musicPlayer;
	Font titleFont;
	Font nontitle;
	Font subtitleFont;
	Oreo ninjoreo = new Oreo(200, 650, 50, 50);
	Background background = new Background(0, -1 * Ninjoreo.height, Ninjoreo.width, Ninjoreo.height);
	ObjectManager manager;
	boolean jumping = false;

	GamePanel() {
		musicPlayer=new MusicPlayer();
		musicPlayer.playTitleSong();
		timer = new Timer(1000 / 60, this);
		button = new ThemeButton(325,650,100,100);
		
		manager = new ObjectManager(ninjoreo, background, musicPlayer);
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
			totoroImage =ImageIO.read(this.getClass().getResourceAsStream("totoro.png"));
			dustSpiritImage = ImageIO.read(this.getClass().getResourceAsStream("dustSpirit.png"));
			acornImage= ImageIO.read(this.getClass().getResourceAsStream("Acorn.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void updateMenuState() {
		// currentState = menuState;
		ninjoreo.update();
		musicPlayer.playMusic(currentState);

	}

	void updateGameState() {
		// currentState = gameState;
		ninjoreo.update();
		manager.update();
		manager.manageEnemies();
		manager.lose();
		musicPlayer.playMusic(currentState);
		

	}

	void updateEndState() {
		// currentState = endState;
		background.update();
		musicPlayer.playMusic(currentState);
	}

	void drawMenuState(Graphics g) {
		
		g.setColor(Color.BLUE);
background.draw(g);

		
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		switch(skinState) {
		case 0:
			g.setColor(Color.LIGHT_GRAY);
			g.drawString("Ninjoreo", 100, 200);
		break;
		case 1:
			g.drawString("Marsh", 130, 170);
			g.drawString("Mauler", 120, 250);
		break;
		case 2:
			g.drawString("NinCheezit", 55, 200);
		break;
		case 3:
			g.setColor(Color.CYAN);
			g.drawString("ToToRo!", 80, 200);
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
		Random rand = new Random();
		if(manager.score+manager.secondScore==0) {
			g.setColor(Color.BLACK);
			g.setFont(titleFont);
			g.drawString("Nice Try", 103, 203);
			g.setColor(Color.RED);
			g.setFont(titleFont);
			g.drawString("Nice Try", 100, 200);
		}else if(manager.score+manager.secondScore<8) {
			g.setColor(Color.BLACK);
			g.setFont(titleFont);
			g.drawString("Keep it Up", 66, 203);
			g.setColor(Color.RED);
			g.setFont(titleFont);
			g.drawString("Keep it Up", 63, 200);
		}else if(manager.score+manager.secondScore<18) {
			g.setColor(Color.BLACK);
			g.setFont(titleFont);
			g.drawString("Nice Job!", 83, 203);
			g.setColor(Color.RED);
			g.setFont(titleFont);
			g.drawString("Nice Job!", 80, 200);
		}else if(manager.score+manager.secondScore<40) {
			g.setColor(Color.BLACK);
			g.setFont(titleFont);
			g.drawString("Insane!", 127, 203);
			g.setColor(Color.RED);
			g.setFont(titleFont);
			g.drawString("Insane!", 123, 200);
		}else if(manager.score+manager.secondScore>39) {
			switch(skinState) {
			case 0:
				g.setColor(Color.BLACK);
				g.setFont(titleFont);
				g.drawString("Ninja Master!", 20, 203);
				g.setColor(Color.RED);
				g.setFont(titleFont);
				g.drawString("Ninja Master!", 17, 200);
			break;
			case 1:
				g.setColor(Color.BLACK);
				g.setFont(titleFont);
				g.drawString("MarshMaster!", 13, 203);
				g.setColor(Color.RED);
				g.setFont(titleFont);
				g.drawString("MarshMaster!", 10, 200);
				break;
			case 2:
				g.setColor(Color.BLACK);
				g.setFont(titleFont);
				g.drawString("Cheese", 103, 173);
				g.setColor(Color.RED);
				g.setFont(titleFont);
				g.drawString("Cheese", 100, 170);
				g.setColor(Color.BLACK);
				g.setFont(titleFont);
				g.drawString("Master!", 103, 253);
				g.setColor(Color.RED);
				g.setFont(titleFont);
				g.drawString("Master!", 100, 250);
				break;
			case 3:
				g.setColor(Color.BLACK);
				g.setFont(titleFont);
				g.drawString("ToToRo", 103, 173);
				g.setColor(Color.RED);
				g.setFont(titleFont);
				g.drawString("ToToRo", 100, 170);
				g.setColor(Color.BLACK);
				g.setFont(titleFont);
				g.drawString("Master!", 108, 253);
				g.setColor(Color.RED);
				g.setFont(titleFont);
				g.drawString("Master!", 105, 250);
				break;
			}
			
		}
		
		
	
		switch (skinState) {
		case 0:
			g.setColor(Color.BLACK);
			g.setFont(nontitle);
			g.drawString("You totally wrecked " + manager.score, 118, 302);
			g.setColor(Color.RED);
			g.drawString("You totally wrecked " + manager.score, 116, 300);
			g.setColor(Color.BLACK);
			g.drawString("cookie monsters", 152, 352);
			g.setColor(Color.RED);
			g.drawString("cookie monsters", 150, 350);
		break;
		case 1:
			g.setColor(Color.BLACK);
			g.setFont(nontitle);
			g.drawString("You absorbed " + manager.score, 136, 302);
			g.setColor(Color.RED);
			g.drawString("You absorbed " + manager.score, 134, 300);
			g.setColor(Color.BLACK);
			g.drawString("fireballs", 186, 352);
			g.setColor(Color.RED);
			g.drawString("fireballs", 184, 350);
		break;
		case 2:
			g.setColor(Color.BLACK);
			g.setFont(nontitle);
			g.drawString("You destroyed " + manager.score, 132, 302);
			g.setColor(Color.RED);
			g.drawString("You destroyed " + manager.score, 130, 300);
			g.setColor(Color.BLACK);
			g.drawString("knives", 202, 352);
			g.setColor(Color.RED);
			g.drawString("knives", 200, 350);
		break;
		case 3:
			g.setColor(Color.BLACK);
			g.setFont(nontitle);
			g.drawString("You scattered " + manager.score, 142, 302);
			g.setColor(Color.GRAY);
			g.drawString("You scattered " + manager.score, 140, 300);
			g.setColor(Color.BLACK);
			g.drawString("dust spirits", 174, 352);
			g.setColor(Color.GRAY);
			g.drawString("dust spirits", 172, 350);
			g.setColor(Color.BLACK);
			g.drawString("and", 220, 392);
			g.setColor(Color.RED);
			g.drawString("and", 218, 390);
			g.setColor(Color.BLACK);
			g.setFont(nontitle);
			g.drawString("collected " + manager.secondScore, 172, 442);
			g.setColor(Color.ORANGE);
			g.drawString("collected " + manager.secondScore, 170, 440);
			g.setColor(Color.BLACK);
			g.drawString("acorns", 200, 494);
			g.setColor(Color.ORANGE);
			g.drawString("acorns", 198, 492);
		break;
		}
		// g.drawString("fatally injurers", 160, 350);
		g.setColor(Color.BLACK);
		g.setFont(subtitleFont);
		g.drawString("Press enter to proceed", 52, 612);
		g.setColor(Color.RED);
		g.drawString("Press enter to proceed", 50, 610);

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
			musicPlayer.stopSound();
			//musicPlayer.playMusic(currentState);
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
									+ "\nYou can test out the controls on this screen but \nin the real game you only have 1 double jump.");
				break;
				case 1:
					JOptionPane.showMessageDialog(null,
							"Use the side arrows to move side to side and the up arrow to jump.\nJump on the fireballs "
									+ "to make them fall but \nmake sure not to hit them from below or you will melt into the fire"
									+ ".\nDon't fall too fast, or you will fall through \nthe logs and into the fire below"
									+ "\nYou can test out the controls on this screen but \nin the real game you only have 1 double jump.");
				break;
				case 2:
					JOptionPane.showMessageDialog(null,
							"Use the side arrows to move side to side and the up arrow to jump.\nJump on the knifes "
									+ "to make them fall but \nmake sure not to hit them from below or you will cut into crumbs"
									+ ".\nDon't fall too fast, or you will fall through \nthe plates and onto the floor below"
									+ "\nYou can test out the controls on this screen but \nin the real game you only have 1 double jump.");
				break;
				case 3:
					JOptionPane.showMessageDialog(null,
							"Use the side arrows to move side to side and the up arrow to jump.\nJump on the dust spirits "
									+ "to make them fall but \nmake sure not to hit them from below or you will fall instead"
									+ ".\nCollecting acorns will give you special points.\nDon't fall too fast, or you will fall through \nthe logs and into the abyss below"
									+ "\nYou can test out the controls on this screen but \nin the real game you only have 1 double jump.");
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
			if(!(currentState==1)) {
			musicPlayer.stopSound();
			}
			//musicPlayer.playMusic(currentState);

			if (currentState > endState) {

				currentState = menuState;

			}

			if (currentState == menuState) {
				background = new Background(0, -1 * Ninjoreo.height, Ninjoreo.width, Ninjoreo.height);
				ninjoreo = new Oreo(200, 650, 50, 50);
				manager = new ObjectManager(ninjoreo, background, musicPlayer);
				musicPlayer.playMusic(currentState);
			}

		}
		if (e.getKeyCode() == 38||e.getKeyCode()==32) {
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
			if(skinState>3) {
				skinState=0;
			}
			if(skinState==marshMaulerSkin) {
				skinState=marshMaulerSkin;
			}
			if(skinState==ninCheezitSkin) {
				skinState=ninCheezitSkin;
			}
			if(skinState==totoroSkin) {
				skinState=totoroSkin;
			}
			musicPlayer.stopSound();
			//musicPlayer.playMusic(currentState);
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
