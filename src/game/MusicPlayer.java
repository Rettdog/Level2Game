package game;

import java.applet.AudioClip;
import javax.swing.JApplet;

public class MusicPlayer {
	boolean playing;
	AudioClip sound;
	public int musicSpeed;
	boolean titlePlayed = false;

	MusicPlayer() {
		playing = false;

		musicSpeed = 0;
	}

	public void playTitleSong() {
		// playSound("testsong.wav");
		if (!titlePlayed) {
			playSound("gameTitleNormal.wav");
		}
	}

	public void playMusic(int state) {
		int skin = GamePanel.skinState;

		if (playing == false) {

			switch (skin) {
			case 0:
				switch (state) {
				case 0:
					System.out.println("playing ninjoreo normal");
					playSound("ninjoreoNormal.wav");

					break;
				case 1:
					// gameState
					switch (musicSpeed) {
					case 0:
						System.out.println("playing ninjoreo normal");
						playSound("ninjoreoNormal.wav");
						break;
					case 1:
						System.out.println("playing nijoreo fast");
						playSound("ninjoreoFast.wav");
						break;
					case 2:
						System.out.println("playing ninjoreo fastest");
						playSound("ninjoreoFastest.wav");
						break;
					}

					break;
				case 2:
					System.out.println("playing ninjoreo gameover");
					playSound("ninjoreoGameOver.wav");

					break;
				}
				break;
			case 1:
				switch (state) {
				case 0:
					System.out.println("playing marshMauler normal");
					playSound("marshMaulerNormal.wav");

					break;
				case 1:
					// gameState
					switch (musicSpeed) {
					case 0:
						System.out.println("playing marshMauler normal");
						playSound("marshMaulerNormal.wav");
						break;
					case 1:
						System.out.println("playing marshMauler fast");
						playSound("marshMaulerFast.wav");
						break;
					case 2:
						System.out.println("playing marshMauler fastest");
						playSound("marshMaulerFastest.wav");
						break;
					}

					break;
				case 2:
					System.out.println("playing marshMauler gameover");
					playSound("marshMaulerGameOver.wav");

					break;
				}
				break;
			case 2:
				switch (state) {
				case 0:
					System.out.println("playing nincheezit normal");
					playSound("nincheezitNormal.wav");

					break;
				case 1:
					// gameState
					switch (musicSpeed) {
					case 0:
						System.out.println("playing nincheezit normal");
						playSound("nincheezitNormal.wav");
						break;
					case 1:
						System.out.println("playing nincheezit fast");
						playSound("nincheezitFast.wav");
						break;
					case 2:
						System.out.println("playing nincheezit fastest");
						playSound("nincheezitFastest.wav");
						break;
					}

					break;
				case 2:
					System.out.println("playing marshMauler gameover");
					playSound("nincheezitGameOver.wav");

					break;
				}
				break;
			case 3:
				switch (state) {
				case 0:
					System.out.println("playing totoro normal");
					playSound("totoroNormal.wav");

					break;
				case 1:
					// gameState
					switch (musicSpeed) {
					case 0:
						System.out.println("playing totoro normal");
						playSound("totoroNormal.wav");
						break;
					case 1:
						System.out.println("playing totoro fast");
						playSound("totoroFast.wav");
						break;
					case 2:
						System.out.println("playing totoro fastest");
						playSound("totoroFastest.wav");
						break;
					}

					break;
				case 2:
					System.out.println("playing totoro gameover");
					dontLoop("totoroGameOver.wav");

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
	private void dontLoop(String fileName) {
		sound = JApplet.newAudioClip(getClass().getResource(fileName));

		sound.play();
		playing = true;
	}

	

	public void stopSound() {
		sound.stop();
		playing = false;
	}
}
