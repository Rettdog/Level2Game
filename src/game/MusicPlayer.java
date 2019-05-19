package game;

import java.applet.AudioClip;
import java.io.File;

import javax.print.attribute.standard.Media;
import javax.swing.JApplet;

public class MusicPlayer {
	boolean playing;
	AudioClip sound;
	public int musicSpeed;


	MusicPlayer() {
		playing = false;
		
		musicSpeed = 0;
	}
	public void playTitleSong() {
		//playSound("testsong.wav");
		playSound("gameTitleNormal.mp3");
		
	}

	public void playMusic(int state) {
		int skin = GamePanel.skinState;
		 
		if (playing == false) {

			switch (skin) {
			case 0:
				switch (state) {
				case 0:
					System.out.println("playing test song");
					playSound("testsong.wav");

					break;
				case 1:
					// gameState
					switch (musicSpeed) {
					case 0:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					case 1:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					case 2:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					}

					break;
				case 2:
					System.out.println("playing test song");
					playSound("testsong.wav");

					break;
				}
				break;
			case 1:
				switch (state) {
				case 0:
					System.out.println("playing test song");
					playSound("testsong.wav");

					break;
				case 1:
					// gameState
					switch (musicSpeed) {
					case 0:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					case 1:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					case 2:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					}

					break;
				case 2:
					System.out.println("playing test song");
					playSound("testsong.wav");

					break;
				}
				break;
			case 2:
				switch (state) {
				case 0:
					System.out.println("playing test song");
					playSound("testsong.wav");

					break;
				case 1:
					// gameState
					switch (musicSpeed) {
					case 0:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					case 1:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					case 2:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					}

					break;
				case 2:
					System.out.println("playing test song");
					playSound("testsong.wav");

					break;
				}
				break;
			case 3:
				switch (state) {
				case 0:
					System.out.println("playing test song");
					playSound("testsong.wav");

					break;
				case 1:
					// gameState
					switch (musicSpeed) {
					case 0:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					case 1:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					case 2:
						System.out.println("playing test song");
						playSound("testsong.wav");
						break;
					}

					break;
				case 2:
					System.out.println("playing test song");
					playSound("testsong.wav");

					break;
				}
				break;
			}
		}

	}

	private void playSound(String fileName) {
		sound = JApplet.newAudioClip(getClass().getResource(fileName));

		sound.loop();
		playing = true;
	}
	private void playMP3() {
		
	}

	public void stopSound() {
		sound.stop();
		playing = false;
	}
}
